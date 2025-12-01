package com.scaler1.scalerProject_1.inheritanceDemo.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("STUDENT")
public class StudentSingleTable extends UserSingleTable {
    private double psp;
    private double attendance;
}
