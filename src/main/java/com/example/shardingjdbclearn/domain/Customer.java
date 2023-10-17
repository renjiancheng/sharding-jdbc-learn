package com.example.shardingjdbclearn.domain;

import lombok.Data;

/**
 * @author jiancheng
 */
@Data
public class Customer {
    private Long id;
    private String customerId;
    private String name;
}
