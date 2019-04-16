//package njuics.demos.petsalon.common;
//
//import lombok.extern.slf4j.Slf4j;
//import njuics.demos.petsalon.model.PetType;
//import njuics.demos.petsalon.repository.OwnerRepository;
//import njuics.demos.petsalon.repository.PetRepository;
//import njuics.demos.petsalon.role.Owner;
//import njuics.demos.petsalon.role.Pet;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@Slf4j
//public class LoadDatabase {
//
//  @Bean
//  CommandLineRunner initDatabase(PetRepository petRepository, OwnerRepository ownerRepository) {
//    return args -> {
//      log.info("Preloading " + petRepository.save(new Pet(1, "cattie", PetType.CAT)));
//      log.info("Preloading " + petRepository.save(new Pet(2, "doggie", PetType.DOG)));
//      log.info("Preloading " + ownerRepository.save(new Owner(1, "Jack")));
//      log.info("Preloading " + ownerRepository.save(new Owner(2, "Peter")));
//    };
//  }
//}
