package de.hsb.gastromaster.data.order.local;

import java.util.List;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.Dish;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import io.reactivex.Single;

/**
 * Created by cschaf on 09-May-17.
 */
public interface IOrderDataStore {

    /**
     * Gets number of dishes.
     *
     * @return the number of dishes
     */
    Single<Response<Integer>> getNumberOfDishes();

    /**
     * Add dish single.
     *
     * @param request the request
     * @return the single
     */
    Single<Response<Void>> addDish(Request<Dish> request);

    /**
     * Gets dish by index.
     *
     * @param request the request
     * @return the dish by index
     */
    Single<Response<Dish>> getDishByIndex(Request<Integer> request);

    /**
     * Gets all dishes.
     *
     * @return the all dishes
     */
    Single<Response<List<Dish>>> getAllDishes();

    /**
     * Add order single.
     *
     * @param request the request
     * @return the single
     */
    Single<Response<Void>> addOrder(Request<Order> request);

    /**
     * Gets order by id.
     *
     * @param request the request
     * @return the order by id
     */
    Single<Response<Order>> getOrderById(Request<Integer> request);

    /**
     * Gets all order.
     *
     * @return the all order
     */
    Single<Response<List<Order>>> getAllOrder();

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
