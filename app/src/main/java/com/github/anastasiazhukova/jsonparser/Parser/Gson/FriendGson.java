package com.github.anastasiazhukova.jsonparser.Parser.Gson;

import com.github.anastasiazhukova.jsonparser.Parser.IFriend;
import com.google.gson.annotations.SerializedName;

public class FriendGson implements IFriend {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
