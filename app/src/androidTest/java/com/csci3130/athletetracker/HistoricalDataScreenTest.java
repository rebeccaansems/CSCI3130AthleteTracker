package com.csci3130.athletetracker;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.action.ViewActions.click;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.containsString;

import com.csci3130.athletetracker.AthleteHeartRate;

/**
 * Espresso tests for the historical data screen
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class HistoricalDataScreenTest {

    HistoricalData historicalData;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    @Before
    public void Start() {
        onView(withId(R.id.b_gotoHistoricalData)).perform(click());
    }

    public static String[] months = {
            "Select...",
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
    };

    /**
     * Tests that determine if the spinner has the correct information in it
     *
     * @throws InterruptedException to ignore Thread.Sleep
     */
    @Test
    public void SpinnerHasCorrectText() throws InterruptedException {
        for(int i=0; i<months.length; i++){
            Thread.sleep(1000);
            onView(withId(R.id.s_dateSpinner)).perform(click());

            onData(anything())
                    .atPosition(i)
                    .perform(click());

            onView(withId(R.id.s_dateSpinner))
                    .check(matches(withSpinnerText(containsString(months[i]))));
        }
    }

}
