package de.hsb.gastromaster.presentation.feature;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.verification.VerificationMode;

import de.hsb.gastromaster.data.factories.DishFactory;
import de.hsb.gastromaster.data.factories.OrderFactory;
import de.hsb.gastromaster.data.factories.RequestFactory;
import de.hsb.gastromaster.data.factories.ResponseFactory;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.domain.feature.create_order.CreateOrderUseCase;
import de.hsb.gastromaster.presentation.features.create_order.CreateOrderContract;
import de.hsb.gastromaster.presentation.features.create_order.CreateOrderPresenter;
import io.reactivex.Single;

public class CreateOrderPresenterTest {

    @InjectMocks
    private CreateOrderPresenter createOrderPresenter;

    @Mock
    private CreateOrderUseCase createOrderUseCase;

    @Mock
    CreateOrderContract.View view;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() {

        when(createOrderUseCase.execute(any(Request.class)))
                .thenReturn(Single.just(ResponseFactory.responseVoid()));

        createOrderPresenter.createOrder(OrderFactory.order(
                DishFactory.dishList()));

        createOrderPresenter.createOrderExecute(OrderFactory.order(
                DishFactory.dishList()))
                .test()
                .assertValue(voidResponse -> voidResponse.getIsSuccessful());

        verify(createOrderUseCase, VerificationModeFactory.atLeastOnce()).execute(any());

        verify(view).showMessage("Successful: true");
    }
}
