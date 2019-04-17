package njuics.demos.petsalon.controller;

import njuics.demos.petsalon.repository.OwnerRepository;
import njuics.demos.petsalon.role.Owner;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OwnerController {
  private final OwnerRepository repository;

  OwnerController(OwnerRepository repository) {
    this.repository = repository;
  }

  // Aggregate root

  @GetMapping("/owners")
  List<Owner> all() {
    return repository.findAll();
  }

  @PostMapping("/owners")
  Owner newOwner(@RequestBody Owner newOwner) {
    return repository.save(newOwner);
  }

  // Single item

  @GetMapping("/owners/{id}")
  Owner one(@PathVariable int id) {

    return repository.findById(id)
      .orElseThrow(() -> new RuntimeException());
  }

  @PutMapping("/owners/{id}")
  Owner replaceOwner(@RequestBody Owner newOwner, @PathVariable int id) {

    return repository.findById(id)
      .map(Owner -> {
        Owner.setName(newOwner.getName());
        return repository.save(Owner);
      })
      .orElseGet(() -> {
        newOwner.setId(id);
        return repository.save(newOwner);
      });
  }

  @DeleteMapping("/owners/{id}")
  void deleteOwner(@PathVariable int id) {
    repository.deleteById(id);
  }
}
