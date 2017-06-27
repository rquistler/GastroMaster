package de.hsb.gastromaster.data.order;

import com.google.auto.value.AutoValue;

import java.util.List;

import de.hsb.gastromaster.data.order.dish.Dish;

@AutoValue
public abstract class Order {

    private double totalPrice;

    public abstract int getId();

    public abstract String getTableNumber();

    public abstract int getWaitressId();

    public abstract String getDate();

    public abstract boolean getIsCompleted();

    public abstract List<Dish> getDishList();


    public abstract Order withId(int id);

    public abstract Order withWaitressId(int waitressId);

    public abstract Order withTableNumber(String tableNumber);

    public abstract Order withDate(String date);

    public abstract Order withDishList(List<Dish> dishList);


    public static Builder builder() {
        return new AutoValue_Order.Builder()
                .setIsCompleted(false);
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder setId(int value);

        public abstract Builder setTableNumber(String value);

        public abstract Builder setWaitressId(int value);

        public abstract Builder setDate(String value);

        public abstract Builder setDishList(List<Dish> value);

        public abstract Builder setIsCompleted(boolean value);

        abstract List<Dish> getDishList();

        abstract Order autoBuild();

        public Order build() {

            return autoBuild();
        }
    }

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
