package com.order.api.entity;

import com.order.api.common.entity.AggregateRoot;
import com.order.api.common.vo.Money;
import com.order.api.vo.OrderStatus;

import java.util.UUID;

import static com.order.api.vo.OrderStatus.PAID;
import static com.order.api.vo.OrderStatus.PENDING;

public class Order extends AggregateRoot<UUID> {

    private UUID trackingId;
    private final UUID customerId;
    private final Money price;
    private OrderStatus status;
    private Order(Builder builder) {
        super.setId(builder.id);
        trackingId = builder.trackingId;
        customerId = builder.customerId;
        price = builder.price;
        status = builder.status;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void create() {
        setId(UUID.randomUUID());
        trackingId = UUID.randomUUID();
        status = PENDING;
    }

    public void pay() {
        status = PAID;
    }

    public UUID getTrackingId() {
        return trackingId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public Money getPrice() {
        return price;
    }

    public OrderStatus getStatus() {
        return status;
    }
    public static final class Builder {
        private UUID id;
        private UUID trackingId;
        private UUID customerId;
        private Money price;
        private OrderStatus status;

        private Builder() {
        }

        public Builder id(UUID val) {
            id = val;
            return this;
        }

        public Builder trackingId(UUID val) {
            trackingId = val;
            return this;
        }

        public Builder customerId(UUID val) {
            customerId = val;
            return this;
        }

        public Builder price(Money val) {
            price = val;
            return this;
        }

        public Builder status(OrderStatus val) {
            status = val;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
