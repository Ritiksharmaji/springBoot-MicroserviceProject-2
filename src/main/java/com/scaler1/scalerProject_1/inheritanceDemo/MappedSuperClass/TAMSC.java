package com.scaler1.scalerProject_1.inheritanceDemo.MappedSuperClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "st_ta_msc")
public class TAMSC extends BaseModelMSC {
    private double ave_rating;
    private String name;
    private String email;
}
