package com.ajax.cal;

import com.ajax.cal.service.CalenderController;
import com.crypto.auth.SecurityProvider;
import com.db.jpa.EMFProducer;
import com.db.User;
import com.db.UserCalenderEntry;
import com.opensymphony.xwork2.ActionSupport;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@Data
public class CalanderAction extends ActionSupport {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final Logger logger = LogManager.getLogger(CalanderAction.class);

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    CalenderController calenderController = CalenderController.getInstance();

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static EntityManager em = EMFProducer.getInstance().getEntityManager();

    @Setter(AccessLevel.NONE)
    private Map<String, String> data = new LinkedHashMap<String, String>();

    private String note;

    private String calEntryDate;


    public String getCalender() {
        User user = getUserFromSession();
        logger.debug("is go");
        data.put("cal_action", "cal_action is go");
        if (Objects.nonNull(user)) {
            logger.debug("user is non Null");
            data.put("user_email", user.getEmail());
        }

        return SUCCESS;
    }


    public String createCalender() {

        User user = getUserFromSession();
        UserCalenderEntry entry = new UserCalenderEntry();
        if (note != null) {
            entry.setNote(note);
            entry.setUser(user);
        }

        if (calEntryDate != null) {
            Instant test = Instant.parse(calEntryDate);
            LocalDateTime calDate = LocalDateTime.ofInstant(test, ZoneOffset.UTC);
            entry.setLocalDateTime(calDate);

        }

        em.getTransaction().begin();
        em.persist(entry);
        em.getTransaction().commit();

        data.put("UserCalenderEntry ", entry.toString());
        return SUCCESS;
    }



    public String findAllCalenders() {


        return null;
    }


    /**
     * user aware only in /crypto
     * @return
     */
    private User getUserFromSession() {
        HttpServletRequest request = ServletActionContext.getRequest();
        User user = (User) request.getSession().getAttribute(SecurityProvider.getInstance().getUserKey());
        return user;
    }


}
