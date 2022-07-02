package com.order.api.port.output.message.publisher;

import com.order.api.common.event.DomainEventPublisher;
import com.order.api.event.OrderCreatedEvent;

public interface OrderCreatedPaymentMessageEventPublisher extends DomainEventPublisher<OrderCreatedEvent> {
}
