/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.data.factories;


import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.Dish;
import de.hsb.gastromaster.data.request.Request;

/**
 * The type Request factory.
 */
public final class RequestFactory {

    private RequestFactory() {
    }

    /**
     * Request void request.
     *
     * @return the request
     */
    public static Request<Void> requestVoid() {
        return Request.<Void>builder()
                .setEntity(null)
                .build();
    }

    /**
     * Request integer request.
     *
     * @param integer the integer
     * @return the request
     */
    public static Request<Integer> requestInteger(int integer) {
        return Request.<Integer>builder()
                .setEntity(integer)
                .build();
    }

    /**
     * Request dish request.
     *
     * @param dish the dish
     * @return the request
     */
    public static Request<Dish> requestDish(Dish dish) {
        return Request.<Dish>builder()
                .setEntity(dish)
                .build();
    }

    /**
     * Request order request.
     *
     * @param order the order
     * @return the request
     */
    public static Request<Order> requestOrder(Order order) {
        return Request.<Order>builder()
                .setEntity(order)
                .build();
    }

}
