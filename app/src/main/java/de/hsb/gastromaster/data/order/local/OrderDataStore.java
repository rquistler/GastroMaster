package de.hsb.gastromaster.data.order.local;


import java.util.List;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.IDish;

public class OrderDataStore {

    private List<IDish> dishList;
    private List<Order> orderList;

    public OrderDataStore(List<Order> orderList,
                          List<IDish> dishList) {

        this.dishList = dishList;
        this.orderList = orderList;
    }

    public int getNumberOfDishes() {
        return dishList.size();
    }

    public void addDish(IDish dish) {
        dishList.add(dish);
    }

    public IDish getDishByIndex(int index) {
        return dishList.get(index);
    }

    public List<IDish> getAllDishes() {
        return dishList;
    }
}
