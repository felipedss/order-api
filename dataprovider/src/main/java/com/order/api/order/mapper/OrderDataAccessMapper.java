package com.order.api.order.mapper;

import com.order.api.common.vo.Money;
import com.order.api.entity.Order;
import com.order.api.order.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderDataAccessMapper {

    public OrderEntity toOrderEntity(Order order) {
        return OrderEntity.builder()
                .customerId(order.getCustomerId())
                .price(order.getPrice().getAmount())
                .trackingId(order.getTrackingId())
                .id(order.getId())
                .status(order.getStatus())
                .build();
    }

    public Order toOrder(OrderEntity orderEntity) {
        return Order.builder()
                .price(new Money(orderEntity.getPrice()))
                .status(orderEntity.getStatus())
                .customerId(orderEntity.getCustomerId())
                .trackingId(orderEntity.getTrackingId())
                .id(orderEntity.getId())
                .build();
    }

}
