package de.hsb.gastromaster.data.stubs;

import org.junit.Before;
import org.junit.Test;

import de.hsb.gastromaster.data.IDish;

import static org.junit.Assert.assertEquals;

/**
 * Created by cschaf on 02-May-17.
 */

public class DishStubTest {
    private IDish dish;
    private static final double DELTA = 1e-15;

    @Before
    public void setup() {
        dish = new DishStub();
    }

    @Test
    public void testHasName() {

        assertEquals(dish.getName(), "Salami Pizza");
    }


    @Test
    public void testIfNameGotNewValue() {
        dish.setName("Salami Pizza");

        assertEquals(dish.getName(), "Salami Pizza");
    }

    @Test
    public void testHasPrice() {

        assertEquals(dish.getPrice(), 7.5, DELTA);
    }


    @Test
    public void testIfPriceGotNewValue() {
        dish.setPrice(7.5);

        assertEquals(dish.getPrice(), 7.5, DELTA);
    }

}
