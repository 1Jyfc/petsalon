package njuics.demos.petsalon.repository;

import njuics.demos.petsalon.role.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
