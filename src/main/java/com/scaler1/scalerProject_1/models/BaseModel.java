package com.scaler1.scalerProject_1.models;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@MappedSuperclass
public class BaseModel {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)  // NEW RECOMMENDED
    @Column(name = "id", columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID id;
}
