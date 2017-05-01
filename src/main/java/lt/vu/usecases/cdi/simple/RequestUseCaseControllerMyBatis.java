package lt.vu.usecases.cdi.simple;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.usecases.mybatis.dao.*;
import lt.vu.usecases.mybatis.model.*;

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

    public List<Order> getAllOrders() {
        return orderMapper.selectAll();
    }

    @Transactional
    public void createOrderCustomer() {
        restaurantMapper.insert(restaurant);
        dish.setRestaurant(restaurant.getId());
        dishMapper.insert(dish);
        customerMapper.insert(customer);
        order.setCustomer(customer.getId());
        orderMapper.insert(order);
        OrdersDishes ordersDishes = new OrdersDishes();
        ordersDishes.setDishId(dish.getId());
        ordersDishes.setOrderId(order.getId());
        ordersDishesMapper.insert(ordersDishes);
        log.info("Maybe OK...");
    }
}
