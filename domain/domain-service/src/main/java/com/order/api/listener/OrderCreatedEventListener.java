package com.order.api.listener;

import com.order.api.event.OrderCreatedEvent;
import com.order.api.port.output.message.publisher.OrderCreatedPaymentMessageEventPublisher;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@AllArgsConstructor
public class OrderCreatedEventListener {

    @TransactionalEventListener
    public void process(OrderCreatedEvent orderCreatedEvent) {
        log.info("Processing listener orderCreatedEvent");
    }

}
