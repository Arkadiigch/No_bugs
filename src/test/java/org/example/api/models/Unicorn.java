package org.example.api.models;

import com.google.gson.annotations.SerializedName;

public class Unicorn {
    private String name;
    private String tailColor;
    @SerializedName("_id")
    private String id;

    public Unicorn(String name, String tailColor) {
        this.name = name;
        this.tailColor = tailColor;
    }


    public void setTailColor(String newColor) {
        this.tailColor = newColor;
    }


    public String getName() {
        return name;
    }

    public String getTailColor() {
        return tailColor;
    }

    public String getId() {
        return id;
    }
}
