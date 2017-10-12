package com.github.anastasiazhukova.jsonparser.Parser.Json;

import com.github.anastasiazhukova.jsonparser.Parser.IFriendsList;
import com.github.anastasiazhukova.jsonparser.Parser.IFriendsListParser;
import com.github.anastasiazhukova.jsonparser.Utils.IOUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FriendsListParserJson implements IFriendsListParser {

    private final InputStream mInputStream;
    private final JSONArray mJsonArray;

    public FriendsListParserJson(InputStream pInputStream) {
        mInputStream = pInputStream;
        mJsonArray = null;
    }

    public FriendsListParserJson(JSONArray pJsonArray) {
        mJsonArray = pJsonArray;
        mInputStream = null;
    }

    @Override
    public IFriendsList parse() throws Exception {
        if (mInputStream != null) {
            return parseFromInputSteam();
        } else if (mJsonArray != null) {
            return parseFromJsonArray();
        } else {
            throw new Exception();
        }
    }

    private IFriendsList parseFromInputSteam() throws Exception {
        JSONArray jsonArray = new JSONArray(IOUtils.toString(mInputStream));
        List<FriendJson> friendsJsonList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            friendsJsonList.add(new FriendJson(jsonObject));
        }
        return new FriendsListJson(friendsJsonList);
    }

    private IFriendsList parseFromJsonArray() throws Exception {
        List<FriendJson> friendsJsonList = new ArrayList<>();
        for (int i = 0; i < mJsonArray.length(); i++) {
            JSONObject jsonObject = mJsonArray.getJSONObject(i);
            friendsJsonList.add(new FriendJson(jsonObject));
        }
        return new FriendsListJson(friendsJsonList);
    }
}
