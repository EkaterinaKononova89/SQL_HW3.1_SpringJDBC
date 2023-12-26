package ru.netology.SQL_HW3._SpringJDBC.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrdersRepository {
    @PersistenceContext  // многопоточный @Autowire
    private final EntityManager entityManager;
    private final String scriptRequest;

    public OrdersRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        scriptRequest = read("scriptRequest.sql");
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {
        List<String> orders = entityManager.createNativeQuery(scriptRequest)
                .setParameter("firstName", name)
                .getResultList();
        return orders;
    }
}

