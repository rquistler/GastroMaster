package de.hsb.gastromaster.data.order.local;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import de.hsb.gastromaster.data.order.IOrder;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.IDish;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.data.stubs.DishStub;
import de.hsb.gastromaster.data.stubs.OrderStub;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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

    private void createTenOrdersAndAddToStore() {
        for (int i = 0; i<10;i++){
            orderDataStore.addOrder(new Request<>(new OrderStub()));
        }
    }

    @Test
    public void testIsTypeOfObjectInDishListOfTypeIDish(){
        orderDataStore.addDish(new Request<>(new DishStub()));
        Response<IDish> response = orderDataStore.getDishByIndex(new Request<>(0));
        assertThat(response.getEntity(), instanceOf(IDish.class));
    }

    @Test
    public void testGetDishByIndexWithInvalidIndexShouldReturnAResponseWithError(){
        orderDataStore.addDish(new Request<>(new DishStub()));
        Response<IDish> response = orderDataStore.getDishByIndex(new Request<>(-1));
        assertNull(response.getEntity());
        assertEquals(response.isSuccessful(), false);
        assertEquals(response.getErrorMessage(), "Dish not found");
    }

    @Test
    public void testIfReturnsTenDishes(){
        createTenDishesAndAddToStore();
        assertEquals(10, orderDataStore.getAllDishes().getEntity().size());
    }

    @Test
    public void testIfOrderListContainsOneObjectAfterInsertedOneOrder(){
        orderDataStore.addOrder(new Request<>(new OrderStub()));
        assertEquals(orderDataStore.getAllOrder().getEntity().size(), 1);
    }

    @Test
    public void testIfReturnsTenOrders(){
        createTenOrdersAndAddToStore();
        assertEquals(10, orderDataStore.getAllOrder().getEntity().size());
    }

    @Test
    public void testIsTypeOfObjectInOrderListOfTypeIOrder(){
        orderDataStore.addOrder(new Request<>(new OrderStub()));
        Response<IOrder> response = orderDataStore.getOrderById(new Request<>(1));
        assertThat(response.getEntity(), instanceOf(IOrder.class));
    }

    @Test
    public void testGetOrderByIdWithInvalidIdShouldReturnAResponseWithError(){
        orderDataStore.addOrder(new Request<>(new OrderStub()));
        Response<IOrder> response = orderDataStore.getOrderById(new Request<>(-1));
        assertNull(response.getEntity());
        assertEquals(response.isSuccessful(), false);
        assertEquals(response.getErrorMessage(), "Order not found");
    }
}
