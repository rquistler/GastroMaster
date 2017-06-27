/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.data.order;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import de.hsb.gastromaster.data.factories.DishFactory;
import de.hsb.gastromaster.data.factories.OrderFactory;
import de.hsb.gastromaster.data.factories.RequestFactory;
import de.hsb.gastromaster.data.factories.ResponseFactory;
import de.hsb.gastromaster.data.order.local.IOrderDataStore;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import io.reactivex.Single;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderDataRepositoryTest {


    @Mock
    private IOrderDataStore orderDataStore;

    @InjectMocks
    private OrderDataRepository orderDataRepository;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testIfOrderWasSuccessful() {

        when(orderDataStore
                .addOrder(any(Request.class)))
                .thenReturn(Single.create(e -> {
                    e.onSuccess(ResponseFactory.responseVoid());
                }));

        orderDataRepository
                .addOrder(RequestFactory.requestOrder(
                        OrderFactory.order(DishFactory.dishList())))
                .test()
                .assertNoErrors()
                .assertValue(Response::getIsSuccessful)
                .assertValue(voidResponse -> voidResponse.getEntity() == null)
                .assertValue(voidResponse -> voidResponse.getErrorMessage().isEmpty())
                .assertComplete();

    }

    @Test
    public void test_ifGetAllOrdersNotZeroAfterOrderAdded() {

        List<Order> orderList = mock(ArrayList.class);

        when(orderList.size()).thenReturn(1);

        when(orderDataStore
                .getAllOrder())
                .thenReturn(Single.create(e -> {

                    e.onSuccess(ResponseFactory.responseOrderList(
                            OrderFactory.orderList(
                                    DishFactory.dishList())));
                }));

        orderDataRepository
                .getAllOrders(RequestFactory.requestVoid())
                .test()
                .assertNoErrors()
                .assertValue(listResponse -> listResponse.getEntity().size() > 0)
                .assertComplete();
    }
}
