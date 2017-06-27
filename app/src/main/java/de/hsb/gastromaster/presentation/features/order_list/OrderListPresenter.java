package de.hsb.gastromaster.presentation.features.order_list;

import java.util.ArrayList;
import java.util.List;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.domain.feature.create_order.CreateOrderUseCase;
import de.hsb.gastromaster.domain.feature.get_orders.GetOrdersUseCase;
import de.hsb.gastromaster.domain.feature.remove_order.RemoveOrderUseCase;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;


/**
 * The type Order list presenter.
 */
public class OrderListPresenter implements OrderListContract.Presenter<Order> {
    private OrderListContract.View<Order> fragment;
    private GetOrdersUseCase getOrdersUseCase;
    private RemoveOrderUseCase removeOrderUseCase;
    private List<Order> allOrders;

    /**
     * Instantiates a new Order list presenter.
     *
     * @param fragment           the fragment
     * @param getOrdersUseCase   the get orders use case
     * @param removeOrderUseCase the remove order use case
     */
    public OrderListPresenter(OrderListContract.View<Order> fragment,
                              GetOrdersUseCase getOrdersUseCase, RemoveOrderUseCase removeOrderUseCase) {
        this.getOrdersUseCase = getOrdersUseCase;
        this.removeOrderUseCase = removeOrderUseCase;
        this.fragment = fragment;

    }

    @Override
    public void onItemClick(Order item) {
        fragment.goToOrderDetail(item);
    }

    @Override
    public void onAddOrderClick(String tableNumber, Order order) {
        fragment.goToDishList(tableNumber, order);
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
                            if (order.getTableNumber().equals(tableNumber)) {
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

    @Override
    public void onItemLongClick(Order order) {
        removeOrderUseCase.execute(Request.<Order>builder()
                .setEntity(order)
                .build())
                .subscribeWith(new SingleObserver<Response<Void>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Response<Void> response) {
                        fragment.onItemRemoved();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
