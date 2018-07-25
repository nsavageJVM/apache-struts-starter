package com.db;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserCalenderEntry  implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy =GenerationType.TABLE)
    @Basic(optional = false)
    @Column(name = "ID")
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(name = "note", nullable=false)
    private String note;

    @Column(name = "local_date_time", nullable=false)
    private LocalDateTime localDateTime;


    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

    public UserCalenderEntry(String note, LocalDateTime localDateTime, User user) {
        this.note = note;
        this.localDateTime = localDateTime;
        this.user = user;

    }

}
