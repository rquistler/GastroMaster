package de.hsb.gastromaster.data.order.dish;


import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Dish {

    public abstract int getId();

    public abstract int getOrderId();

    public abstract String getName();

    public abstract double getPrice();


    public abstract Dish withId(int id);

    public abstract Dish withOrderId(int orderId);

    public abstract Dish withName(String name);

    public abstract Dish withPrice(double price);


    public static Builder builder() {
        return new AutoValue_Dish.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setId(int value);

        public abstract Builder setOrderId(int value);

        public abstract Builder setName(String value);

        public abstract Builder setPrice(double value);

        public abstract Dish build();
    }
}
