package com.order.api.order.provider;

import com.order.api.entity.Order;
import com.order.api.order.mapper.OrderDataAccessMapper;
import com.order.api.order.repository.OrderJpaRepository;
import com.order.api.port.output.dataprovider.OrderDataProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Component
public class OrderDataProviderImpl implements OrderDataProvider {

    private OrderJpaRepository orderJpaRepository;
    private OrderDataAccessMapper orderDataAccessMapper;

    @Override
    public Order save(Order order) {
        return orderDataAccessMapper.toOrder(
                orderJpaRepository.save(orderDataAccessMapper.toOrderEntity(order))
        );
    }

    @Override
    public Optional<Order> findByTrackingId(UUID trackingId) {
        return orderJpaRepository.findByTrackingId(trackingId)
                .map(orderDataAccessMapper::toOrder);
    }
}
