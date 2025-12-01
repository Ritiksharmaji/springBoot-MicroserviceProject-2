package com.scaler1.scalerProject_1.inheritanceDemo.MappedSuperClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "st_student_msc")
public class StudentMSC extends BaseModelMSC {
    private double psp;
    private double attendance;
    private String name;
    private String email;
}
