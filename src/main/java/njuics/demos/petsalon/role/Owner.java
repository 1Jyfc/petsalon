package njuics.demos.petsalon.role;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import njuics.demos.petsalon.model.NamedEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
//@Table(name = "owners")
public class Owner extends NamedEntity {

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
  private Set<Pet> pets;

  public Owner() {

  }

  public Owner(int id, String name) {
    this.setId(id);
    this.setName(name);
  }
}
