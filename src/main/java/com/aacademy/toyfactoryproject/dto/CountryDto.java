package com.aacademy.toyfactoryproject.dto;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CountryDto {

    private Long id;

    private String name;

    private String countryCode;

    private Set<Long> cityIds;
}
