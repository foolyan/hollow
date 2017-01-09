package com.netflix.vms.transformer.hollowinput;

import com.netflix.hollow.objects.HollowList;
import com.netflix.hollow.HollowListSchema;
import com.netflix.hollow.objects.delegate.HollowListDelegate;
import com.netflix.hollow.objects.generic.GenericHollowRecordHelper;

@SuppressWarnings("all")
public class VideoTypeMediaListHollow extends HollowList<VideoTypeMediaHollow> {

    public VideoTypeMediaListHollow(HollowListDelegate delegate, int ordinal) {
        super(delegate, ordinal);
    }

    @Override
    public VideoTypeMediaHollow instantiateElement(int ordinal) {
        return (VideoTypeMediaHollow) api().getVideoTypeMediaHollow(ordinal);
    }

    @Override
    public boolean equalsElement(int elementOrdinal, Object testObject) {
        return GenericHollowRecordHelper.equalObject(getSchema().getElementType(), elementOrdinal, testObject);
    }

    public VMSHollowInputAPI api() {
        return typeApi().getAPI();
    }

    public VideoTypeMediaListTypeAPI typeApi() {
        return (VideoTypeMediaListTypeAPI) delegate.getTypeAPI();
    }

}