package de.hsb.gastromaster.data.order;

import java.util.List;

import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import io.reactivex.Single;

/**
 * Created by cschaf on 09-May-17.
 */

public interface IOrderDataRepository {

    Single<Response<Void>> addOrder(Request<Order> request);

    Single<Response<List<Order>>> getAllOrders(Request<Void> request);

    Single<Response<Order>> getOrderById(Request<Integer> request);
}
