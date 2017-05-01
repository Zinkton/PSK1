package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dish")
@NamedQueries({
        @NamedQuery(name = "Dish.findAll", query = "SELECT d FROM Dish d")
})
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "name", "restaurant"})
public class Dish {
  @Id
  @SequenceGenerator(name="dish_id_seq", sequenceName="dish_id_seq", allocationSize=1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="dish_id_seq")
  private Long id;

  @Size(min = 3, max = 16)
  private String name;

  @JoinColumn(name = "restaurant", referencedColumnName = "id")
  @ManyToOne
  private Restaurant restaurant;

  @ManyToMany(mappedBy = "dishList")
  private List<Order> orderList = new ArrayList<>();
}
