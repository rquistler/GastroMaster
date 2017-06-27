package de.hsb.gastromaster.presentation.features.order_detail;


import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.Dish;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.domain.feature.get_order.GetOrderUseCase;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class OrderDetailPresenter implements OrderDetailContract.Presenter<Order>{

    private OrderDetailContract.View<Dish> fragment;
    private GetOrderUseCase useCase;
    public Order currentOrder;

    public OrderDetailPresenter(OrderDetailContract.View<Dish> fragment,
                              GetOrderUseCase useCase){
        this.useCase = useCase;
        this.fragment = fragment;
    }


    @Override
    public void onAddDishClick() {
        fragment.goToAddDish(currentOrder);
    }

    @Override
    public void init(int orderId) {
        useCase.execute(Request.<Integer>builder()
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
}
