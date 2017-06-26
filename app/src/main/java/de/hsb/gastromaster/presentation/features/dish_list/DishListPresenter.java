package de.hsb.gastromaster.presentation.features.dish_list;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.Dish;
import de.hsb.gastromaster.data.order.local.OrderDataStore;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.domain.feature.create_order.CreateOrderUseCase;
import de.hsb.gastromaster.domain.feature.get_dishes.GetDishesUseCase;
import de.hsb.gastromaster.domain.feature.get_order.GetOrderUseCase;
import de.hsb.gastromaster.domain.feature.update_order.UpdateOrderUseCase;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

class DishListPresenter implements DishListContract.Presenter<Dish>{
    private DishListContract.View<Dish> fragment;
    private GetDishesUseCase getDishesUserCase;
    private CreateOrderUseCase createOrderUseCase;
    private GetOrderUseCase getOrderUseCase;
    private UpdateOrderUseCase updateOrderUseCase;
    private List<Dish> allDishes;
    private Order order;

    public DishListPresenter(DishListContract.View<Dish> fragment,
                             GetDishesUseCase getDishesUserCase, CreateOrderUseCase createOrderUseCase, GetOrderUseCase getOrderUseCase, UpdateOrderUseCase updateOrderUseCase){
        this.getDishesUserCase = getDishesUserCase;
        this.createOrderUseCase = createOrderUseCase;
        this.getOrderUseCase = getOrderUseCase;
        this.updateOrderUseCase = updateOrderUseCase;
        this.fragment = fragment;


    }
    @Override
    public void init(int orderId) {
        getDishesUserCase.execute(Request.<Void>builder()
                .setEntity(null)
                .build())
                .subscribeWith(new SingleObserver<Response<List<Dish>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Response<List<Dish>> listResponse) {
                        fragment.setDishList(listResponse.getEntity());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    @Override
    public void onDishClick(String tableNumber, Dish dish, int orderId) {
        if (orderId == -1){
            Order newOrder = Order.builder().setId(OrderDataStore.LastID++)
                    .setDate(new SimpleDateFormat("MM-dd-yyyy:HH.mm.ss").format(Calendar.getInstance().getTime()))
                    .setDishList(Arrays.asList(dish))
                    .setTableNumber(tableNumber)
                    .setWaitressId(1).build();

            createOrder(newOrder);
        }
        else{
//            Wegen Backstackfehlern deaktiviert!
//            updateOrder(orderId, dish);
        }

    }

    private void createOrder(Order newOrder) {
        createOrderUseCase.execute(Request.<Order>builder()
                .setEntity(newOrder)
                .build())
                .subscribeWith(new SingleObserver<Response<Void>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Response<Void> listResponse) {
                        fragment.newOrderAdded(newOrder);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    private void updateOrder(int orderId, Dish dish) {

        getOrderUseCase.execute(Request.<Integer>builder()
                .setEntity(orderId)
                .build())
                .subscribeWith(new SingleObserver<Response<Order>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(Response<Order> listResponse) {
                        order = listResponse.getEntity();
                    }
                    @Override
                    public void onError(Throwable e) {

                    }
                });


        if (order != null){
            ArrayList<Dish> newDishList = new ArrayList<>();
            for (Dish each : order.getDishList()) {
                newDishList.add(each);
            }
            newDishList.add(dish);

            order = order.withDishList(newDishList);
        }

        updateOrderUseCase.execute(Request.<Order>builder()
                .setEntity(order)
                .build())
                .subscribeWith(new SingleObserver<Response<Void>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Response<Void> listResponse) {
                        fragment.onOrderUpdated(order);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }
}
