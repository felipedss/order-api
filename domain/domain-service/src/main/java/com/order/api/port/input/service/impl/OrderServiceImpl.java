package com.order.api.port.input.service.impl;

import com.order.api.ApplicationEventDomainEventPublisher;
import com.order.api.dto.create.CreateOrderCommand;
import com.order.api.dto.create.CreateOrderResponse;
import com.order.api.dto.query.OrderQueryResponse;
import com.order.api.entity.Order;
import com.order.api.event.OrderCreatedEvent;
import com.order.api.mapper.OrderDataMapper;
import com.order.api.port.input.service.OrderService;
import com.order.api.port.output.dataprovider.OrderDataProvider;
import com.order.api.usecase.OrderDomainService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
@Service
@AllArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderDataProvider orderDataProvider;

    private final OrderDomainService orderDomainService;

    private final OrderDataMapper orderDataMapper;

    private final ApplicationEventDomainEventPublisher<OrderCreatedEvent> applicationEventDomainEventPublisher;

    @Override
    @Transactional
    public CreateOrderResponse create(CreateOrderCommand createOrderCommand) {
        Order orderMapper = orderDataMapper.create(createOrderCommand);
        OrderCreatedEvent orderCreatedEvent = orderDomainService.create(orderMapper);
        applicationEventDomainEventPublisher.publish(orderCreatedEvent);
        Order order = orderDataProvider.save(orderMapper);
        log.info("Order Created with id {}", order.getId());
        return orderDataMapper.createResponse(order);
    }

    @Override
    public OrderQueryResponse query(UUID trackingId) {
        return orderDataProvider.findByTrackingId(trackingId)
                .map(orderDataMapper::queryResponse)
                .orElse(new OrderQueryResponse(null));
    }
}
