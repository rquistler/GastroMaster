package de.hsb.gastromaster.data.order;

import com.google.auto.value.AutoValue;

import java.util.List;

import de.hsb.gastromaster.data.order.dish.Dish;

@AutoValue
public abstract class Order {

    private double totalPrice;

    public abstract int getId();

    public abstract String getTableNumber();

    //public abstract double getTotalPrice();

    public abstract int getWaitressId();

    public abstract String getDate();

    public abstract List<Dish> getDishList();


    public abstract Order withId(int id);

    public abstract Order withWaitressId(int waitressId);

    public abstract Order withTableNumber(String tableNumber);

    public abstract Order withDate(String date);

    public abstract Order withDishList(List<Dish> dishList);


    public static Builder builder() {
        return new AutoValue_Order.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder setId(int value);

        public abstract Builder setTableNumber(String value);

        //abstract Builder setTotalPrice(double value);

        public abstract Builder setWaitressId(int value);

        public abstract Builder setDate(String value);

        public abstract Builder setDishList(List<Dish> value);

        abstract List<Dish> getDishList();

        abstract Order autoBuild();

        public Order build() {

            return autoBuild();
        }
    }

    // Fake computed property - because object is immutable anyways
    // So only the first call actually calculates the total price
    // The other ones just return
    public final double getTotalPrice() {

        if (totalPrice == 0.0 && !getDishList().isEmpty()) {
            for (Dish dish : getDishList()) {
                totalPrice += dish.getPrice();
            }
        }

        return totalPrice;
    }
}
