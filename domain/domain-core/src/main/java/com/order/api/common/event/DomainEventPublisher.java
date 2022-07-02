package com.order.api.common.event;

public interface DomainEventPublisher<T extends DomainEvent<?>> {

    void publish(T domainEvent);

}
