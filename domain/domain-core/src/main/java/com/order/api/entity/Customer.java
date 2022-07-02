package com.order.api.entity;

import com.order.api.common.entity.AggregateRoot;

import java.util.UUID;

public class Customer extends AggregateRoot<UUID> {
    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
