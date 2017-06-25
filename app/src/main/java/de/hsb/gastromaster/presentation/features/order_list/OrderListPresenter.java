package de.hsb.gastromaster.presentation.features.order_list;

import java.util.ArrayList;
import java.util.List;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.domain.feature.create_order.CreateOrderUseCase;
import de.hsb.gastromaster.domain.feature.get_orders.GetOrdersUseCase;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;


public class OrderListPresenter implements OrderListContract.Presenter<Order> {
    private OrderListContract.View<Order> fragment;
    private GetOrdersUseCase getOrdersUseCase;
    private CreateOrderUseCase createOrderUseCase;
    private List<Order> allOrders;

    public OrderListPresenter(OrderListContract.View<Order> fragment,
                              GetOrdersUseCase getOrdersUseCase, CreateOrderUseCase createOrderUseCase){
        this.getOrdersUseCase = getOrdersUseCase;
        this.createOrderUseCase = createOrderUseCase;
        this.fragment = fragment;

    }
    @Override
    public void onItemClick(Order item) {
        fragment.goToOrderDetail(item);
    }

    @Override
    public void onAddOrderClick(Order order) {
        fragment.goToDishList(order);
    }

    @Override
    public void init(String tableNumber) {
        getOrdersUseCase.execute(Request.<Void>builder()
                .setEntity(null)
                .build())
                .subscribeWith(new SingleObserver<Response<List<Order>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Response<List<Order>> listResponse) {
                        allOrders = listResponse.getEntity();
                        ArrayList<Order> result = new ArrayList<>();

                        for (Order order : allOrders) {
                            if (order.getTableNumber().equals(tableNumber)){
                                result.add(order);
                            }
                        }
                        fragment.setOrderList(result);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
