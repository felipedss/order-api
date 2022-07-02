package com.order.api.port.input.service;

import com.order.api.dto.create.CreateOrderCommand;
import com.order.api.dto.create.CreateOrderResponse;
import com.order.api.dto.query.OrderQueryResponse;

import javax.validation.Valid;
import java.util.UUID;

public interface OrderService {

    CreateOrderResponse create(@Valid CreateOrderCommand createOrderCommand);

    OrderQueryResponse query(@Valid UUID trackingId);

}
