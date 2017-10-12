package com.github.anastasiazhukova.jsonparser.Parser;

import com.github.anastasiazhukova.jsonparser.BuildConfig;
import com.github.anastasiazhukova.jsonparser.Constants.Constants;
import com.github.anastasiazhukova.jsonparser.HttpClient.IHttpClient;
import com.github.anastasiazhukova.jsonparser.Mocks.InputStreamMocks;
import com.github.anastasiazhukova.jsonparser.Parser.Json.UsersListParserJson;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(
        constants = BuildConfig.class,
        sdk = Constants.SDK_VERSION
)

public class UsersListParserTest {

    private static final String TAG = UsersListParserJson.class.getSimpleName();

    private static final int EXPECTED_LIST_SIZE = 5;
    private static final String EXPECTED_ID = "59dbe02684a66bbe143b20d1";
    private static final String EXPECTED_NAME = "Shelia Chang";
    private static final int EXPECTED_TAGS_ARRAY_SIZE = 7;
    private static final int EXPECTED_FRIENDS_NUMBER = 3;

    private InputStream mInputStream;
    private IHttpClient mIHttpClient;

    @Before
    public void setUp() {
        mIHttpClient = mock(IHttpClient.class);
    }

    private static String mJSONFileSource = "ListOfObjects/generated_users.json";

    @Test
    public void parseFromJSON() throws Exception {
        mInputStream = InputStreamMocks.inputStream(mJSONFileSource);
        when(mIHttpClient.request(Matchers.anyString())).thenReturn(mInputStream);
        InputStream response = mIHttpClient.request("any http");
        final UsersListParserFactory usersListParserFactory = new UsersListParserFactory();
        final IUsersList users = usersListParserFactory.createListParserForJSON(response).parse();
        List<IUser> usersList = users.getUsersList();
        assertEquals(usersList.size(), EXPECTED_LIST_SIZE);
        assertEquals(usersList.get(0).getId(), EXPECTED_ID);
        assertEquals(usersList.get(0).getName(), EXPECTED_NAME);
        assertEquals(usersList.get(0).getTags().length, EXPECTED_TAGS_ARRAY_SIZE);
        assertEquals(usersList.get(0).getFriends().getFriendsList().size(), EXPECTED_FRIENDS_NUMBER);

    }
}