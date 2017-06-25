package de.hsb.gastromaster.presentation.features.dish_list;

import java.util.List;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.Dish;

public interface DishListContract {
    interface View<T>{
        void onAddDishClick(T dish);
        void setDishList(List<Dish> dishes);
        void newOrderAdded(Order newOrder);
    }

    interface Presenter<T>{
        void init(int orderId);
        void onDishClick(String tableNumber, T dish, int orderId);
    }
}
