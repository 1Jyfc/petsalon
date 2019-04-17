package njuics.demos.petsalon.role;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import njuics.demos.petsalon.model.NamedEntity;
import njuics.demos.petsalon.model.PetType;

import javax.persistence.*;
import java.util.Set;

@Entity
//@Table(name = "pets")
public class Pet extends NamedEntity {

  @Column(name = "type")
  private PetType type;

  @ManyToOne
  @JoinColumn(name = "owner", referencedColumnName = "id")
  @JsonBackReference
  private Owner owner;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "pet", referencedColumnName = "id")
  @JsonManagedReference
  private Set<Service> services;

  public Pet() {

  }

  public Pet(int id, String name, PetType type) {
    this.setId(id);
    this.setName(name);
    this.setType(type);
  }

  public void setServices(Set<Service> services) {
    this.services = services;
  }

  public void setType(PetType type) {
    this.type = type;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
  }

  public Set<Service> getServices() {
    return services;
  }

  public PetType getType() {
    return type;
  }

  public Owner getOwner() {
    return owner;
  }
}
