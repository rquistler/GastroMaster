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

    Single<Response<Integer>> getNumberOfDishes();

    Single<Response<Void>> addDish(Request<Dish> request);

    Single<Response<Dish>> getDishByIndex(Request<Integer> request);

    Single<Response<List<Dish>>> getAllDishes();

    Single<Response<Void>> addOrder(Request<Order> request);

    Single<Response<Order>> getOrderById(Request<Integer> request);

    Single<Response<List<Order>>> getAllOrder();

    Single<Response<Void>> updateOrder(Request<Order> order);

    Single<Response<Void>> removeOrder(Request<Order> order);
}
