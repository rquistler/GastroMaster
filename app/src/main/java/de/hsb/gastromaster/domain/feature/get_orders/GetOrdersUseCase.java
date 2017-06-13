package de.hsb.gastromaster.domain.feature.get_orders;

import java.util.List;

import de.hsb.gastromaster.data.order.IOrderDataRepository;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.domain.feature.BaseUseCase;
import io.reactivex.Single;

/**
 * Created by roman on 13/06/17.
 */

public class GetOrdersUseCase extends BaseUseCase<Void, List<Order>> {

    private IOrderDataRepository orderDataRepository;

    public GetOrdersUseCase(IOrderDataRepository orderDataRepository) {
        this.orderDataRepository = orderDataRepository;
    }

    @Override
    public Single<Response<List<Order>>> execute(Request<Void> request) {
        return orderDataRepository.getAllOrders(request);
    }
}
