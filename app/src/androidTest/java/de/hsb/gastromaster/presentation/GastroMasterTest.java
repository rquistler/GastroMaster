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
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.hsb.gastromaster.R;
import de.hsb.gastromaster.presentation.features.BaseRecyclerViewAdapter;
import de.hsb.gastromaster.presentation.ui.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static de.hsb.gastromaster.presentation.Assertions.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.Is.is;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class GastroMasterTest {
    private FragmentManager fragmentManager;
    private int sleepTime = 1000;
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

    @Test
    public void testCreateOrder() throws InterruptedException {
        Thread.sleep(sleepTime);
        openTableAt(0);
        Thread.sleep(sleepTime);
        onView(withId(R.id.btnAddOrder)).perform(click());
        Thread.sleep(sleepTime);
        selectDishAt(0);
        Thread.sleep(sleepTime);
        activityRule.getActivity().onBackPressed();
        Thread.sleep(sleepTime);
        activityRule.getActivity().onBackPressed();
        Thread.sleep(sleepTime);
        activityRule.getActivity().onBackPressed();
        Thread.sleep(sleepTime);
        onView(withId(R.id.table_list)).check(matches(isDisplayed()));
        Thread.sleep(sleepTime);
/*        onView(withRecyclerView(R.id.table_list)
                .atPositionOnView(1, R.id.txtNumberOrders))
                .check(matches(withText("Test text")));
                RecyclerViewActions.actionOnItemAtPosition(0,withHolderTimeView(String.valueOf(3)));
        */Thread.sleep(sleepTime);
        Thread.sleep(sleepTime);
        Thread.sleep(sleepTime);
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
