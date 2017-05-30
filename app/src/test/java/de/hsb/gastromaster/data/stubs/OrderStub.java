package de.hsb.gastromaster.data.stubs;

import java.util.ArrayList;
import java.util.List;

import de.hsb.gastromaster.data.order.IOrder;
import de.hsb.gastromaster.data.order.dish.IDish;


public class OrderStub implements IOrder {
    @Override
    public int getId() {
        return 1;
    }

    @Override
    public String getTableNumber() {
        return "1A";
    }

    @Override
    public void setTableNumber(String tableNumber) {
        return;
    }

    @Override
    public double getTotalPrice() {
        return 0.0;
    }

    @Override
    public void setTotalPrice(double newValue) {
        return;
    }

    @Override
    public int getWaitressId() {
        return 1;
    }

    @Override
    public void setWaitressId(int waitressId) {
        return;
    }

    @Override
    public String getDate() {
        return "31-1-1990:19.00.32";
    }

    @Override
    public void setDate(String date) {
        return;
    }

    @Override
    public void setId(int id) {
        return;
    }

    @Override
    public List<IDish> getDishList() {
        IDish dish = new DishStub();
        ArrayList<IDish> dishArrayList = new ArrayList<IDish>();
        dishArrayList.add(dish);
        return dishArrayList;
    }

    @Override
    public boolean equals(Object obj) {
        IOrder comparedTo = (IOrder)obj;
        return comparedTo.getTableNumber().equals("1A")
                && comparedTo.getId() == 1;
    }
}
