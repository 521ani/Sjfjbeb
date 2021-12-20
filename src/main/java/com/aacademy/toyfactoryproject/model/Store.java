package com.aacademy.toyfactoryproject.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "store")
    private Set<Order> orders;

    @ManyToOne
    @JoinColumn(
            name = "city_id",
            foreignKey = @ForeignKey(name = "fk_store_city_id")
    )
    private City city;

    @ManyToOne
    @JoinColumn(
            name = "store_owner_id",
            foreignKey = @ForeignKey(name = "fk_store_owner_id")
    )
    private StoreOwner storeOwner;
}
