/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.data.order.dish;


import org.junit.Before;
import org.junit.Test;

import de.hsb.gastromaster.data.factories.DishFactory;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * The type Dish test.
 */
public class DishTest {

    private Dish dish;
    private static final double DELTA = 1e-15;

    /**
     * Sets .
     */
    @Before
    public void setup() {

        dish = DishFactory.dish();
    }

    /**
     * Test has id.
     */
    @Test
    public void testHasId() {
        assertEquals(1, dish.getId());
    }

    /**
     * Test if id got new value.
     */
    @Test
    public void testIfIdGotNewValue() {

        assertThat(dish.withId(2).getId())
                .isEqualTo(2);
    }

    /**
     * Test has order id.
     */
    @Test
    public void testHasOrderId() {
        assertEquals(1, dish.getOrderId());
    }

    /**
     * Test if order id got new value.
     */
    @Test
    public void testIfOrderIdGotNewValue() {

        assertThat(dish.withOrderId(2).getOrderId())
                .isEqualTo(2);
    }

    /**
     * Test has name.
     */
    @Test
    public void testHasName() {

        assertEquals(dish.getName(), "Spaghetti");
    }


    /**
     * Test if name got new value.
     */
    @Test
    public void testIfNameGotNewValue() {

        assertThat(dish.withName("Lasagne").getName())
                .isEqualTo("Lasagne");
    }

    /**
     * Test has price.
     */
    @Test
    public void testHasPrice() {

        assertEquals(dish.getPrice(), 6.70, DELTA);
    }


    /**
     * Test if price got new value.
     */
    @Test
    public void testIfPriceGotNewValue() {

        assertThat(dish.withPrice(11.90).getPrice())
                .isEqualTo(11.90);
    }
}
