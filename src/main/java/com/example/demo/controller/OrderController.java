package com.example.demo.controller;

import com.example.demo.model.dto.RequestDto;
import com.example.demo.model.entity.OrderItem;
import com.example.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order")
    public OrderItem order(@RequestBody RequestDto requestDto) {
        return orderService.order(requestDto);

    }

    @ExceptionHandler(NullPointerException.class)
    public Object nullex(Exception e) {
        System.err.println(e.getMessage());
        return e.getMessage();
    }


}
