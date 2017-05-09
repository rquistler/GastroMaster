package de.hsb.gastromaster.data.order;

import java.util.List;

import de.hsb.gastromaster.data.order.local.IOrderDataStore;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;

public class OrderDataRepository implements IOrderDataRepository {

    private IOrderDataStore orderDataStore;

    public OrderDataRepository(IOrderDataStore orderDataStore) {
        this.orderDataStore = orderDataStore;
    }

    @Override
    public Response<Void> addOrder(Request<IOrder> request){
        return orderDataStore.addOrder(request);
    }

    @Override
    public Response<List<IOrder>> getAllOrders(){
       return orderDataStore.getAllOrder();
    }
}
