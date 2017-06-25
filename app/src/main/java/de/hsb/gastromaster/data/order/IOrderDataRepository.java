package de.hsb.gastromaster.data.order;

import java.util.List;

import de.hsb.gastromaster.data.order.dish.Dish;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import io.reactivex.Single;


public interface IOrderDataRepository {

    Single<Response<Void>> addOrder(Request<Order> request);

    Single<Response<List<Order>>> getAllOrders(Request<Void> request);

    Single<Response<Order>> getOrderById(Request<Integer> request);

    Single<Response<List<Dish>>> getAllDishes(Request<Void> request);
}
