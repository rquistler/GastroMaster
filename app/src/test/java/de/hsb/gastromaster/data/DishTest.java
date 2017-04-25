package de.hsb.gastromaster.data;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DishTest {

    private Dish dish;
    private static final double DELTA = 1e-15;

    @Before
    public void setup() {
        dish = new Dish("Spaghetti", 6.70);
    }

    @Test
    public void testHasName() {

        assertEquals(dish.getName(), "Spaghetti");
    }


    @Test
    public void testIfNameGotNewValue() {
        dish.setName("Lasagne");

        assertEquals(dish.getName(), "Lasagne");
    }

    @Test
    public void testHasPrice() {

        assertEquals(dish.getPrice(), 6.70, DELTA);
    }


    @Test
    public void testIfPriceGotNewValue() {
        dish.setPrice(11.90);

        assertEquals(dish.getPrice(), 11.90, DELTA);
    }

}
