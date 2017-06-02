package de.hsb.gastromaster.data.order.local;


import java.util.ArrayList;
import java.util.List;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.Dish;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import io.reactivex.Single;

public class OrderDataStore implements IOrderDataStore {

    private List<Dish> dishList = new ArrayList<>();
    private List<Order> orderList = new ArrayList<>();

    public OrderDataStore() {
    }

    @Override
    public Single<Response<Integer>> getNumberOfDishes() {

        return Single.create(singleEmitter -> {

            singleEmitter.onSuccess(Response.<Integer>builder()
                    .setEntity(dishList.size())
                    .setIsSuccessful(true)
                    .build());
        });

    }

    @Override
    public Single<Response<Void>> addDish(Request<Dish> request) {

        return Single.create(singleEmitter -> {

            dishList.add(request.getEntity());

            singleEmitter.onSuccess(
                    Response.<Void>builder()
                            .setEntity(null)
                            .setIsSuccessful(true)
                            .build());
        });
    }

    @Override
    public Single<Response<Dish>> getDishByIndex(Request<Integer> request) {

        return Single.create(singleEmitter -> {

            Response.Builder<Dish> builder = Response.builder();

            if (request.getEntity() >= 0 &&
                    request.getEntity() <= dishList.size()) {

                singleEmitter.onSuccess(
                        builder.setEntity(dishList.get(request.getEntity()))
                                .setIsSuccessful(true)
                                .build());
            }

            singleEmitter.onSuccess(
                    builder.setEntity(dishList.get(request.getEntity()))
                            .setIsSuccessful(true)
                            .setErrorMessage("Dish not found")
                            .build());
        });
    }

    @Override
    public Single<Response<List<Dish>>> getAllDishes() {

        return Single.create(singleEmitter -> {

            singleEmitter.onSuccess(
                    Response.<List<Dish>>builder()
                            .setEntity(new ArrayList<>(dishList))
                            .setIsSuccessful(true)
                            .build());


        });
    }

    @Override
    public Single<Response<Void>> addOrder(Request<Order> request) {

        return Single.create(singleEmitter -> {

            orderList.add(request.getEntity());

            singleEmitter.onSuccess(
                    Response.<Void>builder()
                            .setEntity(null)
                            .setIsSuccessful(true)
                            .build());
        });
    }

    @Override
    public Single<Response<Order>> getOrderById(Request<Integer> request) {

        return Single.create(singleEmitter -> {

            Response.Builder<Order> builder = Response.builder();

            for (Order order : orderList) {
                if (order.getId() == request.getEntity()) {

                    singleEmitter.onSuccess(builder
                            .setEntity(order)
                            .setIsSuccessful(true)
                            .build());
                }
            }

            singleEmitter.onSuccess(builder
                    .setEntity(null)
                    .setIsSuccessful(true)
                    .setErrorMessage("Order not found")
                    .build());

        });
    }

    @Override
    public Single<Response<List<Order>>> getAllOrder() {

        return Single.create(singleEmitter -> {

            singleEmitter.onSuccess(
                    Response.<List<Order>>builder()
                            .setEntity(orderList)
                            .setIsSuccessful(true)
                            .build());
        });
    }


}
