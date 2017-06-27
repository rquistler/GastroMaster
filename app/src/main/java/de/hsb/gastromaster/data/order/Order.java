/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.data.order;

import com.google.auto.value.AutoValue;

import java.util.List;

import de.hsb.gastromaster.data.order.dish.Dish;

/**
 * The type Order.
 */
@AutoValue
public abstract class Order {

    private double totalPrice;

    /**
     * Gets id.
     *
     * @return the id
     */
    public abstract int getId();

    /**
     * Gets table number.
     *
     * @return the table number
     */
    public abstract String getTableNumber();

    /**
     * Gets waitress id.
     *
     * @return the waitress id
     */
    public abstract int getWaitressId();

    /**
     * Gets date.
     *
     * @return the date
     */
    public abstract String getDate();

    /**
     * Gets is completed.
     *
     * @return the is completed
     */
    public abstract boolean getIsCompleted();

    /**
     * Gets dish list.
     *
     * @return the dish list
     */
    public abstract List<Dish> getDishList();


    /**
     * With id order.
     *
     * @param id the id
     * @return the order
     */
    public abstract Order withId(int id);

    /**
     * With waitress id order.
     *
     * @param waitressId the waitress id
     * @return the order
     */
    public abstract Order withWaitressId(int waitressId);

    /**
     * With table number order.
     *
     * @param tableNumber the table number
     * @return the order
     */
    public abstract Order withTableNumber(String tableNumber);

    /**
     * With date order.
     *
     * @param date the date
     * @return the order
     */
    public abstract Order withDate(String date);

    /**
     * With dish list order.
     *
     * @param dishList the dish list
     * @return the order
     */
    public abstract Order withDishList(List<Dish> dishList);


    /**
     * Builder builder.
     *
     * @return the builder
     */
    public static Builder builder() {
        return new AutoValue_Order.Builder()
                .setIsCompleted(false);
    }

    /**
     * The type Builder.
     */
    @AutoValue.Builder
    public abstract static class Builder {

        /**
         * Sets id.
         *
         * @param value the value
         * @return the id
         */
        public abstract Builder setId(int value);

        /**
         * Sets table number.
         *
         * @param value the value
         * @return the table number
         */
        public abstract Builder setTableNumber(String value);

        /**
         * Sets waitress id.
         *
         * @param value the value
         * @return the waitress id
         */
        public abstract Builder setWaitressId(int value);

        /**
         * Sets date.
         *
         * @param value the value
         * @return the date
         */
        public abstract Builder setDate(String value);

        /**
         * Sets dish list.
         *
         * @param value the value
         * @return the dish list
         */
        public abstract Builder setDishList(List<Dish> value);

        /**
         * Sets is completed.
         *
         * @param value the value
         * @return the is completed
         */
        public abstract Builder setIsCompleted(boolean value);

        /**
         * Gets dish list.
         *
         * @return the dish list
         */
        abstract List<Dish> getDishList();

        /**
         * Auto build order.
         *
         * @return the order
         */
        abstract Order autoBuild();

        /**
         * Build order.
         *
         * @return the order
         */
        public Order build() {

            return autoBuild();
        }
    }

    /**
     * Gets total price.
     *
     * @return the total price
     */
// Fake computed property - because object is immutable anyways
    // So only the first call actually calculates the total price
    // The other ones just return
    public double getTotalPrice() {
        totalPrice = 0.0;
        for (Dish dish :
                getDishList()) {
            totalPrice += dish.getPrice();
        }
        return totalPrice;
    }
}
