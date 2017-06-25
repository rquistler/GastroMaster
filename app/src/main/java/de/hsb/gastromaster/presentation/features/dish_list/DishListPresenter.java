package de.hsb.gastromaster.presentation.features.dish_list;

import java.util.List;

import de.hsb.gastromaster.data.order.dish.Dish;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.domain.feature.get_dishes.GetDishesUseCase;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

class DishListPresenter implements DishListContract.Presenter<Dish>{
    private DishListContract.View<Dish> fragment;
    private GetDishesUseCase getDishesUserCase;
    private List<Dish> allDishes;

    public DishListPresenter(DishListContract.View<Dish> fragment,
                              GetDishesUseCase getDishesUserCase){
        this.getDishesUserCase = getDishesUserCase;
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
    public void onDishClick(Dish dish, int orderId) {
        if (orderId == -1){
//            new order with dish
            fragment.addOrderWithDish(dish);
        }
        else{
//            add dish to existing order
//            fragment.addDishToOrder(dish, orderId);
        }

    }
}
