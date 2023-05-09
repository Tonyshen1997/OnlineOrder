package com.onlineorder.onlineorder.dao;


import com.onlineorder.onlineorder.entity.MenuItem;
import com.onlineorder.onlineorder.entity.Restaurant;
import com.onlineorder.onlineorder.entity.Restaurant_;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuInfoDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Restaurant> getRestaurants() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Restaurant> query = builder.createQuery(Restaurant.class);
            query.from(Restaurant.class);
            return session.createQuery(query).getResultList();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null)  session.close();
        }
        return new ArrayList<>();
    }

    public List<Restaurant> getRestaurantNames() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Tuple> criteria = builder.createQuery(Tuple.class);
            Root<Restaurant> root = criteria.from(Restaurant.class);

            Path<Integer> idPath = root.get(Restaurant_.id);
            Path<String> namePath = root.get(Restaurant_.name);

            criteria.multiselect(idPath, namePath);
            List<Tuple> tuples = session.createQuery(criteria).getResultList();


            List<Restaurant> restaurantNames = new ArrayList<>();
            for (Tuple tuple : tuples) {
                Restaurant restaurant = new Restaurant();
                restaurant.setId(tuple.get(idPath));
                restaurant.setName(tuple.get(namePath));
                restaurantNames.add(restaurant);
            }
            return restaurantNames;

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) session.close();
        }

        return new ArrayList<>();
    }

    public List<MenuItem> getAllMenuItem(int restaurantId) {
        Session session = null;
        try {
           session = sessionFactory.openSession();
           Restaurant restaurant = session.get(Restaurant.class, restaurantId);
           if (restaurant != null) {
               return restaurant.getMenuItemList();
           }
        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return new ArrayList<>();
    }

    public MenuItem getMenuItem(int menuItemId) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            MenuItem menuItem = session.get(MenuItem.class, menuItemId);
            return menuItem;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) session.close();
        }

        return null;
    }

}
