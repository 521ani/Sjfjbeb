package com.aacademy.toyfactoryproject.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "store_owners")
public class StoreOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private String phoneNumber;

    @NotNull
    @Column(nullable = false, unique = true)
    @Length(min = 10, max = 10, message = "Ucn should be 10 characters long.")
    private String ucn;

    @ManyToOne
    @JoinColumn(
            name = "city_id",
            foreignKey = @ForeignKey(name = "fk_store_owner_city_id")
    )
    private City city;

    @OneToMany(mappedBy = "storeOwner")
    private Set<Store> stores;
}
