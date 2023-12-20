package ru.netology.SQL_HW3._SpringJDBC.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class OrdersRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String scriptRequest;


    public OrdersRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
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

    public List<String> getProductName(String firstName) {
        Map<String, Object> map = new HashMap<>();
        map.put("firstName", firstName);
        return namedParameterJdbcTemplate.queryForList(scriptRequest, map, String.class);
    }
}

