/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.presentation.features.dish_list;

import java.util.List;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.Dish;

/**
 * The interface Dish list contract.
 */
public interface DishListContract {
    /**
     * The interface View.
     *
     * @param <T> the type parameter
     */
    interface View<T> {
        /**
         * On add dish click.
         *
         * @param dish the dish
         */
        void onAddDishClick(T dish);

        /**
         * Sets dish list.
         *
         * @param dishes the dishes
         */
        void setDishList(List<Dish> dishes);

        /**
         * New order added.
         *
         * @param newOrder the new order
         */
        void newOrderAdded(Order newOrder);

        /**
         * On order updated.
         *
         * @param order the order
         */
        void onOrderUpdated(Order order);
    }

    /**
     * The interface Presenter.
     *
     * @param <T> the type parameter
     */
    interface Presenter<T> {
        /**
         * Init.
         *
         * @param orderId the order id
         */
        void init(int orderId);

        /**
         * On dish click.
         *
         * @param tableNumber the table number
         * @param dish        the dish
         * @param orderId     the order id
         */
        void onDishClick(String tableNumber, T dish, int orderId);
    }
}
