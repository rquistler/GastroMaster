package de.hsb.gastromaster.data.stubs;

import java.util.ArrayList;
import java.util.List;

import de.hsb.gastromaster.data.order.IOrder;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.IDish;
import de.hsb.gastromaster.data.order.local.IOrderDataStore;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;

public class OrderDataStoreStub implements IOrderDataStore {
    @Override
    public Response<Integer> getNumberOfDishes() {
        return new Response<Integer>(0,true);
    }

    @Override
    public Response<Void> addDish(Request<IDish> request) {
        return new Response<Void>(null, true);
    }

    @Override
    public Response<IDish> getDishByIndex(Request<Integer> request) {
        return new Response<IDish>(new DishStub(), true);
    }

    @Override
    public Response<List<IDish>> getAllDishes() {
        ArrayList<IDish> dishList = new  ArrayList<>();
        dishList.add(new DishStub());

        return new Response<List<IDish>>(dishList, true);
    }

    @Override
    public Response<Void> addOrder(Request<IOrder> request) {
        return new Response<Void>(null, true);
    }

    @Override
    public Response<IOrder> getOrderById(Request<Integer> request) {
        return new Response<IOrder>(new OrderStub(), true);
    }

    @Override
    public Response<List<IOrder>> getAllOrder() {
        ArrayList<IOrder> orderList = new ArrayList<>();
        return new Response<List<IOrder>>(orderList, true);
    }
}
