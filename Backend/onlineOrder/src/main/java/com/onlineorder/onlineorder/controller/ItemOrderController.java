package com.onlineorder.onlineorder.controller;


import com.onlineorder.onlineorder.entity.OrderItem;
import com.onlineorder.onlineorder.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.annotation.RequestScope;

@Controller
public class ItemOrderController {

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping(value = "/order/{menuId}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addMenuItemToCart(@PathVariable("menuId") int menuId) {
        orderItemService.saveOrderItem(menuId);
    }
}
