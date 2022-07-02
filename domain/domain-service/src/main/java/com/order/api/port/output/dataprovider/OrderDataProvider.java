package com.order.api.port.output.dataprovider;

import com.order.api.entity.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderDataProvider {

    Order save(Order order);

    Optional<Order> findByTrackingId(UUID trackingId);

}
