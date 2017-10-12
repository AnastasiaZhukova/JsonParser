package com.github.anastasiazhukova.jsonparser.Parser.Gson;

import com.github.anastasiazhukova.jsonparser.Parser.IFriend;
import com.github.anastasiazhukova.jsonparser.Parser.IFriendParser;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class FriendParserGson implements IFriendParser {

    private final InputStream mInputStream;

    public FriendParserGson(InputStream pInputStream) {
        mInputStream = pInputStream;
    }

    @Override
    public IFriend parse() throws Exception {
        Reader reader = new InputStreamReader(mInputStream);
        return new Gson().fromJson(reader, FriendGson.class);
    }
}
