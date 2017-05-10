package de.hsb.gastromaster.data.order.local;


import java.util.List;

import de.hsb.gastromaster.R;
import de.hsb.gastromaster.data.order.IOrder;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.IDish;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;

public class OrderDataStore implements IOrderDataStore {

    private List<IDish> dishList;
    private List<IOrder> orderList;

    public OrderDataStore(List<IOrder> orderList,
                          List<IDish> dishList) {

        this.dishList = dishList;
        this.orderList = orderList;
    }

    @Override
    public Response<Integer> getNumberOfDishes() {
        return new Response<Integer>(dishList.size(), true);

    }

    @Override
    public Response<Void> addDish(Request<IDish> request) {
        dishList.add(request.getEntity());
        return new Response<Void>(null, true);
    }

    @Override
    public Response<IDish> getDishByIndex(Request<Integer> request) {
        if(request.getEntity() >= 0
                &&
                request.getEntity() <= dishList.size()){
            return new Response<IDish>(dishList.get(request.getEntity()), false);
        }
        return new Response<IDish>(null, false, "Dish not found");
    }

    @Override
    public Response<List<IDish>> getAllDishes() {
        return new Response<List<IDish>>(dishList, true);
    }

    @Override
    public Response<Void> addOrder(Request<IOrder> request) {
        orderList.add(request.getEntity());
        return new Response<Void>(null, true);
    }

    @Override
    public Response<IOrder> getOrderById(Request<Integer> request) {
        for (IOrder order : orderList) {
            if (order.getId() == request.getEntity()) {
                return new Response<IOrder>(order, true);
            }
        }
        return new Response<IOrder>(null, false, "Order not found");
    }

    @Override
    public Response<List<IOrder>> getAllOrder() {
        return new Response<List<IOrder>>(orderList, true);
    }


}
