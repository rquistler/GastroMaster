package de.hsb.gastromaster.domain.feature.get_order;

import de.hsb.gastromaster.data.order.IOrderDataRepository;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.domain.feature.BaseUseCase;
import io.reactivex.Single;


/**
 * The type Get order use case.
 */
public class GetOrderUseCase extends BaseUseCase<Integer, Order> {
    private IOrderDataRepository orderDataRepository;

    /**
     * Instantiates a new Get order use case.
     *
     * @param orderDataRepository the order data repository
     */
    public GetOrderUseCase(IOrderDataRepository orderDataRepository) {
        this.orderDataRepository = orderDataRepository;
    }

    @Override
    public Single<Response<Order>> execute(Request<Integer> request) {
        return orderDataRepository.getOrderById(request);
    }
}
