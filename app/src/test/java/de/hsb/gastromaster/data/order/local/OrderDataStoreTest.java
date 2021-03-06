/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.data.order.local;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import de.hsb.gastromaster.data.factories.DishFactory;
import de.hsb.gastromaster.data.factories.OrderFactory;
import de.hsb.gastromaster.data.factories.RequestFactory;
import de.hsb.gastromaster.data.factories.ResponseFactory;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.Dish;
import de.hsb.gastromaster.data.response.Response;
import io.reactivex.observers.TestObserver;

/**
 * The type Order data store test.
 */
public class OrderDataStoreTest {

    private OrderDataStore orderDataStore;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        orderDataStore = new OrderDataStore();
    }

    /**
     * Test store is empty after initialization.
     */
    @Test
    public void testStoreIsEmptyAfterInitialization() {

        TestObserver<Response<Integer>> response = orderDataStore
                .getNumberOfDishes()
                .test();

        Response<Integer> expected = ResponseFactory.responseInteger(0);

        response.assertValue(expected)
                .assertNoErrors()
                .assertComplete();


    }

    /**
     * Test contains ten dishes after inserted ten dishes.
     */
    @Test
    public void testContainsTenDishesAfterInsertedTenDishes() {

        createTenDishesAndAddToStore();

        TestObserver<Response<Integer>> response = orderDataStore
                .getNumberOfDishes()
                .test();

        response.assertValue(ResponseFactory.responseInteger(10))
                .assertNoErrors()
                .assertComplete();
    }

    /**
     * Test is type of object in dish list of type dish.
     */
    @Test
    public void testIsTypeOfObjectInDishListOfTypeDish() {

        orderDataStore
                .addDish(RequestFactory.requestDish(DishFactory.dish()))
                .test();

        TestObserver<Response<Dish>> response = orderDataStore
                .getDishByIndex(RequestFactory.requestInteger(0))
                .test();

        response.assertValue(ResponseFactory.responseDish(DishFactory.dish()))
                .assertNoErrors()
                .assertComplete();
    }


    /**
     * Test get dish by index with invalid index should return a response with error.
     */
    @Test
    public void testGetDishByIndexWithInvalidIndexShouldReturnAResponseWithError() {

        orderDataStore
                .addDish(RequestFactory.requestDish(DishFactory.dish()))
                .test();

        TestObserver<Response<Dish>> response = orderDataStore
                .getDishByIndex(RequestFactory.requestInteger(10))
                .test();

        response.assertValue(ResponseFactory
                .responseDishError(null, "Dish not found"))
                .assertNoErrors()
                .assertComplete();
    }

    /**
     * Test if returns ten dishes.
     */
    @Test
    public void testIfReturnsTenDishes() {

        createTenDishesAndAddToStore();

        TestObserver<Response<List<Dish>>> response = orderDataStore
                .getAllDishes()
                .test();

        response.assertValue(listResponse -> listResponse.getEntity().size() == 10)
                .assertNoErrors()
                .assertComplete();
    }

    /**
     * Test if order list contains one object after inserted one order.
     */
    @Test
    public void testIfOrderListContainsOneObjectAfterInsertedOneOrder() {

        orderDataStore
                .addOrder(RequestFactory.requestOrder(
                        OrderFactory.order(
                                DishFactory.dishList())))
                .test();

        TestObserver<Response<List<Order>>> response = orderDataStore
                .getAllOrder()
                .test();

        response.assertValue(listResponse -> !listResponse.getEntity().isEmpty())
                .assertNoErrors()
                .assertComplete();
    }

    /**
     * Test if returns ten orders.
     */
    @Test
    public void testIfReturnsTenOrders() {

        createTenOrdersAndAddToStore();

        TestObserver<Response<List<Order>>> response = orderDataStore
                .getAllOrder()
                .test();

        response.assertValue(listResponse -> listResponse.getEntity().size() == 10)
                .assertNoErrors()
                .assertComplete();
    }

    /**
     * Test is type of object in order list of type order.
     */
    @Test
    public void testIsTypeOfObjectInOrderListOfTypeOrder() {

        orderDataStore
                .addOrder(RequestFactory.requestOrder(
                        OrderFactory.order(
                                DishFactory.dishList())))
                .test();

        TestObserver<Response<Order>> response = orderDataStore
                .getOrderById(RequestFactory.requestInteger(1))
                .test();

        response.assertValue(orderResonse -> orderResonse.getEntity() instanceof Order)
                .assertNoErrors()
                .assertComplete();
    }

    /**
     * Test get order by id with invalid id should return a response with error.
     */
    @Test
    public void testGetOrderByIdWithInvalidIdShouldReturnAResponseWithError() {

        orderDataStore
                .addOrder(RequestFactory.requestOrder(
                        OrderFactory.order(
                                DishFactory.dishList())))
                .test();

        TestObserver<Response<Order>> response = orderDataStore
                .getOrderById(RequestFactory.requestInteger(10))
                .test();

        response.assertValue(ResponseFactory.responseOrderError(null, "Order not found"))
                .assertComplete()
                .assertNoErrors();
    }

    private void createTenDishesAndAddToStore() {

        for (int i = 0; i < 10; i++) {

            orderDataStore.addDish(RequestFactory.requestDish(DishFactory.dish()))
                    .test();
        }
    }

    private void createTenOrdersAndAddToStore() {

        for (int i = 0; i < 10; i++) {

            orderDataStore.addOrder(RequestFactory
                    .requestOrder(OrderFactory
                            .order(DishFactory.dishList())))
                    .test();
        }
    }
}
