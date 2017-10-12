package com.github.anastasiazhukova.jsonparser.Parser;

import com.github.anastasiazhukova.jsonparser.Parser.Json.UsersListParserJson;

import java.io.InputStream;

public class UsersListParserFactory {

    public IUsersListParser createListParserForJSON(InputStream pInputStream) {
        return new UsersListParserJson(pInputStream);
    }
}
