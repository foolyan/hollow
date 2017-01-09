package com.netflix.vms.transformer.hollowinput;

import com.netflix.hollow.read.customapi.HollowObjectTypeAPI;
import com.netflix.hollow.read.dataaccess.HollowObjectTypeDataAccess;

@SuppressWarnings("all")
public class PackageDrmInfoTypeAPI extends HollowObjectTypeAPI {

    private final PackageDrmInfoDelegateLookupImpl delegateLookupImpl;

    PackageDrmInfoTypeAPI(VMSHollowInputAPI api, HollowObjectTypeDataAccess typeDataAccess) {
        super(api, typeDataAccess, new String[] {
            "contentPackagerPublicKey",
            "keySeed",
            "keyId",
            "drmKeyGroup",
            "key",
            "drmHeaderInfo",
            "keyDecrypted"
        });
        this.delegateLookupImpl = new PackageDrmInfoDelegateLookupImpl(this);
    }

    public int getContentPackagerPublicKeyOrdinal(int ordinal) {
        if(fieldIndex[0] == -1)
            return missingDataHandler().handleReferencedOrdinal("PackageDrmInfo", ordinal, "contentPackagerPublicKey");
        return getTypeDataAccess().readOrdinal(ordinal, fieldIndex[0]);
    }

    public StringTypeAPI getContentPackagerPublicKeyTypeAPI() {
        return getAPI().getStringTypeAPI();
    }

    public int getKeySeedOrdinal(int ordinal) {
        if(fieldIndex[1] == -1)
            return missingDataHandler().handleReferencedOrdinal("PackageDrmInfo", ordinal, "keySeed");
        return getTypeDataAccess().readOrdinal(ordinal, fieldIndex[1]);
    }

    public StringTypeAPI getKeySeedTypeAPI() {
        return getAPI().getStringTypeAPI();
    }

    public long getKeyId(int ordinal) {
        if(fieldIndex[2] == -1)
            return missingDataHandler().handleLong("PackageDrmInfo", ordinal, "keyId");
        return getTypeDataAccess().readLong(ordinal, fieldIndex[2]);
    }

    public Long getKeyIdBoxed(int ordinal) {
        long l;
        if(fieldIndex[2] == -1) {
            l = missingDataHandler().handleLong("PackageDrmInfo", ordinal, "keyId");
        } else {
            boxedFieldAccessSampler.recordFieldAccess(fieldIndex[2]);
            l = getTypeDataAccess().readLong(ordinal, fieldIndex[2]);
        }
        if(l == Long.MIN_VALUE)
            return null;
        return Long.valueOf(l);
    }



    public long getDrmKeyGroup(int ordinal) {
        if(fieldIndex[3] == -1)
            return missingDataHandler().handleLong("PackageDrmInfo", ordinal, "drmKeyGroup");
        return getTypeDataAccess().readLong(ordinal, fieldIndex[3]);
    }

    public Long getDrmKeyGroupBoxed(int ordinal) {
        long l;
        if(fieldIndex[3] == -1) {
            l = missingDataHandler().handleLong("PackageDrmInfo", ordinal, "drmKeyGroup");
        } else {
            boxedFieldAccessSampler.recordFieldAccess(fieldIndex[3]);
            l = getTypeDataAccess().readLong(ordinal, fieldIndex[3]);
        }
        if(l == Long.MIN_VALUE)
            return null;
        return Long.valueOf(l);
    }



    public int getKeyOrdinal(int ordinal) {
        if(fieldIndex[4] == -1)
            return missingDataHandler().handleReferencedOrdinal("PackageDrmInfo", ordinal, "key");
        return getTypeDataAccess().readOrdinal(ordinal, fieldIndex[4]);
    }

    public StringTypeAPI getKeyTypeAPI() {
        return getAPI().getStringTypeAPI();
    }

    public int getDrmHeaderInfoOrdinal(int ordinal) {
        if(fieldIndex[5] == -1)
            return missingDataHandler().handleReferencedOrdinal("PackageDrmInfo", ordinal, "drmHeaderInfo");
        return getTypeDataAccess().readOrdinal(ordinal, fieldIndex[5]);
    }

    public DrmHeaderInfoListTypeAPI getDrmHeaderInfoTypeAPI() {
        return getAPI().getDrmHeaderInfoListTypeAPI();
    }

    public boolean getKeyDecrypted(int ordinal) {
        if(fieldIndex[6] == -1)
            return missingDataHandler().handleBoolean("PackageDrmInfo", ordinal, "keyDecrypted") == Boolean.TRUE;
        return getTypeDataAccess().readBoolean(ordinal, fieldIndex[6]) == Boolean.TRUE;
    }

    public Boolean getKeyDecryptedBoxed(int ordinal) {
        if(fieldIndex[6] == -1)
            return missingDataHandler().handleBoolean("PackageDrmInfo", ordinal, "keyDecrypted");
        return getTypeDataAccess().readBoolean(ordinal, fieldIndex[6]);
    }



    public PackageDrmInfoDelegateLookupImpl getDelegateLookupImpl() {
        return delegateLookupImpl;
    }

    @Override
    public VMSHollowInputAPI getAPI() {
        return (VMSHollowInputAPI) api;
    }

}