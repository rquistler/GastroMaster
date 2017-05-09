package de.hsb.gastromaster.data.order.local;

import java.util.List;

import de.hsb.gastromaster.data.order.IOrder;
import de.hsb.gastromaster.data.order.dish.IDish;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;

/**
 * Created by cschaf on 09-May-17.
 */

public interface IOrderDataStore {
    Response<Integer> getNumberOfDishes();

    Response<Void> addDish(Request<IDish> request);

    Response<IDish> getDishByIndex(Request<Integer> request);

    Response<List<IDish>> getAllDishes();

    Response<Void> addOrder(Request<IOrder> request);

    Response<IOrder> getOrderById(Request<Integer> request);

    Response<List<IOrder>> getAllOrder();
}
