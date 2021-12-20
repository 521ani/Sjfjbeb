package com.aacademy.toyfactoryproject.service;

import com.aacademy.toyfactoryproject.model.Toy;

import java.util.Set;

public interface ToyService {

    Toy save(Toy toy);

    Toy update(Long id, Toy toy);

    Toy findById(Long id);

    Set<Toy> findAll();

    void deleteById(Long id);
}
