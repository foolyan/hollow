package com.netflix.vms.transformer.hollowinput;

import com.netflix.hollow.read.customapi.HollowObjectTypeAPI;
import com.netflix.hollow.read.dataaccess.HollowObjectTypeDataAccess;

@SuppressWarnings("all")
public class DrmInfoStringTypeAPI extends HollowObjectTypeAPI {

    private final DrmInfoStringDelegateLookupImpl delegateLookupImpl;

    DrmInfoStringTypeAPI(VMSHollowInputAPI api, HollowObjectTypeDataAccess typeDataAccess) {
        super(api, typeDataAccess, new String[] {
            "value"
        });
        this.delegateLookupImpl = new DrmInfoStringDelegateLookupImpl(this);
    }

    public String getValue(int ordinal) {
        if(fieldIndex[0] == -1)
            return missingDataHandler().handleString("DrmInfoString", ordinal, "value");
        boxedFieldAccessSampler.recordFieldAccess(fieldIndex[0]);
        return getTypeDataAccess().readString(ordinal, fieldIndex[0]);
    }

    public boolean isValueEqual(int ordinal, String testValue) {
        if(fieldIndex[0] == -1)
            return missingDataHandler().handleStringEquals("DrmInfoString", ordinal, "value", testValue);
        return getTypeDataAccess().isStringFieldEqual(ordinal, fieldIndex[0], testValue);
    }

    public DrmInfoStringDelegateLookupImpl getDelegateLookupImpl() {
        return delegateLookupImpl;
    }

    @Override
    public VMSHollowInputAPI getAPI() {
        return (VMSHollowInputAPI) api;
    }

}