/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.domain.feature.get_orders;

import java.util.List;

import de.hsb.gastromaster.data.order.IOrderDataRepository;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.domain.feature.BaseUseCase;
import io.reactivex.Single;


/**
 * The type Get orders use case.
 */
public class GetOrdersUseCase extends BaseUseCase<Void, List<Order>> {

    private IOrderDataRepository orderDataRepository;

    /**
     * Instantiates a new Get orders use case.
     *
     * @param orderDataRepository the order data repository
     */
    public GetOrdersUseCase(IOrderDataRepository orderDataRepository) {
        this.orderDataRepository = orderDataRepository;
    }

    @Override
    public Single<Response<List<Order>>> execute(Request<Void> request) {
        return orderDataRepository.getAllOrders(request);
    }
}
