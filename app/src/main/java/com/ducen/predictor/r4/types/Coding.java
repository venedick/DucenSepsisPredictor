package com.ducen.predictor.r4.types;

//get from R4 datatypes
public class Coding {

    private String system;
    private String version;
    private String code;
    private String display;
    private String userSelected;

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getUserSelected() {
        return userSelected;
    }

    public void setUserSelected(String userSelected) {
        this.userSelected = userSelected;
    }

    public Coding() {

    }

    public Coding(String system, String version, String code, String display, String userSelected) {
        this.system = system;
        this.version = version;
        this.code = code;
        this.display = display;
        this.userSelected = userSelected;
    }

    @Override
    public String toString() {
        return "Coding{" +
                "system='" + system + '\'' +
                ", version='" + version + '\'' +
                ", code='" + code + '\'' +
                ", display='" + display + '\'' +
                ", userSelected='" + userSelected + '\'' +
                '}';
    }
}
