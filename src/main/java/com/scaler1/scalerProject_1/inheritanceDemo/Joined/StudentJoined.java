package com.scaler1.scalerProject_1.inheritanceDemo.Joined;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "st_student_joined")
public class StudentJoined extends UserJoined {
    private double psp;
    private double attendance;
}
