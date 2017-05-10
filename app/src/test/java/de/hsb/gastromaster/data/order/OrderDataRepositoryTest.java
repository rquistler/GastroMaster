package de.hsb.gastromaster.data.order;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import de.hsb.gastromaster.data.order.local.OrderDataStore;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.data.stubs.OrderDataStoreStub;
import de.hsb.gastromaster.data.stubs.OrderStub;

import static junit.framework.Assert.assertEquals;

public class OrderDataRepositoryTest {
    private IOrderDataRepository orderDataRepository;

    @Before
    public void setup(){
        orderDataRepository = new OrderDataRepository(new OrderDataStoreStub());
    }

    @Test
    public void testIfOrderWasAddedAfterAddedNewOrder() {
        Response<Void> response = orderDataRepository.addOrder(new Request<>(new OrderStub()));
        assertEquals(response.isSuccessful(), true);

    }

    @Test
    public void testIfNumberOfOdersIsZeroAfterInit() {
        Response<List<IOrder>> response =  orderDataRepository.getAllOrders();
        assertEquals(response.getEntity().size(), 0);
    }
}
