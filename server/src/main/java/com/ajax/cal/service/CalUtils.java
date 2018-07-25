package com.ajax.cal.service;

import com.db.User;
import com.db.UserCalenderEntry;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;


import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.next;
import static java.time.DayOfWeek.MONDAY;

public class CalUtils {


    private static CalUtils _instance;

    private Calendar cal;
    private ZonedDateTime initime;
    private TreeSet<String> allTimeZones;
    private LocalDateTime localDateTime;
    private LocalDate localDate;

    public UserCalenderEntry createUserCalender(String note, ZonedDateTime initime, User user) {
        LocalDateTime dateTime =
                LocalDateTime.ofInstant(ZonedDateTime.now().toInstant(),
                                                                        ZoneId.systemDefault());

        UserCalenderEntry row = new UserCalenderEntry(note, dateTime,  user);
        return row;
    }


    private static class CalUtilsProvider {
        static final CalUtils INSTANCE = new CalUtils();
    }

    public static CalUtils getInstance() {
        return CalUtilsProvider.INSTANCE;
    }

    private CalUtils() {
        Set<String> ids = ZoneId.getAvailableZoneIds();
        allTimeZones  = new TreeSet<>(ids);

    }

    public void init(ZonedDateTime dateTime) {
        this.initime = dateTime;
        cal=  GregorianCalendar.from(dateTime);
        cal.setTimeInMillis( dateTime.toInstant().toEpochMilli() );
        localDateTime = initime.toLocalDateTime();
        localDate = initime.toLocalDate();

    }



    public LocalDate getStartOfMonth() {
        LocalDate startOfMonth = localDate.with(firstDayOfMonth());
        return startOfMonth;
    }


    public LocalDate getFollowingMonday() {
        LocalDate followingMonday = localDate.with(next(MONDAY));
        return followingMonday;
    }

}
