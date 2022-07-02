package com.order.api.rest.v1;

import com.order.api.dto.create.CreateOrderCommand;
import com.order.api.dto.create.CreateOrderResponse;
import com.order.api.dto.query.OrderQueryResponse;
import com.order.api.port.input.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateOrderResponse create(@RequestBody CreateOrderCommand createOrderCommand) {
        return orderService.create(createOrderCommand);
    }

    @GetMapping("/{trackingId}")
    @ResponseStatus(HttpStatus.OK)
    public OrderQueryResponse trackingId(@PathVariable UUID trackingId) {
        return orderService.query(trackingId);
    }


}
