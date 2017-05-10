package de.hsb.gastromaster.data.order.local;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.IDish;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.data.stubs.DishStub;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class OrderDataStoreTest {

    private IOrderDataStore orderDataStore;

    @Before
    public void setUp(){
        orderDataStore = new OrderDataStore(new ArrayList<>(), new ArrayList<>());
    }

    @Test
    public void testStoreIsEmptyAfterInitialization(){
        Response<Integer> response = orderDataStore.getNumberOfDishes();
        int numberOfDishes= response.getEntity();
        assertEquals(numberOfDishes, 0);
    }

    @Test
    public void testContainsTenDishesAfterInsertedTenDishes(){
        createTenDishesAndAddToStore();
        Response<Integer> response = orderDataStore.getNumberOfDishes();
        int numberOfDishes= response.getEntity();

        assertEquals(numberOfDishes, 10);
    }

    private void createTenDishesAndAddToStore() {
        for (int i = 0; i<10;i++){
            orderDataStore.addDish(new Request<>(new DishStub()));
        }
    }

    @Test
    public void testIsTypeOfObjectInDishListOfTypeIDish(){
        orderDataStore.addDish(new Request<>(new DishStub()));
        Response<IDish> response = orderDataStore.getDishByIndex(new Request<>(0));
        assertThat(response.getEntity(), instanceOf(IDish.class));
    }

    @Test
    public void testIfReturnsTenDishes(){
        createTenDishesAndAddToStore();
        assertEquals(10, orderDataStore.getAllDishes().getEntity().size());
    }
}
