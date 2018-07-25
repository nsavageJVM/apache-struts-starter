package com.db;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Entity
public class User  implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy =GenerationType.TABLE)
    @Basic(optional = false)
    @Column(name = "ID")
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(name = "email", nullable=false)
    private String email;

    @Column(name = "password", nullable=false)
    private String password;

    @OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true, mappedBy="User")
    private List<UserCalenderEntry> calenderEntries = new ArrayList<UserCalenderEntry>();

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
