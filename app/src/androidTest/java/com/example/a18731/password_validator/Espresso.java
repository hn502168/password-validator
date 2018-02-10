package com.example.a18731.password_validator;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by 18731 on 2018/2/9.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class Espresso {
    private String Password;
    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    @Test
    public void Equaltopass() {
        Password = "password";
        onView(withId(R.id.editText)).perform(typeText(Password),closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textview)).check(matches(withText("The password cannot be word 'password'")));
    }
    @Test
    public void lessthan8() {
        Password = "123456";
        onView(withId(R.id.editText)).perform(typeText(Password),closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textview)).check(matches(withText("The password need to longer than 8 numbers/letters")));
    }
    @Test
    public void specialchar() {
        Password = "@@123456";
        onView(withId(R.id.editText)).perform(typeText(Password),closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textview)).check(matches(withText("The password cannot include special character")));
    }
    @Test
    public void weak() {
        Password = "qwertyuio";
        onView(withId(R.id.editText)).perform(typeText(Password),closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textview)).check(matches(withText("The password is weak")));
    }
    @Test
    public void notstrongEnough() {
        Password = "12345678A";
        onView(withId(R.id.editText)).perform(typeText(Password),closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textview)).check(matches(withText("The password is not strong enough")));
    }
    @Test
    public void strong() {
        Password = "12345abcdeF";
        onView(withId(R.id.editText)).perform(typeText(Password),closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textview)).check(matches(withText("The password is strong")));
    }
}
