/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.data.factories;


import java.util.ArrayList;
import java.util.List;

import de.hsb.gastromaster.data.order.dish.Dish;

/**
 * The type Dish factory.
 */
public final class DishFactory {

    private static final String DISH = "Dish";

    private DishFactory() {
    }

    /**
     * Dish dish.
     *
     * @return the dish
     */
    public static Dish dish() {
        return Dish.builder()
                .setId(1)
                .setOrderId(1)
                .setName("Spaghetti")
                .setPrice(6.70)
                .build();
    }

    /**
     * Dish list list.
     *
     * @return the list
     */
    public static List<Dish> dishList() {

        List<Dish> dishList = new ArrayList<>();

        dishList.add(dish());
        dishList.add(dish());

        return dishList;
    }

    /**
     * Dish list random list.
     *
     * @param size the size
     * @return the list
     */
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

        return dishList;
    }
}
