package de.hsb.gastromaster.presentation;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.FragmentManager;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.hsb.gastromaster.R;
import de.hsb.gastromaster.presentation.ui.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static de.hsb.gastromaster.presentation.Assertions.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.Is.is;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class GastroMasterTest {
    private FragmentManager fragmentManager;
    private int sleepTime = 0;
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void init(){
        fragmentManager = activityRule.getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction();
    }

    @Test
    public void testIfTableListIsShownAfterAppStarted(){
        onView(withId(R.id.table_list)).check(matches(isDisplayed()));
    }
    @Test
    public void testIfTableListIsNotEmptyAfterAppStarted() throws InterruptedException {
        Thread.sleep(sleepTime);
        onView(withId(R.id.table_list)).check(withItemCount(is(4)));
    }

    @Test
    public void testIfOrderListIsShownAfterOnFirstTableClicked() throws InterruptedException {
        Thread.sleep(sleepTime);
        openTableAt(0);
        Thread.sleep(sleepTime);
        onView(withId(R.id.order_list)).check(matches(isDisplayed()));
    }

    @Test
    public void testIfOrderListIsNotEmptyAfterOnFirstTableClicked() throws InterruptedException {
        Thread.sleep(sleepTime);
        openTableAt(0);
        Thread.sleep(sleepTime);
        onView(withId(R.id.order_list)).check(withItemCount(is(2)));
        Thread.sleep(sleepTime);
    }

    @Test
    public void testIfOrderDetailForFirstOrderOfFirstTableHas2Dishes() throws InterruptedException {
        Thread.sleep(sleepTime);
        openTableAt(0);
        Thread.sleep(sleepTime);
        openOrderAt(0);
        Thread.sleep(sleepTime);
        onView(withId(R.id.order_detail_dish_list)).check(withItemCount(is(2)));
        Thread.sleep(sleepTime);
    }
    @Test
    public void testLaunchingDishList() throws InterruptedException {
        openTableAt(0);
        Thread.sleep(sleepTime);
        onView(withId(R.id.btnAddOrder)).perform(click());
        Thread.sleep(sleepTime);
        onView(withId(R.id.dish_list)).check(matches(isDisplayed()));
        Thread.sleep(sleepTime);

        activityRule.getActivity().onBackPressed();
        Thread.sleep(sleepTime);
        activityRule.getActivity().onBackPressed();
        Thread.sleep(sleepTime);

        openTableAt(1);
        Thread.sleep(sleepTime);
        onView(withId(R.id.btnAddOrder)).perform(click());
        Thread.sleep(sleepTime);
        onView(withId(R.id.dish_list)).check(matches(isDisplayed()));
        Thread.sleep(sleepTime);

        activityRule.getActivity().onBackPressed();
        Thread.sleep(sleepTime);
        activityRule.getActivity().onBackPressed();
        Thread.sleep(sleepTime);

        openTableAt(2);
        Thread.sleep(sleepTime);
        onView(withId(R.id.btnAddOrder)).perform(click());
        Thread.sleep(sleepTime);
        onView(withId(R.id.dish_list)).check(matches(isDisplayed()));
        Thread.sleep(sleepTime);

        activityRule.getActivity().onBackPressed();
        Thread.sleep(sleepTime);
        activityRule.getActivity().onBackPressed();
        Thread.sleep(sleepTime);

    }

    private void openTableAt(int position) {
        onView(withId(R.id.table_list)).perform(
                RecyclerViewActions.actionOnItemAtPosition(position, click()));
    }

    private void openOrderAt(int position) {
        onView(withId(R.id.order_list)).perform(
                RecyclerViewActions.actionOnItemAtPosition(position, click()));
    }

}
