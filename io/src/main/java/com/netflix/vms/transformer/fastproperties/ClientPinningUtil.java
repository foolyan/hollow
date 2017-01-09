package com.netflix.vms.transformer.fastproperties;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.netflix.config.NetflixConfiguration;
import com.netflix.config.NetflixConfiguration.EnvironmentEnum;
import com.netflix.config.NetflixConfiguration.RegionEnum;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ClientPinningUtil {

    private static final String propertyNameSuffix = "com.netflix.vmsconfig.pin.version";
    private static final String hermesAnnouncementPropertyNameSuffix = "hermesns.vms.hollow.blob";
    
	private static String discoveryUrl = "http://discovery.cloudqa.netflix.net:7001/discovery/resolver/cluster/gutenbergservice-consumer";
	private static String urlPath = "/REST/consume-service/publish/info/vms.hollow.blob.";

	public static Map<RegionEnum, String> getAnnouncedVersions(String vip) {
		CloseableHttpClient httpClient  = null;
		try {
			httpClient = HttpClients.createDefault();
			HttpGet get = new HttpGet(discoveryUrl + urlPath + vip);
			CloseableHttpResponse response = httpClient.execute(get);
			HttpEntity entity = response.getEntity();
			String json = EntityUtils.toString(entity);
			return consumeJson(json);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();				
			} catch(Exception e) {
				// ignore
			}
		}
		
		// Return a version
		return null;
	}


    public static void unpinClients(String vipName, RegionEnum region) throws IOException {

        // Figure out the key of the property
        String key = propertyNameSuffix + "." + vipName;
        PersistedPropertiesUtil.deleteFastProperty(key,
                null,                                         // no appId
                NetflixConfiguration.getEnvironmentEnum(),
                region,
                null,                                         // no serverId
                null,                                         // no stack
                null);                                        // no countries
    }

    /**
     * Pins client in a vip to a specific version.
     * Pinning is done by creating / updating fast properties through odin
     * @param vipName
     * @param blobVersion
     * @throws PersistedPropertiesException
     */
    public static void pinClients(String vipName, String blobVersion, RegionEnum region) throws IOException {

        // Determine if the key already exists
        String key = propertyNameSuffix + "." + vipName;
        EnvironmentEnum env = NetflixConfiguration.getEnvironmentEnum();
        boolean exists = PersistedPropertiesUtil.fastPropertyExists(key, null, env, region, null, null, null);
        if(exists) {
            // Update property
            PersistedPropertiesUtil.updateFastProperty(key, blobVersion, null, env, region, null, null, null);
        } else {
            // create property
            PersistedPropertiesUtil.createFastProperty(key, blobVersion, null, env, region, null, null, null);
        }

    }


    public static String getPinnedVersion(String vipName, RegionEnum region) throws IOException {
        String key = propertyNameSuffix + "." + vipName;
        EnvironmentEnum env = NetflixConfiguration.getEnvironmentEnum();
        if(!PersistedPropertiesUtil.fastPropertyExists(key, null, env, region, null, null, null))
            return null;
        return PersistedPropertiesUtil.getFastPropertyValue(key, null, env, region, null, null, null);
    }

	private static Map<RegionEnum, String> consumeJson(String json) {
		Map<RegionEnum, String> announcedVersions = new Hashtable<RegionEnum, String>();
		JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
		JsonArray publishInfos = jsonObject.get("topicPublishInfos").getAsJsonArray();
		for(int i = 0; i < publishInfos.size(); i++) {
			JsonObject publishInfo = publishInfos.get(i).getAsJsonObject();
			// Extract region
			JsonObject publishTag = publishInfo.get("publishTag").getAsJsonObject();
			String publishTagValue = publishTag.get("value").getAsString();
			String regionStr = getRegionFromPublishTag(publishTagValue);
			RegionEnum region = RegionEnum.toEnum(regionStr);
			
			// Extract announced version
			JsonObject metadata = publishInfo.get("metadata").getAsJsonObject();
			String hermesDataPointerJson = metadata.get("__hermes_datapointer__").getAsString();
			String version = getDataVersionFromHermesDataPointer(hermesDataPointerJson);
			
			announcedVersions.put(region, version);
		}
		return announcedVersions;
	}
	
	private static String getDataVersionFromHermesDataPointer(String json) {
		JsonObject dataPointer = new JsonParser().parse(json).getAsJsonObject();
		String dataString = dataPointer.get("dataString").getAsString();
		
		JsonObject data = new JsonParser().parse(dataString).getAsJsonObject();
		JsonObject dataAttributes = data.get("attributes").getAsJsonObject();
		String dataVersion = dataAttributes.get("dataVersion").getAsString();
		
		return dataVersion;
	}
	
	private static String getRegionFromPublishTag(String tagValue) {
		String[] tokens = tagValue.split("\\|");
		return tokens[1];
	}


}