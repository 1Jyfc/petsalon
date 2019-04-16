package njuics.demos.petsalon.controller;

import njuics.demos.petsalon.repository.ServiceRepository;
import njuics.demos.petsalon.role.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceController {

  private final ServiceRepository repository;

  ServiceController(ServiceRepository repository) {
    this.repository = repository;
  }

  // Aggregate root

  @GetMapping("/services")
  List<Service> all() {
    return repository.findAll();
  }

  @PostMapping("/services")
  Service newService(@RequestBody Service newService) {
    return repository.save(newService);
  }

  // Single item

  @GetMapping("/services/{id}")
  Service one(@PathVariable int id) {

    return repository.findById(id)
      .orElseThrow(() -> new RuntimeException());
  }

  @PutMapping("/services/{id}")
  Service replaceService(@RequestBody Service newService, @PathVariable int id) {

    return repository.findById(id)
      .map(Service -> {
        Service.setDate(newService.getDate());
        Service.setFee(newService.getFee());
        Service.setCategory(newService.getCategory());
        return repository.save(Service);
      })
      .orElseGet(() -> {
        newService.setId(id);
        return repository.save(newService);
      });
  }

  @DeleteMapping("/services/{id}")
  void deleteService(@PathVariable int id) {
    repository.deleteById(id);
  }
}
