package de.hsb.gastromaster.presentation.features.order_list;

import java.util.List;

import de.hsb.gastromaster.data.order.Order;

public interface OrderListContract {
    interface View<T> {
        void goToOrderDetail(T item);
        void setOrderList(List<Order> orders);
    }

    interface Presenter<T> {
        void onItemClick(T item);
        void init();
    }
}
