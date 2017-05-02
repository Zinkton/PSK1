package lt.vu.usecases.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Order {

    private Integer id;
    private Integer customer;

    private Customer customerObj;
    private List<Dish> dishes;
}