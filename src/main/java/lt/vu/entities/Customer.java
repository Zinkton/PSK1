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
@Table(name = "customer")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = {"id"})
public class Customer {
    @Id
    private String id;

    @OneToMany(mappedBy = "customer")
    private List<Order> orderList = new ArrayList<>();
}
