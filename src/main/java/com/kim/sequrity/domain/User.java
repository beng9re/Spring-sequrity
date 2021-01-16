package com.kim.sequrity.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    @Setter
    private String role; // ROLE_USER , ROLE_ADMIN

    @CreationTimestamp
    private Timestamp createDate;

    @Builder
    public User (String username, String password, String email, String role){
        this.username=username;
        this.password=password;
        this.email=email;
        this.role=role;
    }



}
