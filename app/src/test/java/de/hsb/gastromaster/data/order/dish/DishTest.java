package de.hsb.gastromaster.data.order.dish;


import org.junit.Before;
import org.junit.Test;

import de.hsb.gastromaster.data.order.dish.Dish;

import static org.junit.Assert.assertEquals;

public class DishTest {

    private Dish dish;
    private static final double DELTA = 1e-15;

    @Before
    public void setup() {
        dish = new Dish(1, 1,"Spaghetti", 6.70);
    }

    @Test
    public void testHasId(){
        assertEquals(1, dish.getId());
    }

    @Test
    public void testIfIdGotNewValue(){
        dish.setId(2);
        assertEquals(2, dish.getId());
    }

    @Test
    public void testHasOrderId(){
        assertEquals(1, dish.getOrderId());
    }

    @Test
    public void testIfOrderIdGotNewValue(){
        dish.setOrderId(2);
        assertEquals(2, dish.getOrderId());
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
