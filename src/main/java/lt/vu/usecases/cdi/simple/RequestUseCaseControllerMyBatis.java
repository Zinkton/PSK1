package lt.vu.usecases.cdi.simple;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.usecases.mybatis.dao.*;
import lt.vu.usecases.mybatis.model.*;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
@Slf4j
public class RequestUseCaseControllerMyBatis {

    @Getter
    private Dish dish = new Dish();
    @Getter
    private Order order = new Order();
    @Getter
    private Customer customer = new Customer();
    @Getter
    private Restaurant restaurant = new Restaurant();
    @Getter
    private List<Order> allOrders;

    @PostConstruct
    public void init() {
        loadAllOrders();
    }

    @Inject
    private DishMapper dishMapper;
    @Inject
    private OrderMapper orderMapper;
    @Inject
    private CustomerMapper customerMapper;
    @Inject
    private RestaurantMapper restaurantMapper;
    @Inject
    private OrdersDishesMapper ordersDishesMapper;

    @Transactional
    public void createOrderCustomer() {
        restaurantMapper.insert(restaurant);
        customerMapper.insert(customer);

        order.setCustomer(customer.getId());
        dish.setRestaurant(restaurant.getId());

        dishMapper.insert(dish);
        orderMapper.insert(order);

        OrdersDishes ordersDishes = new OrdersDishes();
        ordersDishes.setDishId(dish.getId());
        ordersDishes.setOrderId(order.getId());
        ordersDishesMapper.insert(ordersDishes);

        log.info("Maybe OK...");
        //log.info(allOrders.get(0).getCustomer() + "");
    }

    private void loadAllOrders() {
        allOrders = orderMapper.selectAll();
    }
}
