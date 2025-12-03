package com.scaler1.scalerProject_1.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category")
    private Category category;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Price price;

}
