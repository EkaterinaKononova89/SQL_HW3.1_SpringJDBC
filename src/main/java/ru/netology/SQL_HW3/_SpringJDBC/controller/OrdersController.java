package ru.netology.SQL_HW3._SpringJDBC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.SQL_HW3._SpringJDBC.repository.OrdersRepository;

import java.util.List;

@RestController
public class OrdersController {
    private final OrdersRepository repository;

    public OrdersController(OrdersRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getProductName(@RequestParam String name) {
        return repository.getProductName(name);
    }
}
