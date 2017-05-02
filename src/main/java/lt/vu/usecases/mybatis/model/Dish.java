package lt.vu.usecases.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Dish {
    private Integer id;
    private String name;
    private Integer restaurant;

    private Restaurant restaurantObj;
    private List<Order> orders;
}