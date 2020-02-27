package com.jHumildes18303CA3.exercise3.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ResponseWarning {
    @SerializedName("level")
    @Expose
    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
