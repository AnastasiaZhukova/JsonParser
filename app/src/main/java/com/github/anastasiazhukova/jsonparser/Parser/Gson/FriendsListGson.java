package com.github.anastasiazhukova.jsonparser.Parser.Gson;

import com.github.anastasiazhukova.jsonparser.Parser.IFriend;
import com.github.anastasiazhukova.jsonparser.Parser.IFriendsList;

import java.util.ArrayList;
import java.util.List;

public class FriendsListGson implements IFriendsList {

    private final List<FriendGson> mFriendsList;

    public FriendsListGson(final List<FriendGson> pFriendsList) {
        mFriendsList = pFriendsList;
    }

    @Override
    public List<IFriend> getFriendsList() {
        final List<IFriend> friendsList = new ArrayList<>();
        for (final FriendGson friend :
                mFriendsList) {
            friendsList.add(friend);
        }
        return friendsList;
    }
}
