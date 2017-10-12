package com.github.anastasiazhukova.jsonparser.Parser.Json;

import com.github.anastasiazhukova.jsonparser.Parser.IFriend;
import com.github.anastasiazhukova.jsonparser.Parser.IFriendParser;
import com.github.anastasiazhukova.jsonparser.Utils.IOUtils;

import org.json.JSONObject;

import java.io.InputStream;

public class FriendParserJson implements IFriendParser {

    private final InputStream mInputStream;

    public FriendParserJson(final InputStream pInputStream) {
        mInputStream = pInputStream;
    }

    @Override
    public IFriend parse() throws Exception {
        final JSONObject jsonObject = new JSONObject(IOUtils.toString(mInputStream));
        return new FriendJson(jsonObject);
    }
}
