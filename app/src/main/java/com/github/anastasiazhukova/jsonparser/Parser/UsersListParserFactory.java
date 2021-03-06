package com.github.anastasiazhukova.jsonparser.Parser;

import com.github.anastasiazhukova.jsonparser.Parser.Gson.UsersListParserGson;
import com.github.anastasiazhukova.jsonparser.Parser.Json.UsersListParserJson;

import java.io.InputStream;

public class UsersListParserFactory {

    public IUsersListParser createListParserForJSON(final InputStream pInputStream) {
        return new UsersListParserJson(pInputStream);
    }

    public IUsersListParser createListParserForGSON(final InputStream pInputStream) {
        return new UsersListParserGson(pInputStream);
    }
}
