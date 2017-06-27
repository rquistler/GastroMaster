/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.presentation.features.create_order;


import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import de.hsb.gastromaster.R;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.factories.OrderFactory;
import de.hsb.gastromaster.presentation.FragmentTestRule;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(AndroidJUnit4.class)
public class CreateOrderFragmentTest {

    @Rule
    public FragmentTestRule<CreateOrderFragment> fragmentTestRule =
            new FragmentTestRule<>(CreateOrderFragment.class);

    @Mock
    private CreateOrderContract.Presenter presenter;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        fragmentTestRule.getFragment().initPresenter(presenter);
    }


    @Test
    public void testCreateOrderAfterButtonClick() throws InterruptedException {

        Order order = OrderFactory.order(new ArrayList<>());

        onView(withId(R.id.txtTableNumber)).perform(typeText(order.getTableNumber()));
        onView(withId(R.id.txtWaitressNumber)).perform(typeText(String.valueOf(order.getWaitressId())));
        onView(withId(R.id.txtDish)).perform(typeText("Lasagne"));

        closeSoftKeyboard();

        Thread.sleep(1000);

        onView(withId(R.id.btnCreate)).perform(click());

        verify(presenter).createOrder(any(Order.class));
    }
}
