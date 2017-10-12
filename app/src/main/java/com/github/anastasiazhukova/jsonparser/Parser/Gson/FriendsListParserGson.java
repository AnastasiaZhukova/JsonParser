package com.github.anastasiazhukova.jsonparser.Parser.Gson;

import com.github.anastasiazhukova.jsonparser.Parser.IFriendsList;
import com.github.anastasiazhukova.jsonparser.Parser.IFriendsListParser;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

public class FriendsListParserGson implements IFriendsListParser {

    private final InputStream mInputStream;

    public FriendsListParserGson(InputStream pInputStream) {
        mInputStream = pInputStream;
    }

    @Override
    public IFriendsList parse() throws Exception {
        Reader reader = new InputStreamReader(mInputStream);
        FriendGson[] result = new Gson().fromJson(reader, FriendGson[].class);
        return new FriendsListGson(Arrays.asList(result));
    }

}
