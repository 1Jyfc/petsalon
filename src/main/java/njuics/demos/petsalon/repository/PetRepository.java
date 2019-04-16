package njuics.demos.petsalon.repository;

import njuics.demos.petsalon.role.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {
}
