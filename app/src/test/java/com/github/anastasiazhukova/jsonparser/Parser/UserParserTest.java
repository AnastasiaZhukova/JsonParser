package com.github.anastasiazhukova.jsonparser.Parser;

import android.util.Log;

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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(
        constants = BuildConfig.class,
        sdk = Constants.SDK_VERSION
)
public class UserParserTest {

    private static final String TAG = UserParserTest.class.getSimpleName();

    private static final String EXPECTED_ID = "59dbe02684a66bbe143b20d1";
    private static final String EXPECTED_NAME = "Shelia Chang";
    private static final int EXPECTED_TAGS_ARRAY_SIZE = 7;
    private static final int EXPECTED_FRIENDS_NUMBER = 3;
    private static final int EXPECTED_FIRST_FRIEND_ID = 0;

    private InputStream mInputStream;
    private IHttpClient mIHttpClient;

    @Before
    public void setUp() {
        mIHttpClient = mock(IHttpClient.class);
    }

    private static final String mJSONFileSource = "OneObject/user.json";

    @Test
    public void parseForJSON() throws Exception {
        mInputStream = InputStreamMocks.inputStream(mJSONFileSource);
        when(mIHttpClient.request(Matchers.anyString())).thenReturn(mInputStream);
        final InputStream response = mIHttpClient.request("any http");
        final UserParserFactory userParserFactory = new UserParserFactory();
        final IUser user = userParserFactory.createParserJSON(response).parse();
        assertEquals(user.getId(), EXPECTED_ID);
        assertEquals(user.getName(), EXPECTED_NAME);
        assertEquals(user.getTags().length, EXPECTED_TAGS_ARRAY_SIZE);
        assertEquals(user.getFriends().getFriendsList().size(), EXPECTED_FRIENDS_NUMBER);
        assertEquals(user.getFriends().getFriendsList().get(0).getId(), EXPECTED_FIRST_FRIEND_ID);
        Log.d(TAG, user.getFriendlyRegisteredTime().toString());
    }

    @Test
    public void parseForGSON() throws Exception {
        mInputStream = InputStreamMocks.inputStream(mJSONFileSource);
        when(mIHttpClient.request(Matchers.anyString())).thenReturn(mInputStream);
        final InputStream response = mIHttpClient.request("any http");
        final UserParserFactory userParserFactory = new UserParserFactory();
        final IUser user = userParserFactory.createParserGSON(response).parse();
        assertEquals(user.getId(), EXPECTED_ID);
        assertEquals(user.getName(), EXPECTED_NAME);
        assertEquals(user.getTags().length, EXPECTED_TAGS_ARRAY_SIZE);
        assertEquals(user.getFriends().getFriendsList().size(), EXPECTED_FRIENDS_NUMBER);
        assertEquals(user.getFriends().getFriendsList().get(0).getId(), EXPECTED_FIRST_FRIEND_ID);
        Log.d(TAG, user.getFriendlyRegisteredTime().toString());
    }

}