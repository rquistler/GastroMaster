/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.data.order;

import java.util.List;

import de.hsb.gastromaster.data.order.dish.Dish;
import de.hsb.gastromaster.data.order.local.IOrderDataStore;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import io.reactivex.Single;

/**
 * The Order repository.
 */
public class OrderDataRepository implements IOrderDataRepository {

    private IOrderDataStore orderDataStore;

    /**
     * Instantiates a new Order data repository.
     *
     * @param orderDataStore the order data store
     */
    public OrderDataRepository(IOrderDataStore orderDataStore) {
        this.orderDataStore = orderDataStore;
    }

    @Override
    public Single<Response<Void>> addOrder(Request<Order> requestOld) {
        return orderDataStore.addOrder(requestOld);
    }

    @Override
    public Single<Response<List<Order>>> getAllOrders(Request<Void> requestOld) {
        return orderDataStore.getAllOrder();
    }

    @Override
    public Single<Response<Order>> getOrderById(Request<Integer> request) {
        return orderDataStore.getOrderById(request);
    }

    @Override
    public Single<Response<List<Dish>>> getAllDishes(Request<Void> request) {
        return orderDataStore.getAllDishes();
    }

    @Override
    public Single<Response<Void>> updateOrder(Request<Order> order) {
        return orderDataStore.updateOrder(order);
    }

    @Override
    public Single<Response<Void>> removeOrder(Request<Order> order) {
        return orderDataStore.removeOrder(order);
    }
}
