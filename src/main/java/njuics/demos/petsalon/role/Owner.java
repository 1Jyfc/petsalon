package njuics.demos.petsalon.role;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import njuics.demos.petsalon.model.NamedEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
//@Table(name = "owners")
public class Owner extends NamedEntity {

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "owner", referencedColumnName = "id")
  @JsonManagedReference
  private Set<Pet> pets;

  public Owner() {

  }

  public Owner(int id, String name) {
    this.setId(id);
    this.setName(name);
  }

  public Set<Pet> getPets() {
    return pets;
  }

  public void setPets(Set<Pet> pets) {
    this.pets = pets;
  }
}
