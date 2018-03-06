package com.infoshare.academy.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Product {

    @NonNull
    public String id;
    @NonNull
    public String name;
    @NonNull
    public Double price;
}
