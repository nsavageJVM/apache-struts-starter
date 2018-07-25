package com.ajax.cal.service;

import com.db.User;
import com.db.UserCalenderEntry;

import java.time.ZonedDateTime;

public class CalenderController {

    private static final CalUtils calUtils = CalUtils.getInstance();

    private CalenderController() {

    }

    private static class CalenderControllerProvider {
        static final CalenderController INSTANCE = new CalenderController();
    }

    public static CalenderController getInstance() {
        return CalenderControllerProvider.INSTANCE;
    }


  public  UserCalenderEntry createUserCalender(String note, ZonedDateTime initime,  User user) {

        UserCalenderEntry calEntry = calUtils.createUserCalender(note, initime, user);

        return calEntry;

    }


}
