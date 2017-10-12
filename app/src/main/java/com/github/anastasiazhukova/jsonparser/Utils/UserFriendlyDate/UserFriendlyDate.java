package com.github.anastasiazhukova.jsonparser.Utils.UserFriendlyDate;

import android.util.Log;

import java.text.ParseException;
import java.util.Date;

public class UserFriendlyDate implements IUserFriendlyDate {

    private Date mFriendlyDate;

    public UserFriendlyDate(final long time) {
        mFriendlyDate = new Date(time);
        Log.d("DATE", mFriendlyDate.toString());
    }

    @Override
    public Date getFriendlyDate() throws ParseException {
        return mFriendlyDate;
    }
}
