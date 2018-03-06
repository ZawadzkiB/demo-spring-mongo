package com.infoshare.academy.repository;

import com.infoshare.academy.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    @Query("{customer.id : ?0}")
    List<Order> findAllByCustomerId(String customerId);
}
