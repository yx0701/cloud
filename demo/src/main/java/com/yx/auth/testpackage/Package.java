package com.yx.auth.testpackage;

import ch.qos.logback.classic.Level;

public class Package {
    String packageName;
    Level level;
    Package childs[];

    public Package(String packageName, Level level) {
        this.packageName = packageName;
        this.level = level;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Package[] getChilds() {
        return childs;
    }

    public void setChilds(Package[] childs) {
        this.childs = childs;
    }
}
