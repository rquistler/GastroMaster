package de.hsb.gastromaster.data.stubs;

import de.hsb.gastromaster.data.IDish;

/**
 * Created by cschaf on 02-May-17.
 */

public class DishStub implements IDish {
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
}
