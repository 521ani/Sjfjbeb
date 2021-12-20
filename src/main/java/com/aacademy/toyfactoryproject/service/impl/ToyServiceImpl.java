package com.aacademy.toyfactoryproject.service.impl;

import com.aacademy.toyfactoryproject.exception.DuplicateRecordsException;
import com.aacademy.toyfactoryproject.exception.ResourceNotFoundException;
import com.aacademy.toyfactoryproject.model.Toy;
import com.aacademy.toyfactoryproject.model.Toy;
import com.aacademy.toyfactoryproject.repository.ToyRepository;
import com.aacademy.toyfactoryproject.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@Service
public class ToyServiceImpl implements ToyService {

    private final ToyRepository toyRepository;

    @Autowired
    public ToyServiceImpl(ToyRepository toyRepository) {
        this.toyRepository = toyRepository;
    }

    @Override
    public Toy save(Toy toy) {
        try {
            return toyRepository.save(toy);
        } catch (Exception exception) {
            throw new DuplicateRecordsException("Toy already exists.");
        }
    }

    @Override
    public Toy update(Long id, Toy toy) {
        Toy foundToy = findById(id);
        Toy updatedToy = Toy.builder()
                .id(foundToy.getId())
                .price(toy.getPrice())
                .name(toy.getName())
                .orders(toy.getOrders())
                .weightInGrams(toy.getWeightInGrams())
                .minAge(toy.getMinAge())
                .build();

        return toyRepository.save(updatedToy);
    }

    @Override
    public Toy findById(Long id) {
        return toyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Toy wth id %d does not exist.", id)));
    }

    @Override
    public Set<Toy> findAll() {
        Set<Toy> toys = new TreeSet<>(Comparator.comparing(Toy::getId));
        toys.addAll(toyRepository.findAll());

        return toys;
    }

    @Override
    public void deleteById(Long id) {

    }
}
