package com.order.api.dto.create;

import com.order.api.vo.OrderStatus;

import java.util.UUID;

public record CreateOrderResponse(UUID trackingId, OrderStatus status) {

}
