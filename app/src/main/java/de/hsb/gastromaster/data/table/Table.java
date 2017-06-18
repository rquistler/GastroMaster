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

    public abstract int getId();

    public abstract String getName();

    public abstract List<Order> getOrderList();

    public static Table.Builder builder() {
        return new AutoValue_Table.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder setId(int value);

        public abstract Builder setName(String value);

        public abstract Builder setOrderList(List<Order> value);

        public abstract Table build();
    }

    public final int getTotalOrders() {

        return getOrderList().size();
    }

}
