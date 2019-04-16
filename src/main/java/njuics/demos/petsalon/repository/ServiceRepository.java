package njuics.demos.petsalon.repository;

import njuics.demos.petsalon.role.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
