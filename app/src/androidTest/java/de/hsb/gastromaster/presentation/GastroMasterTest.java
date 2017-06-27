/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.presentation;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.hsb.gastromaster.R;
import de.hsb.gastromaster.presentation.features.BaseRecyclerViewAdapter;
import de.hsb.gastromaster.presentation.ui.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static de.hsb.gastromaster.presentation.Assertions.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.Is.is;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class GastroMasterTest {
    private FragmentManager fragmentManager;

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void init() {
        fragmentManager = activityRule.getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction();
    }

    @Test
    public void testIfTableListIsShownAfterAppStarted() {
        onView(withId(R.id.table_list)).check(matches(isDisplayed()));
    }

    @Test
    public void testIfTableListIsNotEmptyAfterAppStarted() throws InterruptedException {
        onView(withId(R.id.table_list)).check(withItemCount(is(4)));
    }

    @Test
    public void testIfOrderListIsShownAfterOnFirstTableClicked() throws InterruptedException {
        openTableAt(0);
        onView(withId(R.id.order_list)).check(matches(isDisplayed()));
    }

    @Test
    public void testIfOrderListIsNotEmptyAfterOnFirstTableClicked() throws InterruptedException {
        openTableAt(0);
        onView(withId(R.id.order_list)).check(withItemCount(is(2)));
    }

    @Test
    public void testIfOrderDetailForFirstOrderOfFirstTableHas2Dishes() throws InterruptedException {
        openTableAt(0);
        openOrderAt(0);
        onView(withId(R.id.order_detail_dish_list)).check(withItemCount(is(2)));
    }

    @Test
    public void testLaunchingDishList() throws InterruptedException {
        performClickOnTable(0);
        performClickOnTable(1);
        performClickOnTable(2);
    }

    @Test
    public void testCreateOrder() throws InterruptedException {
        openTableAt(0);
        onView(withId(R.id.btnAddOrder)).perform(click());
        selectDishAt(0);
        activityRule.getActivity().onBackPressed();
        onView(withId(R.id.order_list)).check(matches(isDisplayed()));
        onView(withId(R.id.order_list)).check(withItemCount(is(3)));

        onView(withId(R.id.order_list)).perform(RecyclerViewActions.actionOnItemAtPosition(2, longClick()));
    }

    @Test
    public void testRemoveOrder() {
        openTableAt(0);
        onView(withId(R.id.order_list)).perform(RecyclerViewActions.actionOnItemAtPosition(0, longClick()));
        onView(withId(R.id.order_list)).check(matches(isDisplayed()));
        onView(withId(R.id.order_list)).check(withItemCount(is(1)));

        onView(withId(R.id.btnAddOrder)).perform(click());
        selectDishAt(0);
    }

    @Test
    public void testAddDishToOrder() {
        openTableAt(0);
        onView(withId(R.id.order_list)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.btnAddDish)).perform(click());
        onView(withId(R.id.dish_list)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.order_detail_dish_list)).check(withItemCount(is(3)));

        onView(withId(R.id.order_detail_dish_list)).perform(RecyclerViewActions.actionOnItemAtPosition(2, longClick()));
    }

    @Test
    public void testRemoveDishfromOrder() {
        openTableAt(0);
        onView(withId(R.id.order_list)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.order_detail_dish_list)).perform(RecyclerViewActions.actionOnItemAtPosition(0, longClick()));
        onView(withId(R.id.order_detail_dish_list)).check(withItemCount(is(1)));

        onView(withId(R.id.btnAddDish)).perform(click());
        onView(withId(R.id.dish_list)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }

    @After
    public void cleanUp() {
    }

    private void performClickOnTable(int position) {
        openTableAt(position);
        onView(withId(R.id.btnAddOrder)).perform(click());
        onView(withId(R.id.dish_list)).check(matches(isDisplayed()));

        activityRule.getActivity().onBackPressed();
        activityRule.getActivity().onBackPressed();
    }

    private void selectDishAt(int position) {
        onView(withId(R.id.dish_list)).perform(
                RecyclerViewActions.actionOnItemAtPosition(position, click()));
    }

    private void openTableAt(int position) {
        onView(withId(R.id.table_list)).perform(
                RecyclerViewActions.actionOnItemAtPosition(position, click()));
    }

    private void openOrderAt(int position) {
        onView(withId(R.id.order_list)).perform(
                RecyclerViewActions.actionOnItemAtPosition(position, click()));
    }

    public static Matcher<RecyclerView.ViewHolder> withHolderTimeView(final String text) {
        return new BoundedMatcher<RecyclerView.ViewHolder, BaseRecyclerViewAdapter.BaseViewHolder>(BaseRecyclerViewAdapter.BaseViewHolder.class) {

            @Override
            public void describeTo(Description description) {
                description.appendText("No ViewHolder found with text: " + text);
            }

            @Override
            protected boolean matchesSafely(BaseRecyclerViewAdapter.BaseViewHolder item) {
                TextView timeViewText = (TextView) item.itemView.findViewById(R.id.txtNumberOrders);
                if (timeViewText == null) {
                    return false;
                }
                return timeViewText.getText().toString().contains(text);
            }
        };
    }
}
