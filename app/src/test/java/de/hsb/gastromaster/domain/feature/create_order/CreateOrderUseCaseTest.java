package de.hsb.gastromaster.domain.feature.create_order;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.hsb.gastromaster.data.factories.DishFactory;
import de.hsb.gastromaster.data.factories.OrderFactory;
import de.hsb.gastromaster.data.factories.RequestFactory;
import de.hsb.gastromaster.data.factories.ResponseFactory;
import de.hsb.gastromaster.data.order.IOrderDataRepository;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import io.reactivex.Single;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CreateOrderUseCaseTest {

    @Mock
    private IOrderDataRepository orderDataRepository;

    @InjectMocks
    private CreateOrderUseCase createOrderUseCase;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIfCorrectReturnType() throws Exception {

        Request<Order> request = RequestFactory
                .requestOrder(OrderFactory.order(DishFactory.dishList()));

        Response<Void> response = ResponseFactory.responseVoid();

        when(orderDataRepository.addOrder(any(Request.class)))
                .thenReturn(Single.create(e -> {
                    e.onSuccess(response);
                }));

        createOrderUseCase
                .execute(request)
                .test()
                .assertValue(response)
                .assertComplete();

        verify(orderDataRepository).addOrder(request);

    }
}
