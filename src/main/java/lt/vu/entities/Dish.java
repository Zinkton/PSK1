package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dish")
@Getter
@Setter
@EqualsAndHashCode(of = "name")
@ToString(of = {"name", "restaurant"})
public class Dish {
  @Id
  private String name;

  @ManyToOne
  private Restaurant restaurant;

  @ManyToMany(mappedBy = "dishList")
  private List<Order> orderList = new ArrayList<>();
}
