package de.hsb.gastromaster.data.order.local;


import java.util.ArrayList;
import java.util.List;

import de.hsb.gastromaster.data.order.IOrder;
import de.hsb.gastromaster.data.order.dish.IDish;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import io.reactivex.Single;

public class OrderDataStore implements IOrderDataStore {

    private List<IDish> dishList = new ArrayList<>();
    private List<IOrder> orderList = new ArrayList<>();

    public OrderDataStore() {
    }

    @Override
    public Single<Response<Integer>> getNumberOfDishes() {

        return Single.<Response<Integer>>create(singleEmitter -> {
            singleEmitter.onSuccess(new Response<Integer>(dishList.size(), true));
        });

    }

    @Override
    public Single<Response<Void>> addDish(Request<IDish> request) {

        return Single.<Response<Void>>create(singleEmitter -> {
            dishList.add(request.getEntity());

            singleEmitter.onSuccess(new Response<Void>(null, true));
        });
    }

    @Override
    public Single<Response<IDish>> getDishByIndex(Request<Integer> request) {

        return Single.create(singleEmitter -> {
            if (request.getEntity() >= 0
                    &&
                    request.getEntity() <= dishList.size()) {

                singleEmitter.onSuccess(new Response<IDish>(dishList.get(request.getEntity()), false));
            }
            singleEmitter.onSuccess(new Response<IDish>(null, false, "Dish not found"));
        });
    }

    @Override
    public Single<Response<List<IDish>>> getAllDishes() {

        return Single.create(singleEmitter -> {

            singleEmitter.onSuccess(new Response<List<IDish>>(dishList, true));

        });
    }

    @Override
    public Single<Response<Void>> addOrder(Request<IOrder> request) {

        return Single.create(singleEmitter -> {

            orderList.add(request.getEntity());

            singleEmitter.onSuccess(new Response<Void>(null, true));
        });
    }

    @Override
    public Single<Response<IOrder>> getOrderById(Request<Integer> request) {

        return Single.create(singleEmitter -> {

            for (IOrder order : orderList) {
                if (order.getId() == request.getEntity()) {
                    singleEmitter.onSuccess(new Response<IOrder>(order, true));
                }
            }

            singleEmitter.onSuccess(new Response<IOrder>(null, false, "Order not found"));

        });
    }

    @Override
    public Single<Response<List<IOrder>>> getAllOrder() {

        return Single.create(singleEmitter -> {
            singleEmitter.onSuccess(new Response<List<IOrder>>(orderList, true));
        });
    }


}
