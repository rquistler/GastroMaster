package de.hsb.gastromaster.data.order.dish;


public class Dish implements IDish {

    private int id;
    private int orderId;
    private String name;
    private double price;

    public Dish(int id,
                int orderId,
                String name,
                double price) {

        this.id = id;
        this.orderId = orderId;
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
