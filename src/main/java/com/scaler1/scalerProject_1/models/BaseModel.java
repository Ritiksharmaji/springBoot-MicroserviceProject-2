package com.scaler1.scalerProject_1.models;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

//import java.util.UUID;
//
//@MappedSuperclass
//public class BaseModel {
////    @Id
////    @UuidGenerator(style = UuidGenerator.Style.RANDOM)  // NEW RECOMMENDED
////    @Column(name = "id", columnDefinition = "BINARY(16)", updatable = false, nullable = false)
////    private UUID id;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID id;
//}
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
