package com.csci3130.athletetracker;


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

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.action.ViewActions.click;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

import com.csci3130.athletetracker.AthleteHeartRate;

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

    /*@Test
    public void Test(){
        onView(withId(R.id.t_viewData)).check(matches(withText("sup")));
    }*/

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
