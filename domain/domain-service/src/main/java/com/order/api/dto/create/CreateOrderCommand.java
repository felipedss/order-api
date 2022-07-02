package com.order.api.dto.create;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

public record CreateOrderCommand(@NotNull UUID customerId, @NotNull BigDecimal price) {

}
