package com.github.anastasiazhukova.jsonparser.Parser.Json;

import com.github.anastasiazhukova.jsonparser.Parser.IUser;
import com.github.anastasiazhukova.jsonparser.Parser.IUserParser;
import com.github.anastasiazhukova.jsonparser.Utils.IOUtils;

import org.json.JSONObject;

import java.io.InputStream;

public class UserParserJson implements IUserParser {

    private final InputStream mInputStream;

    public UserParserJson(final InputStream pInputStream) {
        mInputStream = pInputStream;
    }

    @Override
    public IUser parse() throws Exception {
        final JSONObject jsonObject = new JSONObject(IOUtils.toString(mInputStream));
        return new UserJson(jsonObject);
    }
}
