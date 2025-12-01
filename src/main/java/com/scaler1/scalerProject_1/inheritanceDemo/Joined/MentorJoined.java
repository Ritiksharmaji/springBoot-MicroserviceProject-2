package com.scaler1.scalerProject_1.inheritanceDemo.Joined;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "st_mentor_joined")
public class MentorJoined extends UserJoined {
    private double avg_rating;
}
