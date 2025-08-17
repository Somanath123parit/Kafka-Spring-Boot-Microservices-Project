package com.kafka.order_service.controller;

import com.kafka.base_domain.dto.Order;
import com.kafka.base_domain.dto.OrderEvent;
import com.kafka.order_service.kafka.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private OrderProducer producer;

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order){
        order.setId(UUID.randomUUID().toString());

        OrderEvent orderEvent=new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMesg("order in pending state..");
        orderEvent.setOrder(order);

        producer.sendMesg(orderEvent);

        return "Order placed successfully...!";
    }
}
