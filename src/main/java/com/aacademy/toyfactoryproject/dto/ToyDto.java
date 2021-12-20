package com.aacademy.toyfactoryproject.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ToyDto {

    private Long id;

    private String name;

    private Integer minAge;

    private Integer weightInGrams;

    private Set<Long> orderIds;

    private BigDecimal price;
}
