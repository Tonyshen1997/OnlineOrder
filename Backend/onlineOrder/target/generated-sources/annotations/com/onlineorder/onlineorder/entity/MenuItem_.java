package com.onlineorder.onlineorder.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MenuItem.class)
public abstract class MenuItem_ {

	public static volatile SingularAttribute<MenuItem, Double> price;
	public static volatile SingularAttribute<MenuItem, String> imageUrl;
	public static volatile SingularAttribute<MenuItem, Restaurant> restaurant;
	public static volatile SingularAttribute<MenuItem, String> name;
	public static volatile SingularAttribute<MenuItem, String> description;
	public static volatile SingularAttribute<MenuItem, Integer> id;

	public static final String PRICE = "price";
	public static final String IMAGE_URL = "imageUrl";
	public static final String RESTAURANT = "restaurant";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";

}

