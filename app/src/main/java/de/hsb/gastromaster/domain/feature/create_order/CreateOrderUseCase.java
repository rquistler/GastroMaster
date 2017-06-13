package de.hsb.gastromaster.domain.feature.create_order;

import de.hsb.gastromaster.data.order.IOrderDataRepository;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.domain.feature.BaseUseCase;
import io.reactivex.Single;

/**
 * Created by cschaf on 09-May-17.
 */

public class CreateOrderUseCase extends BaseUseCase<Order, Void>  {

    private IOrderDataRepository orderDataRepository;

    public CreateOrderUseCase(IOrderDataRepository orderDataRepository) {
        this.orderDataRepository = orderDataRepository;
    }

    @Override
    public Single<Response<Void>> execute(Request<Order> request) {
        return orderDataRepository.addOrder(request);
    }
}
