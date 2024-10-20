package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
  private final Map<Integer, Animal> animals = new HashMap<>();


  @GetMapping()
  public List<Animal> listAnimals() {
      List<Animal> animalList;
      animalList = new ArrayList<>(animals.values());
      return animalList;
  }

  @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable("id") Integer id){
        return animals.get(id);
  }

  @PostMapping()
    public void addAnimal(@RequestBody Animal animal){

      animals.put(animal.getId(), animal);
  }

  @PutMapping("/{id}")
    public Animal updateAnimalById(@PathVariable("id") Integer id, @RequestBody Animal animal) {
      return animals.put(id,animal);
  }

  @DeleteMapping("/{id}")
    public Animal deleteAnimalById(@PathVariable("id") Integer id) {
      return animals.remove(id);
  }

}
