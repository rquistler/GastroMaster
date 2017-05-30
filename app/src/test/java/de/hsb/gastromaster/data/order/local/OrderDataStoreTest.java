package de.hsb.gastromaster.data.order.local;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import de.hsb.gastromaster.data.order.IOrder;
import de.hsb.gastromaster.data.order.dish.IDish;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.data.stubs.DishStub;
import de.hsb.gastromaster.data.stubs.OrderStub;
import io.reactivex.observers.TestObserver;

public class OrderDataStoreTest {

    private IOrderDataStore orderDataStore;

    @Before
    public void setUp() {
        orderDataStore = new OrderDataStore();
    }

    @Test
    public void testStoreIsEmptyAfterInitialization() {

        TestObserver<Response<Integer>> response = orderDataStore
                .getNumberOfDishes()
                .test();

        Response<Integer> expected = new Response<Integer>(0, true, "");

        response.assertValue(expected)
                .assertNoErrors()
                .assertComplete();

    }

    @Test
    public void testContainsTenDishesAfterInsertedTenDishes() {

        createTenDishesAndAddToStore();

        TestObserver<Response<Integer>> response = orderDataStore
                .getNumberOfDishes()
                .test();

        response.assertValue(new Response<Integer>(10, true, ""))
                .assertNoErrors()
                .assertComplete();
    }

    private void createTenDishesAndAddToStore() {
        for (int i = 0; i < 10; i++) {
            orderDataStore.addDish(new Request<>(new DishStub())).test();
        }
    }

    private void createTenOrdersAndAddToStore() {
        for (int i = 0; i < 10; i++) {
            orderDataStore.addOrder(new Request<>(new OrderStub())).test();
        }
    }

    @Test
    public void testIsTypeOfObjectInDishListOfTypeIDish() {

        orderDataStore.addDish(new Request<>(new DishStub())).test();

        TestObserver<Response<IDish>> response = orderDataStore.getDishByIndex(new Request<>(0)).test();

        response.assertValue(new Response<IDish>(new DishStub(), true, ""))
                .assertNoErrors()
                .assertComplete();
    }


    @Test
    public void testGetDishByIndexWithInvalidIndexShouldReturnAResponseWithError() {
        orderDataStore.addDish(new Request<>(new DishStub())).test();
        TestObserver<Response<IDish>> response = orderDataStore.getDishByIndex(new Request<>(-1)).test();

        response.assertValue(new Response<IDish>(null, false, "Dish not found"))
                .assertNoErrors()
                .assertComplete();
    }

    @Test
    public void testIfReturnsTenDishes() {
        createTenDishesAndAddToStore();
        TestObserver<Response<List<IDish>>> response = orderDataStore.getAllDishes().test();
        response.assertValue(listResponse -> listResponse.getEntity().size() == 10)
                .assertNoErrors()
                .assertComplete();
    }

    @Test
    public void testIfOrderListContainsOneObjectAfterInsertedOneOrder() {
        orderDataStore.addOrder(new Request<>(new OrderStub())).test();
        TestObserver<Response<List<IOrder>>> response = orderDataStore.getAllOrder().test();
        response.assertValue(listResponse -> listResponse.getEntity().size() == 1)
                .assertNoErrors()
                .assertComplete();
    }

    @Test
    public void testIfReturnsTenOrders() {
        createTenOrdersAndAddToStore();
        TestObserver<Response<List<IOrder>>> response = orderDataStore.getAllOrder().test();
        response.assertValue(listResponse -> listResponse.getEntity().size() == 10)
                .assertNoErrors()
                .assertComplete();
    }

    @Test
    public void testIsTypeOfObjectInOrderListOfTypeIOrder() {
        orderDataStore.addOrder(new Request<>(new OrderStub())).test();
        TestObserver<Response<IOrder>> response = orderDataStore.getOrderById(new Request<>(1)).test();
        response.assertValue(orderResonse -> orderResonse.getEntity() instanceof IOrder)
                .assertNoErrors()
                .assertComplete();
    }

    @Test
    public void testGetOrderByIdWithInvalidIdShouldReturnAResponseWithError() {
        orderDataStore.addOrder(new Request<>(new OrderStub())).test();
        TestObserver<Response<IOrder>> response = orderDataStore.getOrderById(new Request<>(-1)).test();

        response.assertValue(new Response<IOrder>(null, false, "Order not found"))
        .assertComplete()
        .assertNoErrors();
    }
}
