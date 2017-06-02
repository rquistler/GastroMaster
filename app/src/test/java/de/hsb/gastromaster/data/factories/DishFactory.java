package de.hsb.gastromaster.data.factories;


import java.util.ArrayList;
import java.util.List;

import de.hsb.gastromaster.data.order.dish.Dish;

public final class DishFactory {

    private static final String DISH = "Dish";

    private DishFactory() {
    }

    public static Dish dish() {
        return Dish.builder()
                .setId(1)
                .setOrderId(1)
                .setName("Spaghetti")
                .setPrice(6.70)
                .build();
    }

    public static List<Dish> dishList() {

        List<Dish> dishList = new ArrayList<>();

        dishList.add(dish());
        dishList.add(dish());

        return dishList;
    }

    public static List<Dish> dishListRandom(int size) {

        List<Dish> dishList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            dishList.add(Dish.builder()
                    .setId(i)
                    .setOrderId(i)
                    .setName(DISH + " " + i)
                    .setPrice((double) i)
                    .build());
        }

        dishList.add(dish());
        dishList.add(dish());

        return dishList;
    }
}
