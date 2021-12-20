package com.aacademy.toyfactoryproject.dto;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class StoreOwnerDto {

    private Long id;

    private String name;

    private String phoneNumber;

    private String ucn;

    private Long cityId;

    private Set<Long> storeIds;
}
