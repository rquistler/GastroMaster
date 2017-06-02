package de.hsb.gastromaster.data.order.dish;


import org.junit.Before;
import org.junit.Test;

import de.hsb.gastromaster.data.factories.DishFactory;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;

public class DishTest {

    private Dish dish;
    private static final double DELTA = 1e-15;

    @Before
    public void setup() {

        dish = DishFactory.dish();
    }

    @Test
    public void testHasId() {
        assertEquals(1, dish.getId());
    }

    @Test
    public void testIfIdGotNewValue() {

        assertThat(dish.withId(2).getId())
                .isEqualTo(2);
    }

    @Test
    public void testHasOrderId() {
        assertEquals(1, dish.getOrderId());
    }

    @Test
    public void testIfOrderIdGotNewValue() {

        assertThat(dish.withOrderId(2).getOrderId())
                .isEqualTo(2);
    }

    @Test
    public void testHasName() {

        assertEquals(dish.getName(), "Spaghetti");
    }


    @Test
    public void testIfNameGotNewValue() {

        assertThat(dish.withName("Lasagne").getName())
                .isEqualTo("Lasagne");
    }

    @Test
    public void testHasPrice() {

        assertEquals(dish.getPrice(), 6.70, DELTA);
    }


    @Test
    public void testIfPriceGotNewValue() {

        assertThat(dish.withPrice(11.90).getPrice())
                .isEqualTo(11.90);
    }
}
