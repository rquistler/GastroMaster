package de.hsb.gastromaster.data;


public class Order {

    private int id;
    private String tableNumber;
    private double totalPrice;
    private int waitressId;
    private String date;
    private Dish dish;

    public Order(int id,
                 String tableNumber,
                 double totalPrice,
                 int waitressId,
                 String date,
                 Dish dish) {

        this.id = id;
        this.tableNumber = tableNumber;
        this.totalPrice = totalPrice;
        this.waitressId = waitressId;
        this.date = date;
        this.dish = dish;
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

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }
}
