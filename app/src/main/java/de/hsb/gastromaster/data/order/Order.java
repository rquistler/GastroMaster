package de.hsb.gastromaster.data.order;


import java.util.List;

import de.hsb.gastromaster.data.order.dish.IDish;

public class Order {

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

    public int getId() {
        return id;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double newValue) {
        this.totalPrice = newValue;
    }

    public int getWaitressId() {
        return waitressId;
    }

    public void setWaitressId(int waitressId) {
        this.waitressId = waitressId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<IDish> getDishList() {
        return dishList;
    }
}
