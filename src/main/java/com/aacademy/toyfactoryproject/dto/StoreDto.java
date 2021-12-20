package com.aacademy.toyfactoryproject.dto;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class StoreDto {

    private Long id;

    private String name;

    private Set<Long> orderIds;

    private Long cityId;

    private Long storeOwnerId;
}
