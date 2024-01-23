package com.micro.store.shopping.Model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Product {
    private Long id;
    private String name;
    private String description;
    private Double stock;
    private Double price;
    private String status;
    private Date createAt;
    private Category category;
}
