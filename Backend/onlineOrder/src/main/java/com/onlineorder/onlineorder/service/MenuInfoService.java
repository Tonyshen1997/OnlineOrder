package com.onlineorder.onlineorder.service;

import com.onlineorder.onlineorder.dao.MenuInfoDao;
import com.onlineorder.onlineorder.entity.MenuItem;
import com.onlineorder.onlineorder.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuInfoService {

    @Autowired
    private MenuInfoDao menuInfoDao;

    public List<Restaurant> getRestaurants() {
//        return menuInfoDao.getRestaurants();
        return menuInfoDao.getRestaurantNames();
    }

    public List<MenuItem> getAllMenuItems(int restaurantId) {
        return menuInfoDao.getAllMenuItem(restaurantId);
    }

    public MenuItem getMenuItem(int menuItemId) {
        return menuInfoDao.getMenuItem(menuItemId);
    }

}
