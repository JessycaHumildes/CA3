package com.jHumildes18303CA3.exercise3.database;


public class MyWarning {
    private String area;
    private String level;
    private String type;


    public MyWarning(String area, String level, String type) {
        this.area = area;
        this.level = level;
        this.type = type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MyWarning{" +
                "area='" + area + '\'' +
                ", level='" + level + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
