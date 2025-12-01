package com.scaler1.scalerProject_1.inheritanceDemo.SingleTable;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "st_user_single")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public class UserSingleTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
}
