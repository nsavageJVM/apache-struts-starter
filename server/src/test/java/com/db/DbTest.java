package com.db;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DbTest {

    private static final String testDate ="2018-07-12T11:12:08.682Z";

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss.SSSZ");
    private static final TestJpaTransactionManager jpaManager = TestJpaTransactionManager.getInstance();


    @Before
    public void connectDatabase(){

        createTestUserData();

    }

    @Test
    public void runCalLoginTest() {

        String email = "john@doe.com";
        List<User> users = jpaManager.findByField(  User.class, "email", email).getResultList();
        User user = CollectionUtils.isNotEmpty(users) ? users.get(0) : null;

        Assert.assertNotNull(user);

    }

    @Test
    public void runCalTest() {
        List<User> usrs = jpaManager.selectAll( User.class).setMaxResults(2).getResultList();

        List<User> usrsF = usrs.stream().filter( u -> (!u.getEmail().contains("@") ) ).collect(Collectors.toList());
        usrsF.forEach(u -> System.out.println(u.getEmail()));
        if(usrsF.size() > 1) {
            createTestCalData(  usrsF);
        }
    }




    private void createTestCalData( List<User> usrs) {

        int count = 0;

        List<UserCalenderEntry> entries = new ArrayList<>();
        while (count < 11) {
            if(count % 2 ==0) {
                entries.add (createCalEntries(usrs.get(0), count));
            } else {
                entries.add (createCalEntries(usrs.get(1), count));
            }
            count++;
        }
        jpaManager.saveAll(entries);

    }




    private void createTestUserData() {

        User user = new User();
        user.setEmail("john@doe.com");
        user.setPassword("tmp123");

        User user1 = new User();
        user1.setEmail("silly");
        user1.setPassword("billy");

        User user2 = new User();
        user2.setEmail("jolly");
        user2.setPassword("polly");

        jpaManager.save(user1);
        jpaManager.save(user2);

    }

    private UserCalenderEntry createCalEntries( User user, int k) {
        String noteTemplate = "this is pop %s";
        UserCalenderEntry entry = new UserCalenderEntry();
        entry.setNote(String.format(noteTemplate, k));
        entry.setUser(user);
        Instant test = Instant.parse(testDate);
        LocalDateTime calDate = LocalDateTime.ofInstant(test, ZoneOffset.UTC);
        entry.setLocalDateTime(calDate);


        return entry;
    }

}
