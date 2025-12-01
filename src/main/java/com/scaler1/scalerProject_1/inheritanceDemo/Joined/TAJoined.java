package com.scaler1.scalerProject_1.inheritanceDemo.Joined;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "st_ta_joined")
public class TAJoined extends UserJoined {
    private double ave_rating;
}
