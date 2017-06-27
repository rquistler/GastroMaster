/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.data.factories;


import java.util.ArrayList;
import java.util.List;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.Dish;

/**
 * The type Order factory.
 */
public final class OrderFactory {

    /**
     * The constant DEFAULT_DATE.
     */
    public static final String DEFAULT_DATE = "31-1-1990:19.00.32";
    /**
     * The constant DIFFERENT_DATE.
     */
    public static final String DIFFERENT_DATE = "31-1-1990:19.00.33";

    private OrderFactory() {
    }

    /**
     * Order order.
     *
     * @param dishList the dish list
     * @return the order
     */
    public static Order order(List<Dish> dishList) {
        return Order.builder()
                .setId(1)
                .setWaitressId(1)
                .setTableNumber("1A")
                .setDate(DEFAULT_DATE)
                .setDishList(dishList)
                .build();
    }

    /**
     * Order list list.
     *
     * @param dishList the dish list
     * @return the list
     */
    public static List<Order> orderList(List<Dish> dishList) {

        List<Order> orderList = new ArrayList<>();

        orderList.add(order(dishList));
        orderList.add(order(dishList));

        return orderList;
    }

    /**
     * Order list random list.
     *
     * @param dishList the dish list
     * @param size     the size
     * @return the list
     */
    public static List<Order> orderListRandom(List<Dish> dishList, int size) {

        List<Order> orderList = new ArrayList<>();

        for (int i = 0; i < size; i++) {

            orderList.add(Order.builder()
                    .setId(i)
                    .setWaitressId(i)
                    .setTableNumber(i + "A")
                    .setDate(DEFAULT_DATE + i)
                    .setDishList(dishList)
                    .build());
        }

        return orderList;
    }

}
