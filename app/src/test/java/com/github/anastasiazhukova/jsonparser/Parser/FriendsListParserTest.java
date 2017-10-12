package com.github.anastasiazhukova.jsonparser.Parser;

import com.github.anastasiazhukova.jsonparser.BuildConfig;
import com.github.anastasiazhukova.jsonparser.Constants.Constants;
import com.github.anastasiazhukova.jsonparser.HttpClient.IHttpClient;
import com.github.anastasiazhukova.jsonparser.Mocks.InputStreamMocks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(
        constants = BuildConfig.class,
        sdk = Constants.SDK_VERSION
)
public class FriendsListParserTest {

    private static final String TAG = FriendsListParserTest.class.getSimpleName();

    private static final int EXPECTED_LIST_SIZE=3;
    private static final int EXPECTED_ID = 0;
    private static final String EXPECTED_NAME = "Frazier Tyler";

    private InputStream mInputStream;
    private IHttpClient mIHttpClient;

    @Before
    public void setUp() {
        mIHttpClient = mock(IHttpClient.class);
    }

    private static String mJSONFileSource = "ListOfObjects/friends.json";

    @Test
    public void parseForJSON() throws Exception {
        mInputStream = InputStreamMocks.inputStream(mJSONFileSource);
        when(mIHttpClient.request(Matchers.anyString())).thenReturn(mInputStream);
        InputStream response = mIHttpClient.request("any http");
        final FriendsListParserFactory friendsListParserFactory = new FriendsListParserFactory();
        final IFriendsList friends = friendsListParserFactory.createListParserForJSON(response).parse();
        List<IFriend> friendList=friends.getFriendsList();
        assertEquals(friends.getFriendsList().size(), EXPECTED_LIST_SIZE);
        assertEquals(friendList.get(0).getId(), EXPECTED_ID);
        assertEquals(friendList.get(0).getName(), EXPECTED_NAME);

    }
}