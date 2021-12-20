package com.aacademy.toyfactoryproject.dto;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CityDto {

    private Long id;

    private String name;

    private String postalCode;

    private Long countryId;

    private Set<Long> storeIds;

    private Set<Long> storeOwnerIds;
}
