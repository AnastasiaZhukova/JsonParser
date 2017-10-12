package com.github.anastasiazhukova.jsonparser.Parser;

import com.github.anastasiazhukova.jsonparser.Parser.Gson.FriendsListParserGson;
import com.github.anastasiazhukova.jsonparser.Parser.Json.FriendsListParserJson;

import org.json.JSONArray;

import java.io.InputStream;

public class FriendsListParserFactory {

    public IFriendsListParser createListParserForJSON(final InputStream pInputStream) {
        return new FriendsListParserJson(pInputStream);
    }

    public IFriendsListParser createListParserForJSON(final JSONArray pJSONArray) {
        return new FriendsListParserJson(pJSONArray);
    }

    public IFriendsListParser createListParserForGSON(final InputStream pInputStream) {
        return new FriendsListParserGson(pInputStream);
    }
}
