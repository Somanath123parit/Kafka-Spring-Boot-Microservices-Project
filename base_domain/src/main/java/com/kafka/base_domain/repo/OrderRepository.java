package com.kafka.base_domain.repo;

import com.kafka.base_domain.dto.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String>
{
}
