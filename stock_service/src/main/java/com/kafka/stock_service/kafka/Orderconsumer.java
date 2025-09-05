package com.kafka.stock_service.kafka;

import com.kafka.base_domain.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class Orderconsumer {

    @Autowired
    private OrderRepository repository;

    private final Logger logger= LoggerFactory.getLogger(Orderconsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}",
                    groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumeMesg(OrderEvent event){
        logger.info("Event recieved from stock service => "+event);

        //events store in data base
       Order order= new Order();
        order.setId(event.getId());
        order.setName(event.getName());
        order.setQty(event.getQty());
        order.setPrice(event.getPrice());

        repository.save(order);
    }
}
