package com.github.anastasiazhukova.jsonparser.Parser;

import com.github.anastasiazhukova.jsonparser.Parser.Json.FriendsListParserJson;

import org.json.JSONArray;

import java.io.InputStream;

public class FriendsListParserFactory {

    public IFriendsListParser createListParserForJSON(InputStream pInputStream) {
        return new FriendsListParserJson(pInputStream);
    }

    public IFriendsListParser createListParserForJSON(JSONArray pJSONArray) {
        return new FriendsListParserJson(pJSONArray);
    }
}
