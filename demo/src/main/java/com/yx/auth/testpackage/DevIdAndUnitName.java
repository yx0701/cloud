package com.yx.auth.testpackage;

public class DevIdAndUnitName {
    private String devId;
    private String primaryUnitName;

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public String getPrimaryUnitName() {
        return primaryUnitName;
    }

    public void setPrimaryUnitName(String primaryUnitName) {
        this.primaryUnitName = primaryUnitName;
    }

    public DevIdAndUnitName(String devId, String primaryUnitName) {
        this.devId = devId;
        this.primaryUnitName = primaryUnitName;
    }
}
