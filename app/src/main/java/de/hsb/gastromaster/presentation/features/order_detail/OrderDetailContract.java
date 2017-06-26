package de.hsb.gastromaster.presentation.features.order_detail;

import java.util.List;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.Dish;

public interface OrderDetailContract {

    interface View<T>{
        void goToAddDish(Order order);
        void loadOrder(Order order);
    }

    interface Presenter<T>{
        void onAddDishClick();
        void init(int orderId);

    }

}
