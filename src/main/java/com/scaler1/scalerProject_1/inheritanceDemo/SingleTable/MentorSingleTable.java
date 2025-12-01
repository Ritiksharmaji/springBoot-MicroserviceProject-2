package com.scaler1.scalerProject_1.inheritanceDemo.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("MENTOR")
public class MentorSingleTable extends UserSingleTable {
    private double avg_rating;
}
