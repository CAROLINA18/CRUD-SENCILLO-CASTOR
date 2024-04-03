package com.icodeap.ecommerce.domain;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@ToString
public class Employee {
    private Integer id;
    private  Integer identification;
    private String name;
    private String description;
    private String image;

    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private Role role;

}
