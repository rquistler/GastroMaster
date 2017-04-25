package de.hsb.gastromaster.data;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DishTest {

    @Test
    public void testHasName(){
        Dish dish = new Dish("Spaghetti");

        assertEquals(dish.getName(),"Spaghetti");

    }

}
