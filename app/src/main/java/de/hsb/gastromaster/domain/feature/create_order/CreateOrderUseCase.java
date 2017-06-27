/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.domain.feature.create_order;

import de.hsb.gastromaster.data.order.IOrderDataRepository;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.domain.feature.BaseUseCase;
import io.reactivex.Single;

public class CreateOrderUseCase extends BaseUseCase<Order, Void> {

    private IOrderDataRepository orderDataRepository;

    /**
     * Instantiates a new Create order use case.
     *
     * @param orderDataRepository the order data repository
     */
    public CreateOrderUseCase(IOrderDataRepository orderDataRepository) {
        this.orderDataRepository = orderDataRepository;
    }

    @Override
    public Single<Response<Void>> execute(Request<Order> request) {
        return orderDataRepository.addOrder(request);
    }
}
