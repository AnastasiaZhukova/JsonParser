package com.github.anastasiazhukova.jsonparser.Parser.Json;

import com.github.anastasiazhukova.jsonparser.Parser.IUsersList;
import com.github.anastasiazhukova.jsonparser.Parser.IUsersListParser;
import com.github.anastasiazhukova.jsonparser.Utils.IOUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UsersListParserJson implements IUsersListParser {

    private final InputStream mInputStream;

    public UsersListParserJson(final InputStream pInputStream) {
        mInputStream = pInputStream;
    }

    @Override
    public IUsersList parse() throws Exception {
        final JSONArray jsonArray = new JSONArray(IOUtils.toString(mInputStream));
        final List<UserJson> usersJsonList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            final JSONObject jsonObject = jsonArray.getJSONObject(i);
            usersJsonList.add(new UserJson(jsonObject));
        }
        return new UsersListJson(usersJsonList);
    }
}
