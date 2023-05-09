package com.onlineorder.onlineorder.service;

import com.onlineorder.onlineorder.dao.MenuInfoDao;
import com.onlineorder.onlineorder.dao.OrderitemDao;
import com.onlineorder.onlineorder.entity.Customer;
import com.onlineorder.onlineorder.entity.MenuItem;
import com.onlineorder.onlineorder.entity.OrderItem;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    @Autowired
    private OrderitemDao orderitemDao;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MenuInfoDao menuInfoDao;

    public void saveOrderItem(int menuItemId) {
        final OrderItem orderItem = new OrderItem();
        final MenuItem menuItem = menuInfoDao.getMenuItem(menuItemId);

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        Customer customer = customerService.getCustomer(username);

        orderItem.setMenuItem(menuItem);
        orderItem.setCart(customer.getCart());
        orderItem.setQuantity(1);
        orderItem.setPrice(menuItem.getPrice());
        orderitemDao.save(orderItem);
    }

}
