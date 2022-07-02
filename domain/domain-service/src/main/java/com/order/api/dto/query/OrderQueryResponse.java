package com.order.api.dto.query;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public record OrderQueryResponse(@NotNull UUID trackingId) {
}
