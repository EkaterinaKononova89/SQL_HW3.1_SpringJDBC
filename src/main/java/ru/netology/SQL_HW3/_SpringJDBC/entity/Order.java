package ru.netology.SQL_HW3._SpringJDBC.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private String date;
    @Column(nullable = false, name = "product_name")
    private String productName;
    @Column(nullable = false)
    private int amount;

    @ManyToOne // отношение заказа к покупателю: много заказов у одного покупателя
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}
