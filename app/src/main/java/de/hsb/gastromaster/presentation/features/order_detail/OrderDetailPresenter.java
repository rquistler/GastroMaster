package de.hsb.gastromaster.presentation.features.order_detail;


import java.util.ArrayList;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.Dish;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.domain.feature.get_order.GetOrderUseCase;
import de.hsb.gastromaster.domain.feature.update_order.UpdateOrderUseCase;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class OrderDetailPresenter implements OrderDetailContract.Presenter<Order>{

    private OrderDetailContract.View<Dish> fragment;
    private GetOrderUseCase getOrderUseCase;
    private UpdateOrderUseCase updateOrderUseCase;
    public Order currentOrder;

    public OrderDetailPresenter(OrderDetailContract.View<Dish> fragment,
                                GetOrderUseCase useCase, UpdateOrderUseCase updateOrderUseCase){
        this.getOrderUseCase = useCase;
        this.updateOrderUseCase = updateOrderUseCase;
        this.fragment = fragment;
    }


    @Override
    public void onAddDishClick() {
        fragment.goToAddDish(currentOrder);
    }

    @Override
    public void init(int orderId) {
        getOrderUseCase.execute(Request.<Integer>builder()
                .setEntity(orderId)
                .build())
                .subscribeWith(new SingleObserver<Response<Order>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Response<Order> orderResponse) {
                        currentOrder = orderResponse.getEntity();
                        fragment.loadOrder(currentOrder);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }

    @Override
    public void onItemLongClick(Dish item) {
        updateOrder(item);
    }

    private void updateOrder(Dish dish) {
            ArrayList<Dish> newDishList = new ArrayList<>();
            boolean deleted = false;
            for (Dish each : currentOrder.getDishList()) {
                if (each.getId() == dish.getId() && !deleted){
                    deleted = true;
                    continue;
                }
                newDishList.add(each);
            }
            currentOrder = currentOrder.withDishList(newDishList);

        updateOrderUseCase.execute(Request.<Order>builder()
                .setEntity(currentOrder)
                .build())
                .subscribeWith(new SingleObserver<Response<Void>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Response<Void> listResponse) {
                        fragment.onOrderUpdated(currentOrder.getId());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }
}
