package com.example.xa.controller;

import com.example.xa.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author m809745357
 */
@RestController
@RequestMapping("order/")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("create")
    public String create() {
        return orderService.createOrder();
    }
}
