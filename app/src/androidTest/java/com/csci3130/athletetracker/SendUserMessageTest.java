package com.csci3130.athletetracker;


import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.containsString;

/**
 * Espresso tests for the historical data screen
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SendUserMessageTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    @Before
    public void Start() {
        onView(withId(R.id.b_gotoSendMessage)).perform(click());
    }

    @Test
    public void IncorrectPhoneNumberShowsDialog() throws InterruptedException {
        onView(withId(R.id.et_athletePhoneNumber))
                .perform(clearText(),typeText("0"), closeSoftKeyboard());

        onView(withId(R.id.b_sendMessage1)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage2)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage3)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage4)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());

        onView(withId(R.id.et_athletePhoneNumber))
                .perform(typeText("1"), closeSoftKeyboard());

        onView(withId(R.id.b_sendMessage1)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage2)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage3)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage4)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());

        onView(withId(R.id.et_athletePhoneNumber))
                .perform(typeText("2"), closeSoftKeyboard());

        onView(withId(R.id.b_sendMessage1)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage2)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage3)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage4)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());

        onView(withId(R.id.et_athletePhoneNumber))
                .perform(typeText("3"), closeSoftKeyboard());

        onView(withId(R.id.b_sendMessage1)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage2)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage3)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage4)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());

        onView(withId(R.id.et_athletePhoneNumber))
                .perform(typeText("4"), closeSoftKeyboard());

        onView(withId(R.id.b_sendMessage1)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage2)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage3)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage4)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());

        onView(withId(R.id.et_athletePhoneNumber))
                .perform(typeText("5"), closeSoftKeyboard());

        onView(withId(R.id.b_sendMessage1)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage2)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage3)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage4)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());

        onView(withId(R.id.et_athletePhoneNumber))
                .perform(typeText("6"), closeSoftKeyboard());

        onView(withId(R.id.b_sendMessage1)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage2)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage3)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage4)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());

        onView(withId(R.id.et_athletePhoneNumber))
                .perform(typeText("7"), closeSoftKeyboard());

        onView(withId(R.id.b_sendMessage1)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage2)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage3)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage4)).perform(click());
        onView(withText("Invalid Phone Number...")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
    }


    @Test
    public void CorrectPhoneNumberShowsDialog() throws InterruptedException {
        onView(withId(R.id.et_athletePhoneNumber))
                .perform(clearText(), typeText("012345678"), closeSoftKeyboard());

        onView(withId(R.id.b_sendMessage1)).perform(click());
        onView(withText("Message Sent")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage2)).perform(click());
        onView(withText("Message Sent")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage3)).perform(click());
        onView(withText("Message Sent")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.b_sendMessage4)).perform(click());
        onView(withText("Message Sent")).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
    }

}
