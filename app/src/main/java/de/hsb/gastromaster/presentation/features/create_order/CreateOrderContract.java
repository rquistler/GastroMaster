/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.presentation.features.create_order;


import de.hsb.gastromaster.data.order.Order;

/**
 * The interface Create order contract.
 */
public interface CreateOrderContract {

    /**
     * The interface View.
     */
    interface View {
        /**
         * Show message.
         *
         * @param message the message
         */
        void showMessage(String message);
    }

    /**
     * The interface Presenter.
     */
    interface Presenter {
        /**
         * Init.
         */
        void init();

        /**
         * Create order.
         *
         * @param order the order
         */
        void createOrder(Order order);
    }
}
