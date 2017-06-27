/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.data.factories;


import java.util.List;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.Dish;
import de.hsb.gastromaster.data.response.Response;

public final class ResponseFactory {

    private ResponseFactory() {
    }

    public static Response<Void> responseVoid() {

        return Response.<Void>builder()
                .setEntity(null)
                .setErrorMessage("")
                .setIsSuccessful(true)
                .build();
    }

    public static Response<Void> responseVoidError() {

        return Response.<Void>builder()
                .setEntity(null)
                .setErrorMessage("Error")
                .setIsSuccessful(false)
                .build();
    }

    public static Response<Integer> responseInteger(int integer) {

        return Response.<Integer>builder()
                .setEntity(integer)
                .setErrorMessage("")
                .setIsSuccessful(true)
                .build();
    }

    public static Response<Dish> responseDish(Dish dish) {

        return Response.<Dish>builder()
                .setEntity(dish)
                .setErrorMessage("")
                .setIsSuccessful(true)
                .build();
    }

    public static Response<Order> responseOrder(Order order) {

        return Response.<Order>builder()
                .setEntity(order)
                .setErrorMessage("")
                .setIsSuccessful(true)
                .build();
    }

    public static Response<List<Order>> responseOrderList(List<Order> orderList) {

        return Response.<List<Order>>builder()
                .setEntity(orderList)
                .setErrorMessage("")
                .setIsSuccessful(true)
                .build();
    }

    public static Response<Order> responseOrderError(Order order, String errorMessage) {

        return Response.<Order>builder()
                .setEntity(order)
                .setErrorMessage(errorMessage)
                .setIsSuccessful(false)
                .build();
    }

    public static Response<Dish> responseDishError(Dish dish, String errorMessage) {

        return Response.<Dish>builder()
                .setEntity(dish)
                .setErrorMessage(errorMessage)
                .setIsSuccessful(false)
                .build();
    }
}
