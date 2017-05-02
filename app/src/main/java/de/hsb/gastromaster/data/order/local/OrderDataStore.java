package de.hsb.gastromaster.data.order.local;


import java.util.ArrayList;
import java.util.List;

import de.hsb.gastromaster.data.order.dish.IDish;

public class OrderDataStore {

    private ArrayList<IDish> dishlist;

    public OrderDataStore() {
        dishlist = new ArrayList<IDish>();
    }

    public int getNumberOfDishes() {
        return dishlist.size();
    }

    public void addDish(IDish dish) {
        dishlist.add(dish);
    }

    public IDish getDishByIndex(int index) {
        return dishlist.get(index);
    }

    public List<IDish> getAllDishes() {
        return dishlist;
    }
}
