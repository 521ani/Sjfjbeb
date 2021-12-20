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
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false, unique = true)
    @Length(min = 4, max = 5)
    private String postalCode;

    @ManyToOne
    @JoinColumn(
            name = "country_id",
            foreignKey = @ForeignKey(name = "fk_country_id")
    )
    private Country country;

    @OneToMany(mappedBy = "city")
    private Set<Store> stores;

    @OneToMany(mappedBy = "city")
    private Set<StoreOwner> storeOwners;
}
