package com.order.api.dto.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PaymentResponse {

    private String id;
    private String sagaId;
    private String orderId;
    private String paymentId;

}
