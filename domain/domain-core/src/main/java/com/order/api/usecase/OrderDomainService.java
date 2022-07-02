package com.order.api.usecase;

import com.order.api.entity.Order;
import com.order.api.event.OrderCreatedEvent;
import com.order.api.event.OrderPaidEvent;

public interface OrderDomainService {

    OrderCreatedEvent create(Order order);

    OrderPaidEvent pay(Order order);

}
