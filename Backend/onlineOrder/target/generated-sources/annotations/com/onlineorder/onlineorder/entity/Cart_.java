package com.onlineorder.onlineorder.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cart.class)
public abstract class Cart_ {

	public static volatile SingularAttribute<Cart, Double> totalPrice;
	public static volatile ListAttribute<Cart, OrderItem> orderItemList;
	public static volatile SingularAttribute<Cart, Integer> id;

	public static final String TOTAL_PRICE = "totalPrice";
	public static final String ORDER_ITEM_LIST = "orderItemList";
	public static final String ID = "id";

}

