package de.hsb.gastromaster.data.order;

import java.util.List;

import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import io.reactivex.Single;

/**
 * Created by cschaf on 09-May-17.
 */

public interface IOrderDataRepository {

    Single<Response<Void>> addOrder(Request<IOrder> request);

    Single<Response<List<IOrder>>> getAllOrders();
}
