package com.github.anastasiazhukova.jsonparser.Parser;

import com.github.anastasiazhukova.jsonparser.Parser.Json.UserParserJson;

import java.io.InputStream;

public class UserParserFactory {

    public IUserParser createParserJSON(InputStream pInputStream) {
        return new UserParserJson(pInputStream);
    }
}
