package com.crypto;

import com.ajax.cal.CalanderAction;
import com.ajax.cal.service.CalUtils;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CalanderTest {


    private String testDate ="2018-07-12T11:12:08.682Z";

    DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss.SSSZ");


    @Test
    public void runCalTest() {

        CalUtils calUtils  = CalUtils.getInstance();
        calUtils.init(ZonedDateTime.now());

        System.out.println(calUtils.getStartOfMonth());
        System.out.println( ZonedDateTime.now().format(FORMATTER));

        Instant test =  Instant.parse(testDate);

        LocalDateTime formatDateTime = LocalDateTime.ofInstant(test, ZoneOffset.UTC);

        System.out.println( formatDateTime);






    }
}
