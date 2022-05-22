package com.springframework.learn.entity;

public class Girl {

    private String name;
    private String height;
    private String breast;
    private String legLength;

    private boolean pregnant;

    public boolean isPregnant() {
        return pregnant;
    }

    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                ", height='" + height + '\'' +
                ", breast='" + breast + '\'' +
                ", legLength='" + legLength + '\'' +
                ", pregnant=" + pregnant +
                '}';
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getBreast() {
        return breast;
    }

    public void setBreast(String breast) {
        this.breast = breast;
    }

    public String getLegLength() {
        return legLength;
    }

    public void setLegLength(String legLength) {
        this.legLength = legLength;
    }
}
