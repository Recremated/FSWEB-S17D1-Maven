package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/workintech")
public class AnimalController {
    Map<Integer, Animal> animals = new HashMap<Integer,Animal>();
    @GetMapping("/animal")
    public Map<Integer, Animal> getAllAnimals() {
        return animals;
    }
    @GetMapping("/animal/{id}")
    public Animal getAnimalById(@PathVariable Integer id) {
        return animals.get(id);
    }
    @PostMapping("/animal")
    public Animal addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return animal;
    }

    @PutMapping("/animal/{id}")
    public Animal updateAnimal(@PathVariable Integer id, @RequestBody Animal animal) {
        if (!animals.containsKey(id)) {
            throw new IllegalArgumentException("Animal with ID " + id + " not found.");
        }
        animal.setId(id);
        animals.put(id, animal);
        return animal;
    }

    @DeleteMapping("/animal/{id}")
    public Animal deleteAnimal(@PathVariable Integer id) {
        return animals.remove(id);
    }
}
