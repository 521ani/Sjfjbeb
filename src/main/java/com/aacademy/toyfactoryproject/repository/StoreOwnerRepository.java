package com.aacademy.toyfactoryproject.repository;

import com.aacademy.toyfactoryproject.model.StoreOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreOwnerRepository extends JpaRepository<StoreOwner, Long> {

    Optional<StoreOwner> findByName(String name);
}
