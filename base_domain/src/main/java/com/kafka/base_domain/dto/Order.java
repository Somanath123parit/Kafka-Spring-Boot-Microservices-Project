package com.kafka.base_domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String id;
    private String name;
    private  Integer qty;
    private  Double price;
}
