package com.aacademy.toyfactoryproject.repository;

import com.aacademy.toyfactoryproject.model.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToyRepository extends JpaRepository<Toy, Long> {

}
