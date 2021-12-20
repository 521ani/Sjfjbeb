package com.aacademy.toyfactoryproject.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(
            name = "toy_id",
            foreignKey = @ForeignKey(name = "fk_toy_id")
    )
    private Toy toy;

    @NotNull
    @Column(nullable = false)
    private LocalDate dateOrdered;

    @ManyToOne
    @JoinColumn(
            name = "store_id",
            foreignKey = @ForeignKey(name = "fk_store_id")
    )
    private Store store;
}
