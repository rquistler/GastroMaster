/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.presentation.features.order_detail;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.Dish;

/**
 * The interface Order detail contract.
 */
public interface OrderDetailContract {

    /**
     * The interface View.
     *
     * @param <T> the type parameter
     */
    interface View<T> {
        /**
         * Go to add dish.
         *
         * @param order the order
         */
        void goToAddDish(Order order);

        /**
         * Load order.
         *
         * @param order the order
         */
        void loadOrder(Order order);

        /**
         * On order updated.
         *
         * @param orderId the order id
         */
        void onOrderUpdated(int orderId);
    }

    /**
     * The interface Presenter.
     *
     * @param <T> the type parameter
     */
    interface Presenter<T> {
        /**
         * On add dish click.
         */
        void onAddDishClick();

        /**
         * Init.
         *
         * @param orderId the order id
         */
        void init(int orderId);

        /**
         * On item long click.
         *
         * @param item the item
         */
        void onItemLongClick(Dish item);
    }

}
