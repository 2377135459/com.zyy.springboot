package com.springboot.demo.bean;

import java.io.Serializable;

public class UserLand implements Serializable {
    private Long landId;
    private String landName;
    private String landPassword;

    public Long getLandId() {
        return landId;
    }

    public void setLandId(Long landId) {
        this.landId = landId;
    }

    public String getLandName() {
        return landName;
    }

    public void setLandName(String landName) {
        this.landName = landName;
    }

    public String getLandPassword() {
        return landPassword;
    }

    public void setLandPassword(String landPassword) {
        this.landPassword = landPassword;
    }

    @Override
    public String toString() {
        return "UserLand{" + "landId=" + landId + ", landName='" + landName + '\'' + ", landPassword='" + landPassword + '\'' + '}';
    }
}
