package com.github.anastasiazhukova.jsonparser.Parser.Json;

import com.github.anastasiazhukova.jsonparser.Parser.IFriend;
import com.github.anastasiazhukova.jsonparser.Parser.IFriendsList;

import java.util.ArrayList;
import java.util.List;

public class FriendsListJson implements IFriendsList {

    private List<FriendJson> mFriendsList;

    public FriendsListJson(final List<FriendJson> pFriendsList) {
        mFriendsList = pFriendsList;
    }

    @Override
    public List<IFriend> getFriendsList() {
        final List<IFriend> friendsList = new ArrayList<>();
        for (final FriendJson friend :
                mFriendsList) {
            friendsList.add(friend);
        }
        return friendsList;
    }
}
