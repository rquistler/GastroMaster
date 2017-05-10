package de.hsb.gastromaster.domain.feature.create_order;

import de.hsb.gastromaster.data.order.IOrderDataRepository;
import de.hsb.gastromaster.domain.feature.BaseUseCase;

/**
 * Created by cschaf on 09-May-17.
 */

public class CreateOrderUseCase extends BaseUseCase{

    private IOrderDataRepository orderDataRepository;

    public CreateOrderUseCase(IOrderDataRepository orderDataRepository) {
        this.orderDataRepository = orderDataRepository;
    }


}
