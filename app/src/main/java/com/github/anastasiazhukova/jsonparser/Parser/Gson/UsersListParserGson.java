package com.github.anastasiazhukova.jsonparser.Parser.Gson;

import com.github.anastasiazhukova.jsonparser.Parser.IUsersList;
import com.github.anastasiazhukova.jsonparser.Parser.IUsersListParser;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

public class UsersListParserGson implements IUsersListParser {

    private InputStream mInputStream;

    public UsersListParserGson(final InputStream pInputStream) {
        mInputStream = pInputStream;
    }

    @Override
    public IUsersList parse() throws Exception {
        final Reader reader = new InputStreamReader(mInputStream);
        final UserGson[] result = new Gson().fromJson(reader, UserGson[].class);
        return new UsersListGson(Arrays.asList(result));
    }
}

