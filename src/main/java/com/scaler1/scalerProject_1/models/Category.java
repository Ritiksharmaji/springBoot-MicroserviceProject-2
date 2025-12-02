package com.scaler1.scalerProject_1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
@Entity
public class Category extends BaseModel {
    @Column
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
    // this is the same relation being mappend by category class to product class



}
