/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.data.order;

import java.util.List;

import de.hsb.gastromaster.data.order.dish.Dish;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import io.reactivex.Single;


/**
 * The interface Order data repository.
 */
public interface IOrderDataRepository {

    /**
     * Add order single.
     *
     * @param request the request
     * @return the single
     */
    Single<Response<Void>> addOrder(Request<Order> request);

    /**
     * Gets all orders.
     *
     * @param request the request
     * @return the all orders
     */
    Single<Response<List<Order>>> getAllOrders(Request<Void> request);

    /**
     * Gets order by id.
     *
     * @param request the request
     * @return the order by id
     */
    Single<Response<Order>> getOrderById(Request<Integer> request);

    /**
     * Gets all dishes.
     *
     * @param request the request
     * @return the all dishes
     */
    Single<Response<List<Dish>>> getAllDishes(Request<Void> request);

    /**
     * Update order single.
     *
     * @param order the order
     * @return the single
     */
    Single<Response<Void>> updateOrder(Request<Order> order);

    /**
     * Remove order single.
     *
     * @param order the order
     * @return the single
     */
    Single<Response<Void>> removeOrder(Request<Order> order);
}
