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
@Table(name = "restaurant")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "name"})
public class Restaurant {
    @Id
    @SequenceGenerator(name="restaurant_id_seq", sequenceName="restaurant_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="restaurant_id_seq")
    private Long id;

    @Size(min = 3, max = 16)
    private String name;

    @OneToMany(mappedBy = "restaurant")
    private List<Dish> dishList = new ArrayList<>();
}
