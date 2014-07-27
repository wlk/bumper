package com.varwise.bumper;

/**
 * Created by rembam on 12.07.14.
 */
public class ScreenInformation {
    private String screenName;
    private String bottomInformation;
    private Integer number;
    private Boolean done;

    public String getScreenName() {
        return screenName;
    }
    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }
    public String getBottomInformation() {
        return bottomInformation;
    }
    public void setBottomInformation(String bottomInformation) {
        this.bottomInformation = bottomInformation;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public Boolean getDone() {
        return done;
    }
    public void setDone(Boolean number) {
        this.done = number;
    }
}
