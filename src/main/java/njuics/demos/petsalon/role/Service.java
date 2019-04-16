package njuics.demos.petsalon.role;

import lombok.Data;
import njuics.demos.petsalon.model.BaseEntity;
import njuics.demos.petsalon.model.ServiceCategory;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
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
  @JoinColumn(name = "pet")
  private Pet pet;

  public Service() {

  }

  public Service(Date date, Double fee, ServiceCategory category) {
    this.setDate(date);
    this.setFee(fee);
    this.setCategory(category);
  }
}
