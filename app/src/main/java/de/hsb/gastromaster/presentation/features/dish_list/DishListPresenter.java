package de.hsb.gastromaster.presentation.features.dish_list;

import java.text.SimpleDateFormat;
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
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

class DishListPresenter implements DishListContract.Presenter<Dish>{
    private DishListContract.View<Dish> fragment;
    private GetDishesUseCase getDishesUserCase;
    private CreateOrderUseCase createOrderUseCase;
    private List<Dish> allDishes;

    public DishListPresenter(DishListContract.View<Dish> fragment,
                             GetDishesUseCase getDishesUserCase, CreateOrderUseCase createOrderUseCase){
        this.getDishesUserCase = getDishesUserCase;
        this.createOrderUseCase = createOrderUseCase;
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
        else{
//            add dish to existing order
//            fragment.addDishToOrder(dish, orderId);
        }

    }
}
