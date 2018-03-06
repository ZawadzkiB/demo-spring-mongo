package com.infoshare.academy.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Customer {

    @NonNull
    public String id;
    @NonNull
    public String firstName;
    @NonNull
    public String lastName;
    @NonNull
    public String address;
    @NonNull
    public String postCode;
    @NonNull
    public String country;
    @NonNull
    public String city;

}
