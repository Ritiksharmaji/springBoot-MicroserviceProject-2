package com.scaler1.scalerProject_1.inheritanceDemo.Joined;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "st_user_joined")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserJoined {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
}
