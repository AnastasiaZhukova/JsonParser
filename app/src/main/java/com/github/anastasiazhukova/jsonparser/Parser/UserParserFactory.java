package com.github.anastasiazhukova.jsonparser.Parser;

import com.github.anastasiazhukova.jsonparser.Parser.Gson.UserParserGson;
import com.github.anastasiazhukova.jsonparser.Parser.Json.UserParserJson;

import java.io.InputStream;

public class UserParserFactory {

    public IUserParser createParserJSON(final InputStream pInputStream) {
        return new UserParserJson(pInputStream);
    }

    public IUserParser createParserGSON(final InputStream pInputStream) {
        return new UserParserGson(pInputStream);
    }
}
