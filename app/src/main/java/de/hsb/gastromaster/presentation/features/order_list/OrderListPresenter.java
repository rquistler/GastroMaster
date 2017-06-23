package de.hsb.gastromaster.presentation.features.order_list;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.domain.feature.get_orders.GetOrdersUseCase;


public class OrderListPresenter implements OrderListContract.Presenter<Order> {
    private OrderListContract.View<Order> fragment;
    private GetOrdersUseCase useCase;

    public OrderListPresenter(OrderListContract.View<Order> fragment,
                              GetOrdersUseCase useCase){
        this.useCase = useCase;
        this.fragment = fragment;
    }
    @Override
    public void onItemClick(Order item) {

    }

    @Override
    public void init() {

    }
}
