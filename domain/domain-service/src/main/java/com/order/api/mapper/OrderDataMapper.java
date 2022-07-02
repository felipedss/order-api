package com.order.api.mapper;

import com.order.api.common.vo.Money;
import com.order.api.dto.create.CreateOrderCommand;
import com.order.api.dto.create.CreateOrderResponse;
import com.order.api.dto.query.OrderQueryResponse;
import com.order.api.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderDataMapper {

    public Order create(CreateOrderCommand createOrderCommand) {
        return Order.builder()
                .customerId(createOrderCommand.customerId())
                .price(new Money(createOrderCommand.price()))
                .build();
    }

    public CreateOrderResponse createResponse(Order order) {
        return new CreateOrderResponse(order.getTrackingId(), order.getStatus());
    }

    public OrderQueryResponse queryResponse(Order order) {
        return new OrderQueryResponse(order.getTrackingId());
    }
}
