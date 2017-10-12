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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(
        constants = BuildConfig.class,
        sdk = Constants.SDK_VERSION
)
public class FriendParserTest {

    private static final String TAG = FriendParserTest.class.getSimpleName();

    private static final int EXPECTED_ID = 0;
    private static final String EXPECTED_NAME = "Frazier Tyler";

    private InputStream mInputStream;
    private IHttpClient mIHttpClient;

    @Before
    public void setUp() {
        mIHttpClient = mock(IHttpClient.class);
    }

    private static String mJSONFileSource = "OneObject/friend.json";

    @Test
    public void parseForJson() throws Exception {
        mInputStream = InputStreamMocks.inputStream(mJSONFileSource);
        when(mIHttpClient.request(Matchers.anyString())).thenReturn(mInputStream);
        InputStream response = mIHttpClient.request("any http");
        final FriendParserFactory friendParserFactory = new FriendParserFactory();
        final IFriend friend = friendParserFactory.createParserForJSON(response).parse();
        assertEquals(friend.getId(), EXPECTED_ID);
        assertEquals(friend.getName(), EXPECTED_NAME);

    }

}