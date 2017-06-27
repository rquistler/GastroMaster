/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.presentation.features.order_list;

import java.util.List;

import de.hsb.gastromaster.data.order.Order;

/**
 * The interface Order list contract.
 */
public interface OrderListContract {
    /**
     * The interface View.
     *
     * @param <T> the type parameter
     */
    interface View<T> {
        /**
         * Go to order detail.
         *
         * @param item the item
         */
        void goToOrderDetail(T item);

        /**
         * Sets order list.
         *
         * @param orders the orders
         */
        void setOrderList(List<Order> orders);

        /**
         * Go to dish list.
         *
         * @param tableNumber the table number
         * @param order       the order
         */
        void goToDishList(String tableNumber, Order order);

        /**
         * On item removed.
         */
        void onItemRemoved();
    }

    /**
     * The interface Presenter.
     *
     * @param <T> the type parameter
     */
    interface Presenter<T> {
        /**
         * On item click.
         *
         * @param item the item
         */
        void onItemClick(T item);

        /**
         * On add order click.
         *
         * @param tableNumber the table number
         * @param item        the item
         */
        void onAddOrderClick(String tableNumber, T item);

        /**
         * Init.
         *
         * @param tableNumber the table number
         */
        void init(String tableNumber);

        /**
         * On item long click.
         *
         * @param itemListItem the item list item
         */
        void onItemLongClick(T itemListItem);
    }
}
