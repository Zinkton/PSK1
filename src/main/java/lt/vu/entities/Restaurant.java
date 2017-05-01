package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lt.vu.entities.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@EqualsAndHashCode(of = "name")
@ToString(of = {"name"})
public class Restaurant {
    @Id
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "restaurant")
    private List<Dish> dishList = new ArrayList<>();
}
