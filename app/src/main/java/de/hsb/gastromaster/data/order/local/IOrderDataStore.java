package de.hsb.gastromaster.data.order.local;

import java.util.List;

import de.hsb.gastromaster.data.order.IOrder;
import de.hsb.gastromaster.data.order.dish.IDish;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import io.reactivex.Single;

/**
 * Created by cschaf on 09-May-17.
 */

public interface IOrderDataStore {

    Single<Response<Integer>> getNumberOfDishes();

    Single<Response<Void>> addDish(Request<IDish> request);

    Single<Response<IDish>> getDishByIndex(Request<Integer> request);

    Single<Response<List<IDish>>> getAllDishes();

    Single<Response<Void>> addOrder(Request<IOrder> request);

    Single<Response<IOrder>> getOrderById(Request<Integer> request);

    Single<Response<List<IOrder>>> getAllOrder();
}
