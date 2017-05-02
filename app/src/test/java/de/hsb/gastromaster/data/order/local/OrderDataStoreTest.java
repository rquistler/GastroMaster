package de.hsb.gastromaster.data.order.local;


import org.junit.Before;
import org.junit.Test;

import de.hsb.gastromaster.data.order.dish.IDish;
import de.hsb.gastromaster.data.stubs.DishStub;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class OrderDataStoreTest {

    private OrderDataStore dishDataStore;

    @Before
    public void setUp(){
        dishDataStore = new OrderDataStore();
    }

    @Test
    public void testStoreIsEmptyAfterInitialization(){
        assertEquals(0, dishDataStore.getNumberOfDishes());
    }

    @Test
    public void testContainsTenDishesAfterInsertedTenDishes(){
        createTenDishesAndAddToStore();
        assertEquals(10, dishDataStore.getNumberOfDishes());
    }

    private void createTenDishesAndAddToStore() {
        for (int i = 0; i<10;i++){
            dishDataStore.addDish(new DishStub());
        }
    }

    @Test
    public void testIsTypeOfObjectInDishListOfTypeIDish(){
        dishDataStore.addDish(new DishStub());
        assertThat(dishDataStore.getDishByIndex(0), instanceOf(IDish.class));
    }

    @Test
    public void testIfReturnsTenDishes(){
        createTenDishesAndAddToStore();
        assertEquals(10,dishDataStore.getAllDishes().size());
    }
}
