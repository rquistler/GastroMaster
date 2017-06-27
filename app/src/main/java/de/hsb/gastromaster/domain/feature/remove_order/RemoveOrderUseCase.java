package de.hsb.gastromaster.domain.feature.remove_order;


import de.hsb.gastromaster.data.order.IOrderDataRepository;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.domain.feature.BaseUseCase;
import io.reactivex.Single;

public class RemoveOrderUseCase extends BaseUseCase<Order, Void> {
    private IOrderDataRepository orderDataRepository;

    public RemoveOrderUseCase(IOrderDataRepository orderDataRepository) {
        this.orderDataRepository = orderDataRepository;
    }

    @Override
    public Single<Response<Void>> execute(Request<Order> request) {
        return orderDataRepository.removeOrder(request);
    }
}
