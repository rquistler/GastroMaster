/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.data.order.dish;

import com.google.auto.value.AutoValue;


/**
 * The type Dish.
 */
@AutoValue
public abstract class Dish {

    /**
     * Gets id.
     *
     * @return the id
     */
    public abstract int getId();

    /**
     * Gets order id.
     *
     * @return the order id
     */
    public abstract int getOrderId();

    /**
     * Gets name.
     *
     * @return the name
     */
    public abstract String getName();

    /**
     * Gets price.
     *
     * @return the price
     */
    public abstract double getPrice();


    /**
     * With id dish.
     *
     * @param id the id
     * @return the dish
     */
    public abstract Dish withId(int id);

    /**
     * With order id dish.
     *
     * @param orderId the order id
     * @return the dish
     */
    public abstract Dish withOrderId(int orderId);

    /**
     * With name dish.
     *
     * @param name the name
     * @return the dish
     */
    public abstract Dish withName(String name);

    /**
     * With price dish.
     *
     * @param price the price
     * @return the dish
     */
    public abstract Dish withPrice(double price);


    /**
     * Builder builder.
     *
     * @return the builder
     */
    public static Builder builder() {
        return new AutoValue_Dish.Builder();
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
         * Sets order id.
         *
         * @param value the value
         * @return the order id
         */
        public abstract Builder setOrderId(int value);

        /**
         * Sets name.
         *
         * @param value the value
         * @return the name
         */
        public abstract Builder setName(String value);

        /**
         * Sets price.
         *
         * @param value the value
         * @return the price
         */
        public abstract Builder setPrice(double value);

        /**
         * Build dish.
         *
         * @return the dish
         */
        public abstract Dish build();
    }
}
