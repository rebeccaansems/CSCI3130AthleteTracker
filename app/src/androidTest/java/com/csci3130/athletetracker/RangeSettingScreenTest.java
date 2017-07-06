package com.csci3130.athletetracker;

/**
 * Espresso tests for heart rate + steps range setting screen
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.espresso.ViewAction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase;
import android.view.KeyEvent;
import android.widget.EditText;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.action.ViewActions.click;

import com.csci3130.athletetracker.AthleteHeartRate;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RangeSettingScreenTest {

    AthleteHeartRate athleteHeartRate;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void Start() {
        onView(withId(R.id.b_gotoSetRangeScreen)).perform(click());
        athleteHeartRate = new AthleteHeartRate();
    }

    /** Tests that entering in a number in the min heart rate text field
     * results in the min test rate being set to that value
     */
    @Test
    public void minRangeHeartRateSet()
    {
        onView(withId(R.id.et_heartRateMinimum))
                .perform(clearText(),typeText(Integer.toString(athleteHeartRate.defaultHeartRateMin)), closeSoftKeyboard());

        onView(withId(R.id.b_rangeBackToMainScreen)).perform(click());
        onView(withId(R.id.b_gotoSetRangeScreen)).perform(click());

        onView(withId(R.id.et_heartRateMinimum))
                .check(matches(withText(Integer.toString(athleteHeartRate.heartRateMin))));
    }

    /** Tests that entering in a number in the max heart rate text field
     * results in the max test rate being set to that value
     */
    @Test
    public void maxRangeHeartRateSet()
    {
        onView(withId(R.id.et_heartRateMaximum))
                .perform(clearText(), typeText(Integer.toString(athleteHeartRate.defaultHeartRateMax)), closeSoftKeyboard());

        onView(withId(R.id.b_rangeBackToMainScreen)).perform(click());
        onView(withId(R.id.b_gotoSetRangeScreen)).perform(click());

        onView(withId(R.id.et_heartRateMaximum))
                .check(matches(withText(Integer.toString(athleteHeartRate.heartRateMax))));
    }

    /** Tests that clicking the default heart rate button
     * results in the min/max heart rate range being reset back
     * to their default values
     */
    @Test
    public void defaultHeartRateSet()
    {
        onView(withId(R.id.et_heartRateMinimum))
                .perform(clearText(),typeText(Integer.toString(athleteHeartRate.defaultHeartRateMin-10)), closeSoftKeyboard());
        onView(withId(R.id.et_heartRateMaximum))
                .perform(clearText(),typeText(Integer.toString(athleteHeartRate.defaultHeartRateMax+10)), closeSoftKeyboard());

        onView(withId(R.id.b_resetToDefaultRange)).perform(click());
        onView(withId(R.id.b_rangeBackToMainScreen)).perform(click());
        onView(withId(R.id.b_gotoSetRangeScreen)).perform(click());

        onView(withId(R.id.et_heartRateMinimum))
                .check(matches(withText(Integer.toString(athleteHeartRate.defaultHeartRateMin))));

        onView(withId(R.id.et_heartRateMaximum))
                .check(matches(withText(Integer.toString(athleteHeartRate.defaultHeartRateMax))));
    }

}
