package com.github.anastasiazhukova.jsonparser.Parser;

import com.github.anastasiazhukova.jsonparser.Parser.Gson.FriendParserGson;
import com.github.anastasiazhukova.jsonparser.Parser.Json.FriendParserJson;

import java.io.InputStream;

public class FriendParserFactory {

    IFriendParser createParserForJson(final InputStream pInputStream) {
        return new FriendParserJson(pInputStream);
    }

    IFriendParser createParserForGson(final InputStream pInputStream) {
        return new FriendParserGson(pInputStream);
    }
}
