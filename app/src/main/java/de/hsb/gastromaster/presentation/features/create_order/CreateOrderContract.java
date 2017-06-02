package de.hsb.gastromaster.presentation.features.create_order;


import de.hsb.gastromaster.data.order.Order;

public interface CreateOrderContract {

    interface View {
        void showMessage(String message);
    }

    interface Presenter {
        void init();
        void createOrder(Order order);
    }
}
