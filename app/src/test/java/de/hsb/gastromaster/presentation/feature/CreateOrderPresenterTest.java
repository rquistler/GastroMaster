/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.presentation.feature;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.VerificationModeFactory;

import de.hsb.gastromaster.data.factories.DishFactory;
import de.hsb.gastromaster.data.factories.OrderFactory;
import de.hsb.gastromaster.data.factories.ResponseFactory;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.domain.feature.create_order.CreateOrderUseCase;
import de.hsb.gastromaster.presentation.features.create_order.CreateOrderContract;
import de.hsb.gastromaster.presentation.features.create_order.CreateOrderPresenter;
import io.reactivex.Single;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * The type Create order presenter test.
 */
public class CreateOrderPresenterTest {

    @InjectMocks
    private CreateOrderPresenter createOrderPresenter;

    @Mock
    private CreateOrderUseCase createOrderUseCase;

    /**
     * The View.
     */
    @Mock
    CreateOrderContract.View view;

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test.
     */
    @Test
    public void testFillOutFieldsForCreateOrder() {
        // Mocking the execute of the createOrderUseCase
        when(createOrderUseCase.execute(any(Request.class)))
                .thenReturn(Single.just(ResponseFactory.responseVoid()));
        // Action phase
        createOrderPresenter.createOrder(OrderFactory.order(
                DishFactory.dishList()));

        createOrderPresenter.createOrderExecute(OrderFactory.order(
                DishFactory.dishList()))
                .test()
                .assertValue(voidResponse -> voidResponse.getIsSuccessful());
        // Verify
        verify(createOrderUseCase, VerificationModeFactory.atLeastOnce()).execute(any());
        verify(view).showMessage("Successful: true");
    }
}
