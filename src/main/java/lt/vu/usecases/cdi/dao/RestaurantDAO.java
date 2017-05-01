package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Restaurant;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class RestaurantDAO {
    @Inject
    private EntityManager em;

    public void create(Restaurant restaurant) {
        em.persist(restaurant);
    }
}
