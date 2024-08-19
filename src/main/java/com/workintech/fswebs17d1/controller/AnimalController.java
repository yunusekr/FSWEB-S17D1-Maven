package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnimalController {
    Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping("/workintech/animal")
    public List<Animal> getAnimals(){
        return animals.values().stream().toList();
    }

    @GetMapping("/workintech/animal/{id}")
    public Animal getAnimalsId(@PathVariable int id){
        return animals.values().stream().filter(l->l.getId() == id).findFirst().get();
    }

    @PostMapping("/workintech/animal")
    public Animal saveAnimals(@RequestBody Animal animal){
       return animals.put(animal.getId(), animal);
    }

    @PutMapping("/workintech/animal/{id}")
    public void updateAnimals(@PathVariable int id,@RequestBody Animal animal){
        animals.put(id,animal);
    }

    @DeleteMapping("/workintech/animal/{id}")
    public Animal removeAnimals(@PathVariable int id){
        Animal animal1 = animals.get(id);
        animals.remove(animal1);
        return animal1;
    }


}
