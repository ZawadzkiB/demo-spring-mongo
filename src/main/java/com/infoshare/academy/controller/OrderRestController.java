package com.infoshare.academy.controller;

import com.infoshare.academy.model.Order;
import com.infoshare.academy.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.infoshare.academy.utils.ProductsUtils.countTotalPrice;

@RestController
@Slf4j
public class OrderRestController {
	
	@Autowired
	private OrderRepository orderRepository;


	@RequestMapping(value = "order/", method = RequestMethod.GET)
	public List<Order> findAll(@RequestParam int page){
		Page<Order> orders = orderRepository.findAll(new PageRequest(page,20));
		log.info("Fetching orders from database {}" , orders.getContent().stream().map(Order::getId));
		return orders.getContent();
	}

	@RequestMapping(value = "order/customer/{customerId}", method = RequestMethod.GET)
	public List<Order> findByCustomerId(@PathVariable String customerId){
		List<Order> orders = orderRepository.findAllByCustomerId(customerId);
		log.info("Fetching orders from database {}" , orders.stream().map(Order::getId));
		return orders;
	}
	
	@RequestMapping(value = "order/" , method = RequestMethod.POST)
	public void save(@RequestBody Order order){
		order.setTotalPrice(countTotalPrice(order.getProducts()));
		log.info("Storing order in database {}", order.getId());
		orderRepository.save(order);
	}
	
}
