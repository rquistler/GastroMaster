package de.hsb.gastromaster.data.order;

import java.util.List;

import de.hsb.gastromaster.data.order.dish.IDish;

/**
 * Created by cschaf on 09-May-17.
 */

public interface IOrder {
    int getId();

    String getTableNumber();

    void setTableNumber(String tableNumber);

    double getTotalPrice();

    void setTotalPrice(double newValue);

    int getWaitressId();

    void setWaitressId(int waitressId);

    String getDate();

    void setDate(String date);

    void setId(int id);

    List<IDish> getDishList();
}
