package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "customer"})
public class Order {
    @Id
    @SequenceGenerator(name="order_id_seq", sequenceName="order_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="order_id_seq")
    private Long id;

    @JoinColumn(name = "customer", referencedColumnName = "id")
    @ManyToOne
    private Customer customer;

    @JoinTable(name = "orders_dishes")
    @ManyToMany
    private List<Dish> dishList = new ArrayList<>();
}
