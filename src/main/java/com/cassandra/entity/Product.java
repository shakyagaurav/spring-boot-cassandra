package com.cassandra.entity;


import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Table(value = "products")
public class Product {

    @PrimaryKey
    private UUID id;

    @Column(value = "name")
    private String name;

    @Column(value = "price")
    private BigDecimal price;

    @Column(value = "quantity")
    private Integer quantity;

}
