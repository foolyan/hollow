package com.netflix.vms.transformer.hollowinput;

import com.netflix.hollow.api.custom.HollowObjectTypeAPI;
import com.netflix.hollow.core.read.dataaccess.HollowObjectTypeDataAccess;

@SuppressWarnings("all")
public class DeployablePackagesTypeAPI extends HollowObjectTypeAPI {

    private final DeployablePackagesDelegateLookupImpl delegateLookupImpl;

    DeployablePackagesTypeAPI(VMSHollowInputAPI api, HollowObjectTypeDataAccess typeDataAccess) {
        super(api, typeDataAccess, new String[] {
            "packageId",
            "movieId",
            "countryCodes",
            "tags",
            "defaultPackage"
        });
        this.delegateLookupImpl = new DeployablePackagesDelegateLookupImpl(this);
    }

    public long getPackageId(int ordinal) {
        if(fieldIndex[0] == -1)
            return missingDataHandler().handleLong("DeployablePackages", ordinal, "packageId");
        return getTypeDataAccess().readLong(ordinal, fieldIndex[0]);
    }

    public Long getPackageIdBoxed(int ordinal) {
        long l;
        if(fieldIndex[0] == -1) {
            l = missingDataHandler().handleLong("DeployablePackages", ordinal, "packageId");
        } else {
            boxedFieldAccessSampler.recordFieldAccess(fieldIndex[0]);
            l = getTypeDataAccess().readLong(ordinal, fieldIndex[0]);
        }
        if(l == Long.MIN_VALUE)
            return null;
        return Long.valueOf(l);
    }



    public long getMovieId(int ordinal) {
        if(fieldIndex[1] == -1)
            return missingDataHandler().handleLong("DeployablePackages", ordinal, "movieId");
        return getTypeDataAccess().readLong(ordinal, fieldIndex[1]);
    }

    public Long getMovieIdBoxed(int ordinal) {
        long l;
        if(fieldIndex[1] == -1) {
            l = missingDataHandler().handleLong("DeployablePackages", ordinal, "movieId");
        } else {
            boxedFieldAccessSampler.recordFieldAccess(fieldIndex[1]);
            l = getTypeDataAccess().readLong(ordinal, fieldIndex[1]);
        }
        if(l == Long.MIN_VALUE)
            return null;
        return Long.valueOf(l);
    }



    public int getCountryCodesOrdinal(int ordinal) {
        if(fieldIndex[2] == -1)
            return missingDataHandler().handleReferencedOrdinal("DeployablePackages", ordinal, "countryCodes");
        return getTypeDataAccess().readOrdinal(ordinal, fieldIndex[2]);
    }

    public ISOCountrySetTypeAPI getCountryCodesTypeAPI() {
        return getAPI().getISOCountrySetTypeAPI();
    }

    public int getTagsOrdinal(int ordinal) {
        if(fieldIndex[3] == -1)
            return missingDataHandler().handleReferencedOrdinal("DeployablePackages", ordinal, "tags");
        return getTypeDataAccess().readOrdinal(ordinal, fieldIndex[3]);
    }

    public ListOfPackageTagsTypeAPI getTagsTypeAPI() {
        return getAPI().getListOfPackageTagsTypeAPI();
    }

    public boolean getDefaultPackage(int ordinal) {
        if(fieldIndex[4] == -1)
            return missingDataHandler().handleBoolean("DeployablePackages", ordinal, "defaultPackage") == Boolean.TRUE;
        return getTypeDataAccess().readBoolean(ordinal, fieldIndex[4]) == Boolean.TRUE;
    }

    public Boolean getDefaultPackageBoxed(int ordinal) {
        if(fieldIndex[4] == -1)
            return missingDataHandler().handleBoolean("DeployablePackages", ordinal, "defaultPackage");
        return getTypeDataAccess().readBoolean(ordinal, fieldIndex[4]);
    }



    public DeployablePackagesDelegateLookupImpl getDelegateLookupImpl() {
        return delegateLookupImpl;
    }

    @Override
    public VMSHollowInputAPI getAPI() {
        return (VMSHollowInputAPI) api;
    }

}