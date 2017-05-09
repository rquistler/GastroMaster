package de.hsb.gastromaster.data.order;


import java.util.List;

import de.hsb.gastromaster.data.order.dish.IDish;

public class Order implements IOrder {

    private int id;
    private String tableNumber;
    private double totalPrice;
    private int waitressId;
    private String date;
    private List<IDish> dishList;

    public Order(int id,
                 String tableNumber,
                 double totalPrice,
                 int waitressId,
                 String date,
                 List<IDish> dishList) {

        this.id = id;
        this.tableNumber = tableNumber;
        this.totalPrice = totalPrice;
        this.waitressId = waitressId;
        this.date = date;
        this.dishList = dishList;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTableNumber() {
        return tableNumber;
    }

    @Override
    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    @Override
    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public void setTotalPrice(double newValue) {
        this.totalPrice = newValue;
    }

    @Override
    public int getWaitressId() {
        return waitressId;
    }

    @Override
    public void setWaitressId(int waitressId) {
        this.waitressId = waitressId;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public List<IDish> getDishList() {
        return dishList;
    }
}
