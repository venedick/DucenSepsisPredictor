package com.ducen.predictor.r4.types;

public class Meta {

    private String versionId;
    private String lastUpdated;
    private String source;

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Meta() {

    }

    public Meta(String versionId, String lastUpdated, String source) {
        this.versionId = versionId;
        this.lastUpdated = lastUpdated;
        this.source = source;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "versionId='" + versionId + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
