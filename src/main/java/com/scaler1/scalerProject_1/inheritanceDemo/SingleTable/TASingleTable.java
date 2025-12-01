package com.scaler1.scalerProject_1.inheritanceDemo.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("TA")
public class TASingleTable extends UserSingleTable {
    private double ave_rating;
}
