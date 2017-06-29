package com.csci3130.athletetracker;

/**
 * Created by rainb on 2017/6/15.
 */
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class StepsUITest {
    private int min;
    private int max;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void initInt(){
         min = 1000;
         max = 20000;
    }

    @Test//not completed
    public void findTest(){
        onView(withId(R.id.b_gotoSetRangeScreen)).perform(click());// click SET RANGE button

      //  onView(withId(R.id.pagename)).check(matches(withId()));//check if the page jumped

       // onView(withId(R.id.et_stepsMinimum)).perform(typeText(min));
        //onView(withId(R.id.et_stepsMaximum)).perform(typeText(max));//input the min and max values

       // onView(withId(R.id.et_stepsMinimum)).check(matches(withText("1000")));
        //onView(withId(R.id.et_stepsMaximum)).check(matches(withText("20000")));

        onView(withId(R.id.b_rangeBackToMainScreen)).perform(click());// click RETURN TO MAIN button



    }

}

