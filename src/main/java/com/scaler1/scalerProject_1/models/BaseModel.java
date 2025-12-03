package com.scaler1.scalerProject_1.models;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
