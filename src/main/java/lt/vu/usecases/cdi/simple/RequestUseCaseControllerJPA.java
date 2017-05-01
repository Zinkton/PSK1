package lt.vu.usecases.cdi.simple;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Dish;
import lt.vu.entities.Restaurant;
import lt.vu.usecases.cdi.dao.DishDAO;
import lt.vu.usecases.cdi.dao.RestaurantDAO;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
@Slf4j
public class RequestUseCaseControllerJPA {

    @Getter
    private Dish dish = new Dish();
    @Getter
    private Restaurant restaurant = new Restaurant();

    @Inject
    private DishDAO dishDAO;
    @Inject
    private RestaurantDAO restaurantDAO;

    @Transactional
    public void createDishRestaurant() {
        dish.setRestaurant(restaurant);
        restaurant.getDishList().add(dish);
        restaurantDAO.create(restaurant);
        dishDAO.create(dish);
        log.info("Maybe OK...");
    }

    public List<Dish> getAllDishes() {
        return dishDAO.getAllDishes();
    }
}
