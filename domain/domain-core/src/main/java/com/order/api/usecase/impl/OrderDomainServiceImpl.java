package com.order.api.usecase.impl;

import com.order.api.entity.Order;
import com.order.api.event.OrderCreatedEvent;
import com.order.api.event.OrderPaidEvent;
import com.order.api.usecase.OrderDomainService;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class OrderDomainServiceImpl implements OrderDomainService {

    @Override
    public OrderCreatedEvent create(Order order) {
        order.create();
        return new OrderCreatedEvent(order, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public OrderPaidEvent pay(Order order) {
        order.pay();
        return new OrderPaidEvent(order, ZonedDateTime.now(ZoneId.of("UTC")));
    }

}
