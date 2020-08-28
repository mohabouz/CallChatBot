package com.mapps.callchatbot.model;

/**
 * Created by MohammedBouzaid on 01-Dec-18.
 */

public class Application {

    String appName;
    String appPackageName;
    String appIcon;

    public Application(String appName, String appPackageName, String appIcon) {
        this.appName = appName;
        this.appPackageName = appPackageName;
        this.appIcon = appIcon;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppPackageName() {
        return appPackageName;
    }

    public void setAppPackageName(String appPackageName) {
        this.appPackageName = appPackageName;
    }

    public String getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(String appIcon) {
        this.appIcon = appIcon;
    }
}
