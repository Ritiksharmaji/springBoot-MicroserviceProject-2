package com.scaler1.scalerProject_1.inheritanceDemo.TablePerClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tpc_ta")
@Data
public class TATPC extends UserTPC {
    private double ave_rating;
}
