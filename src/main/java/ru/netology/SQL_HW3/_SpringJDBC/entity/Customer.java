package ru.netology.SQL_HW3._SpringJDBC.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String surname;
    private int age;
    @Column(nullable = false, name = "phone_number", unique = true, length = 10)
    private String phoneNumber;
}
