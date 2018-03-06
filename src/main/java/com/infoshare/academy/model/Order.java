package com.infoshare.academy.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Order {

    @Id
    private String id;

    @NonNull
    public Customer customer;
    @NonNull
    public List<Product> products;
    public Double totalPrice;

}
