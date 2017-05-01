package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Dish;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class DishDAO {
    @Inject
    private EntityManager em;

    public void create(Dish dish) {
        em.persist(dish);
    }

    public List<Dish> getAllDishes() {
        return em.createNamedQuery("Dish.findAll", Dish.class).getResultList();
    }
}
