package com.github.anastasiazhukova.jsonparser.Parser.Gson;

import com.github.anastasiazhukova.jsonparser.Parser.IUser;
import com.github.anastasiazhukova.jsonparser.Parser.IUserParser;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class UserParserGson implements IUserParser {

    private final InputStream mInputStream;

    public UserParserGson(InputStream pInputStream) {
        mInputStream = pInputStream;
    }

    @Override
    public IUser parse() throws Exception {
        Reader reader = new InputStreamReader(mInputStream);
        return new Gson().fromJson(reader, UserGson.class);
    }

}
