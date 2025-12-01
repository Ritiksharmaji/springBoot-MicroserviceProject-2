package com.scaler1.scalerProject_1.inheritanceDemo.MappedSuperClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "st_mentor_msc")
public class MentorMSC extends BaseModelMSC {
    private double avg_rating;
    private String name;
    private String email;
}
