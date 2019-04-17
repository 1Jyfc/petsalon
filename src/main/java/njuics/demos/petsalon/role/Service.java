package njuics.demos.petsalon.role;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import njuics.demos.petsalon.model.BaseEntity;
import njuics.demos.petsalon.model.ServiceCategory;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "services")
public class Service extends BaseEntity {

  @Column(name = "service_date")
  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern = "yyyy/MM/dd")
  private Date date;

  @Column(name = "service_fee")
  private Double fee;

  @Column(name = "service_category")
  private ServiceCategory category;

  @ManyToOne
  @JoinColumn(name = "pet", referencedColumnName = "id")
  @JsonBackReference
  private Pet pet;

  public Service() {

  }

  public Service(Date date, Double fee, ServiceCategory category) {
    this.setDate(date);
    this.setFee(fee);
    this.setCategory(category);
  }

  public Date getDate() {
    return date;
  }

  public Double getFee() {
    return fee;
  }

  public Pet getPet() {
    return pet;
  }

  public ServiceCategory getCategory() {
    return category;
  }

  public void setCategory(ServiceCategory category) {
    this.category = category;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public void setFee(Double fee) {
    this.fee = fee;
  }

  public void setPet(Pet pet) {
    this.pet = pet;
  }
}
