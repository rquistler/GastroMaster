package de.hsb.gastromaster.data.order.dish;

/**
 * Created by cschaf on 02-May-17.
 */

public interface IDish {

    public int getId();

    public void setId(int id);

    public int getOrderId();

    public void setOrderId(int orderId);

    String getName();

    void setName(String name);

    double getPrice();

    void setPrice(double price);
}
