package de.hsb.gastromaster.presentation.features.create_order;


import de.hsb.gastromaster.data.order.IOrder;

public interface CreateOrderContract {

    interface View {
        void showMessage(String message);
    }

    interface Presenter {
        void init();
        void createOrder(IOrder order);
    }
}
