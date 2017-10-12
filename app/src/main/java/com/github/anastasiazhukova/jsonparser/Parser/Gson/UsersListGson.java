package com.github.anastasiazhukova.jsonparser.Parser.Gson;

import com.github.anastasiazhukova.jsonparser.Parser.IUser;
import com.github.anastasiazhukova.jsonparser.Parser.IUsersList;

import java.util.ArrayList;
import java.util.List;

public class UsersListGson implements IUsersList {

    private List<UserGson> mUsersGSON;

    public UsersListGson(final List<UserGson> pUsersGSON) {
        mUsersGSON = pUsersGSON;
    }

    @Override
    public List<IUser> getUsersList() {
        final List<IUser> users = new ArrayList<>();
        for (final UserGson user :
                mUsersGSON) {
            users.add(user);
        }
        return users;
    }
}
