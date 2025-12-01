package com.scaler1.scalerProject_1.inheritanceDemo.TablePerClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tpc_student")
@Data
public class StudentTPC extends UserTPC {
    private double psp;
    private double attendance;
}

