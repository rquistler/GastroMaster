package de.hsb.gastromaster.data.stubs;

import de.hsb.gastromaster.data.order.dish.IDish;

/**
 * Created by cschaf on 02-May-17.
 */

public class DishStub implements IDish{

    @Override
    public String getName() {
        return "Salami Pizza";
    }

    @Override
    public void setName(String name) {
        return;
    }

    @Override
    public double getPrice() {
        return 7.5;
    }

    @Override
    public void setPrice(double price) {
        return;
    }

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public void setId(int id) {
        return;
    }

    @Override
    public int getOrderId() {
        return 1;
    }

    @Override
    public void setOrderId(int orderId) {
        return;
    }

    @Override
    public boolean equals(Object obj) {
        IDish comparedTo = (IDish) obj;

        return comparedTo.getName().equals("Salami Pizza");
    }
}
