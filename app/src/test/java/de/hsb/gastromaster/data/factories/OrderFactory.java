package de.hsb.gastromaster.data.factories;


import java.util.ArrayList;
import java.util.List;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.Dish;

public final class OrderFactory {

    public static final String DEFAULT_DATE = "31-1-1990:19.00.32";
    public static final String DIFFERENT_DATE = "31-1-1990:19.00.33";

    private OrderFactory() {
    }

    public static Order order(List<Dish> dishList) {
        return Order.builder()
                .setId(1)
                .setWaitressId(1)
                .setTableNumber("1A")
                .setDate(DEFAULT_DATE)
                .setDishList(dishList)
                .build();
    }

    public static List<Order> orderList(List<Dish> dishList) {

        List<Order> orderList = new ArrayList<>();

        orderList.add(order(dishList));
        orderList.add(order(dishList));

        return orderList;
    }

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
