package com.aacademy.toyfactoryproject.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class OrderDto {

    private Long id;

    private Integer quantity;

    private Long toyId;

    private LocalDate dateOrdered;

    private Long storeId;
}
