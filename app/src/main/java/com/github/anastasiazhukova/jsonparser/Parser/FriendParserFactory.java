package com.github.anastasiazhukova.jsonparser.Parser;

import com.github.anastasiazhukova.jsonparser.Parser.Json.FriendParserJson;

import java.io.InputStream;

public class FriendParserFactory {

    IFriendParser createParserForJSON(InputStream pInputStream) {
        return new FriendParserJson(pInputStream);
    }
}
