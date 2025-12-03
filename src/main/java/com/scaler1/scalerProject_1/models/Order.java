package com.scaler1.scalerProject_1.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ManyToAny;

import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order extends BaseModel{

    @ManyToMany
    @JoinTable(
            name = "product_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> product;
}
