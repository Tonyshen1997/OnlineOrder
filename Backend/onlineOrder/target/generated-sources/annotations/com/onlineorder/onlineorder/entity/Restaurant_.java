package com.onlineorder.onlineorder.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Restaurant.class)
public abstract class Restaurant_ {

	public static volatile SingularAttribute<Restaurant, String> address;
	public static volatile SingularAttribute<Restaurant, String> phone;
	public static volatile SingularAttribute<Restaurant, String> imageUrl;
	public static volatile SingularAttribute<Restaurant, String> name;
	public static volatile ListAttribute<Restaurant, MenuItem> menuItemList;
	public static volatile SingularAttribute<Restaurant, Integer> id;

	public static final String ADDRESS = "address";
	public static final String PHONE = "phone";
	public static final String IMAGE_URL = "imageUrl";
	public static final String NAME = "name";
	public static final String MENU_ITEM_LIST = "menuItemList";
	public static final String ID = "id";

}

