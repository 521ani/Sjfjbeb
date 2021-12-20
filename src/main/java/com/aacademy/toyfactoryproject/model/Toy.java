package com.aacademy.toyfactoryproject.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "toys")
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(nullable = false)
    @Min(value = 0, message = "Minimum Age should be above 0.")
    private Integer minAge;

    @NotNull
    @Column(nullable = false)
    private Integer weightInGrams;

    @OneToMany(mappedBy = "toy")
    private Set<Order> orders;

    @NotNull
    @Column(nullable = false)
    private BigDecimal price;
}
