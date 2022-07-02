package com.order.api;

import com.order.api.common.event.DomainEvent;
import com.order.api.common.event.DomainEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationEventDomainEventPublisher<T extends DomainEvent<?>> implements ApplicationEventPublisherAware, DomainEventPublisher<T> {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publish(T domainEvent) {
        applicationEventPublisher.publishEvent(domainEvent);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
