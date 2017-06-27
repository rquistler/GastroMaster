package de.hsb.gastromaster.data.order.local;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.Dish;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import io.reactivex.Single;

public class OrderDataStore implements IOrderDataStore {
    public static int LastID = 1;
    private List<Dish> dishList = new ArrayList<>();
    private List<Order> orderList = new ArrayList<>();

    public void init() {
        dishList.add(Dish.builder().setId(1).setOrderId(0).setName("Spaghetti").setPrice(6.70).build());
        dishList.add(Dish.builder().setId(2).setOrderId(0).setName("Coca Cola").setPrice(3.50).build());
        dishList.add(Dish.builder().setId(3).setOrderId(0).setName("Salami Pizza").setPrice(11.30).build());
        dishList.add(Dish.builder().setId(4).setOrderId(0).setName("Toast Hawaii").setPrice(5.20).build());
        dishList.add(Dish.builder().setId(5).setOrderId(0).setName("Chef Salat").setPrice(10.00).build());
        dishList.add(Dish.builder().setId(6).setOrderId(0).setName("Sparkled Water").setPrice(2.50).build());

        orderList.add(Order.builder().setId(LastID++).setTableNumber("1A").setWaitressId(1).setDate("11-6-2017:19.00.33").setDishList(Arrays.asList(dishList.get(0), dishList.get(1))).build());
        orderList.add(Order.builder().setId(LastID++).setTableNumber("1A").setWaitressId(1).setDate("11-6-2017:19.05.13").setDishList(Arrays.asList(dishList.get(2), dishList.get(1))).build());

        orderList.add(Order.builder().setId(LastID++).setTableNumber("2A").setWaitressId(1).setDate("11-6-2017:16.00.33").setDishList(Arrays.asList(dishList.get(3), dishList.get(1))).build());
        orderList.add(Order.builder().setId(LastID++).setTableNumber("2A").setWaitressId(1).setDate("11-6-2017:17.15.13").setDishList(Arrays.asList(dishList.get(4), dishList.get(5))).build());
        orderList.add(Order.builder().setId(LastID++).setTableNumber("2A").setWaitressId(1).setDate("11-6-2017:16.00.33").setDishList(Arrays.asList(dishList.get(3), dishList.get(1))).build());
        orderList.add(Order.builder().setId(LastID++).setTableNumber("2A").setWaitressId(1).setDate("11-6-2017:17.15.13").setDishList(Arrays.asList(dishList.get(0), dishList.get(1))).build());

        orderList.add(Order.builder().setId(LastID++).setTableNumber("3A").setWaitressId(2).setDate("11-6-2017:10.00.00").setDishList(Arrays.asList(dishList.get(0), dishList.get(5))).build());

        orderList.add(Order.builder().setId(LastID++).setTableNumber("4A").setWaitressId(2).setDate("11-6-2017:18.04.03").setDishList(Arrays.asList(dishList.get(2), dishList.get(1))).build());
        orderList.add(Order.builder().setId(LastID++).setTableNumber("4A").setWaitressId(2).setDate("11-6-2017:16.25.33").setDishList(Arrays.asList(dishList.get(3), dishList.get(1))).build());
        orderList.add(Order.builder().setId(LastID++).setTableNumber("4A").setWaitressId(2).setDate("11-6-2017:17.05.13").setDishList(Arrays.asList(dishList.get(4), dishList.get(5))).build());
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
                    request.getEntity() < dishList.size()) {

                singleEmitter.onSuccess(
                        builder.setEntity(dishList.get(request.getEntity()))
                                .setIsSuccessful(true)
                                .build());
            }

            singleEmitter.onSuccess(
                    builder.setEntity(null)
                            .setIsSuccessful(false)
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
                    .setIsSuccessful(false)
                    .setErrorMessage("Order not found")
                    .build());

        });
    }

    @Override
    public Single<Response<List<Order>>> getAllOrder() {

        return Single.create(singleEmitter -> {

            singleEmitter.onSuccess(
                    Response.<List<Order>>builder()
                            .setEntity(new ArrayList<>(orderList))
                            .setIsSuccessful(true)
                            .build());
        });
    }

    @Override
    public Single<Response<Void>> updateOrder(Request<Order> request) {
        return Single.create(singleEmitter -> {
            for (int i = 0; i < orderList.size(); i++) {
                if (orderList.get(i).getId() == request.getEntity().getId()) {
                    orderList.set(i, request.getEntity());
                    break;
                }
            }

            singleEmitter.onSuccess(
                    Response.<Void>builder()
                            .setEntity(null)
                            .setIsSuccessful(true)
                            .build());
        });
    }

    @Override
    public Single<Response<Void>> removeOrder(Request<Order> order) {
        return Single.create(singleEmitter -> {
            for (int i = 0; i < orderList.size(); i++) {
                if (order.getEntity().getId() == orderList.get(i).getId()) {
                    orderList.remove(i);
                }
            }
            singleEmitter.onSuccess(
                    Response.<Void>builder()
                            .setEntity(null)
                            .setIsSuccessful(true)
                            .build());
        });
    }
}
