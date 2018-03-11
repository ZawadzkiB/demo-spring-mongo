package com.infoshare.academy.controller;

import com.infoshare.academy.model.Order;
import com.infoshare.academy.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.infoshare.academy.utils.ProductsUtils.countTotalPrice;

@RestController
@Slf4j
public class OrderRestController {
	
	@Autowired
	private OrderRepository orderRepository;


	@RequestMapping(value = "order/", method = RequestMethod.GET)
	public List<Order> findAll(){
		final List<Order> orders = orderRepository.findAll();
		log.info("Fetching orders from database {}" , orders);
		return orders;
	}

	@RequestMapping(value = "order/customer/{customerId}", method = RequestMethod.GET)
	public List<Order> findByCustomerId(@PathVariable String customerId){
		final List<Order> orders = orderRepository.findAllByCustomerId(customerId);
		log.info("Fetching orders from database {}" , orders);
		return orders;
	}
	
	@RequestMapping(value = "order/" , method = RequestMethod.POST)
	public void save(@RequestBody Order order){
		order.setTotalPrice(countTotalPrice(order.getProducts()));
		log.info("Storing order in database {}", order);
		orderRepository.save(order);
	}
	
}
