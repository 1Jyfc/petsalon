package njuics.demos.petsalon.controller;

import njuics.demos.petsalon.repository.OwnerRepository;
import njuics.demos.petsalon.repository.PetRepository;
import njuics.demos.petsalon.role.Owner;
import njuics.demos.petsalon.role.Pet;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {

  private final PetRepository repository;
  private final OwnerRepository ownerRepository;

  PetController(PetRepository repository, OwnerRepository ownerRepository) {
    this.repository = repository;
    this.ownerRepository = ownerRepository;
  }

  // Aggregate root

  @GetMapping("/pets")
  List<Pet> all() {
    return repository.findAll();
  }

  @PostMapping("/pets")
  Pet newPet(@RequestBody Pet newPet) {
    return repository.save(newPet);
  }

  // Single item

  @GetMapping("/pets/{id}")
  Pet one(@PathVariable int id) {

    return repository.findById(id)
      .orElseThrow(() -> new RuntimeException());
  }

  @PutMapping("/pets/{id}")
  Pet replacePet(@RequestBody Pet newPet, @PathVariable int id) {

    return repository.findById(id)
      .map(pet -> {
        pet.setName(newPet.getName());
        pet.setType(newPet.getType());
        return repository.save(pet);
      })
      .orElseGet(() -> {
        newPet.setId(id);
        return repository.save(newPet);
      });
  }

  @DeleteMapping("/pets/{id}")
  void deletePet(@PathVariable int id) {
    repository.deleteById(id);
  }

  @ModelAttribute("owner")
  @RequestMapping("/owners/{ownerId}")
  @Transactional(readOnly = true)
  public Owner findOwner(@PathVariable("ownerId") int ownerId) {
    System.out.println(ownerId);
    return ownerRepository.findById(ownerId).get();
  }

}
