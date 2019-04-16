package njuics.demos.petsalon.role;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import njuics.demos.petsalon.model.NamedEntity;
import njuics.demos.petsalon.model.PetType;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
//@Table(name = "pets")
public class Pet extends NamedEntity {

  @Column(name = "type_id")
  private PetType type;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  private Owner owner;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
  private Set<Service> services;

  public Pet() {

  }

  public Pet(int id, String name, PetType type) {
    this.setId(id);
    this.setName(name);
    this.setType(type);
  }

}
