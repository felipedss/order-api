package com.order.api.order.entity;

import com.order.api.common.vo.Money;
import com.order.api.vo.OrderStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

import static javax.persistence.EnumType.STRING;

@EqualsAndHashCode(of = "id")
@ToString(of = "id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    private UUID id;

    @NotNull
    private UUID customerId;

    @NotNull
    private UUID trackingId;

    @NotNull
    private BigDecimal price;

    @Enumerated(STRING)
    private OrderStatus status;

}
