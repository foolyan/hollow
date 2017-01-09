package com.netflix.vms.transformer.hollowinput;

import com.netflix.hollow.objects.delegate.HollowObjectAbstractDelegate;
import com.netflix.hollow.read.dataaccess.HollowObjectTypeDataAccess;
import com.netflix.hollow.HollowObjectSchema;

@SuppressWarnings("all")
public class VideoGeneralDelegateLookupImpl extends HollowObjectAbstractDelegate implements VideoGeneralDelegate {

    private final VideoGeneralTypeAPI typeAPI;

    public VideoGeneralDelegateLookupImpl(VideoGeneralTypeAPI typeAPI) {
        this.typeAPI = typeAPI;
    }

    public long getVideoId(int ordinal) {
        return typeAPI.getVideoId(ordinal);
    }

    public Long getVideoIdBoxed(int ordinal) {
        return typeAPI.getVideoIdBoxed(ordinal);
    }

    public boolean getTv(int ordinal) {
        return typeAPI.getTv(ordinal);
    }

    public Boolean getTvBoxed(int ordinal) {
        return typeAPI.getTvBoxed(ordinal);
    }

    public int getAliasesOrdinal(int ordinal) {
        return typeAPI.getAliasesOrdinal(ordinal);
    }

    public int getVideoTypeOrdinal(int ordinal) {
        return typeAPI.getVideoTypeOrdinal(ordinal);
    }

    public long getRuntime(int ordinal) {
        return typeAPI.getRuntime(ordinal);
    }

    public Long getRuntimeBoxed(int ordinal) {
        return typeAPI.getRuntimeBoxed(ordinal);
    }

    public int getSupplementalSubTypeOrdinal(int ordinal) {
        return typeAPI.getSupplementalSubTypeOrdinal(ordinal);
    }

    public long getFirstReleaseYear(int ordinal) {
        return typeAPI.getFirstReleaseYear(ordinal);
    }

    public Long getFirstReleaseYearBoxed(int ordinal) {
        return typeAPI.getFirstReleaseYearBoxed(ordinal);
    }

    public boolean getTestTitle(int ordinal) {
        return typeAPI.getTestTitle(ordinal);
    }

    public Boolean getTestTitleBoxed(int ordinal) {
        return typeAPI.getTestTitleBoxed(ordinal);
    }

    public int getOriginalLanguageBcpCodeOrdinal(int ordinal) {
        return typeAPI.getOriginalLanguageBcpCodeOrdinal(ordinal);
    }

    public int getMetadataReleaseDays(int ordinal) {
        return typeAPI.getMetadataReleaseDays(ordinal);
    }

    public Integer getMetadataReleaseDaysBoxed(int ordinal) {
        return typeAPI.getMetadataReleaseDaysBoxed(ordinal);
    }

    public int getOriginCountryCodeOrdinal(int ordinal) {
        return typeAPI.getOriginCountryCodeOrdinal(ordinal);
    }

    public int getOriginalTitleOrdinal(int ordinal) {
        return typeAPI.getOriginalTitleOrdinal(ordinal);
    }

    public int getTestTitleTypesOrdinal(int ordinal) {
        return typeAPI.getTestTitleTypesOrdinal(ordinal);
    }

    public int getOriginalTitleBcpCodeOrdinal(int ordinal) {
        return typeAPI.getOriginalTitleBcpCodeOrdinal(ordinal);
    }

    public int getInternalTitleOrdinal(int ordinal) {
        return typeAPI.getInternalTitleOrdinal(ordinal);
    }

    public int getEpisodeTypesOrdinal(int ordinal) {
        return typeAPI.getEpisodeTypesOrdinal(ordinal);
    }

    public int getRegulatoryAdvisoriesOrdinal(int ordinal) {
        return typeAPI.getRegulatoryAdvisoriesOrdinal(ordinal);
    }

    public VideoGeneralTypeAPI getTypeAPI() {
        return typeAPI;
    }

    @Override
    public HollowObjectSchema getSchema() {
        return typeAPI.getTypeDataAccess().getSchema();
    }

    @Override
    public HollowObjectTypeDataAccess getTypeDataAccess() {
        return typeAPI.getTypeDataAccess();
    }

}