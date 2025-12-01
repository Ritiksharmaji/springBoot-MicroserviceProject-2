package com.scaler1.scalerProject_1.inheritanceDemo.TablePerClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tpc_mentor")
@Data
public class MentorTPC extends UserTPC {
    private double avg_rating;

}

