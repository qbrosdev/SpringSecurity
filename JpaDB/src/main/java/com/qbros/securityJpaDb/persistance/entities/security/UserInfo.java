package com.qbros.securityJpaDb.persistance.entities.security;

import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by V.Ghasemi
 * on 5/13/2019.
 */
@Entity
@Table(name="usersInfo")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class UserInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NonNull
    @Column(length=50,nullable=false,unique = true)
     private String userName;

    @NonNull
    @Column(length=800,nullable=false)
    private String password;

    @NonNull
    @Enumerated(EnumType.STRING)
    //https://stackoverflow.com/a/8969164/3593084
    //https://vladmihalcea.com/the-best-way-to-handle-the-lazyinitializationexception/
    @ElementCollection(targetClass=Role.class,fetch = FetchType.EAGER)
    @CollectionTable(name="user_roles")
    private Set<Role> role;

    @Column(name="enabled")
    private short enabled;

}
