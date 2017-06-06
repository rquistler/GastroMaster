package de.hsb.gastromaster.presentation.features.create_order;


import org.assertj.android.api.Assertions;
import org.junit.Rule;
import org.junit.Test;

import de.hsb.gastromaster.R;
import de.hsb.gastromaster.presentation.FragmentTestRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class CreateOrderFragmentTest {
    @Rule
    public FragmentTestRule<CreateOrderFragment> mFragmentTestRule =
            new FragmentTestRule<>(CreateOrderFragment.class);

    @Test
    public void fragment_can_be_instantiated() throws InterruptedException {

        // Launch the activity to make the fragment visible
        mFragmentTestRule.launchActivity(null);

        // Then use Espresso to test the Fragment
        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()));
    }
}
