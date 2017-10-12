package com.github.anastasiazhukova.jsonparser.Parser.Json;

import com.github.anastasiazhukova.jsonparser.Parser.IUser;
import com.github.anastasiazhukova.jsonparser.Parser.IUsersList;

import java.util.ArrayList;
import java.util.List;

public class UsersListJson implements IUsersList {

    private final List<UserJson> mUsersList;

    public UsersListJson(final List<UserJson> pUsersList) {
        mUsersList = pUsersList;
    }

    @Override
    public List<IUser> getUsersList() {
        final List<IUser> usersList = new ArrayList<>();
        for (final UserJson user :
                mUsersList) {
            usersList.add(user);

        }
        return usersList;
    }
}
