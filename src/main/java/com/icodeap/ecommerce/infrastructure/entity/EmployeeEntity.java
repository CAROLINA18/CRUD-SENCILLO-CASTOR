package com.icodeap.ecommerce.infrastructure.entity;

import com.icodeap.ecommerce.domain.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  Integer identification;
    private String name;
    private String description;
    private String image;


    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    @Enumerated(EnumType.ORDINAL)
    private Role role;

}
