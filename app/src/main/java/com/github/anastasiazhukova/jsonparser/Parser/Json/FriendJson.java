package com.github.anastasiazhukova.jsonparser.Parser.Json;

import com.github.anastasiazhukova.jsonparser.Parser.IFriend;

import org.json.JSONObject;

class FriendJson implements IFriend {

    private final String id = "id";
    private final String name = "name";

    private final JSONObject mJSONObject;

    FriendJson(final JSONObject pJSONObject) {
        mJSONObject = pJSONObject;
    }

    @Override
    public int getId() {
        return mJSONObject.optInt(id);
    }

    @Override
    public String getName() {
        return mJSONObject.optString(name);
    }
}
