package de.hsb.gastromaster.data.table;

import com.google.auto.value.AutoValue;

import java.util.List;


import de.hsb.gastromaster.data.order.Order;

/**
 * Created by roman on 13/06/17.
 */
@AutoValue
public abstract class Table {

    private int totalOrders;

    /**
     * Gets id.
     *
     * @return the id
     */
    public abstract int getId();

    /**
     * Gets name.
     *
     * @return the name
     */
    public abstract String getName();

    /**
     * Gets order list.
     *
     * @return the order list
     */
    public abstract List<Order> getOrderList();

    /**
     * Builder table . builder.
     *
     * @return the table . builder
     */
    public static Table.Builder builder() {
        return new AutoValue_Table.Builder();
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
         * Sets name.
         *
         * @param value the value
         * @return the name
         */
        public abstract Builder setName(String value);

        /**
         * Sets order list.
         *
         * @param value the value
         * @return the order list
         */
        public abstract Builder setOrderList(List<Order> value);

        /**
         * Build table.
         *
         * @return the table
         */
        public abstract Table build();
    }

    /**
     * Gets total orders.
     *
     * @return the total orders
     */
    public final int getTotalOrders() {

        return getOrderList().size();
    }

}
