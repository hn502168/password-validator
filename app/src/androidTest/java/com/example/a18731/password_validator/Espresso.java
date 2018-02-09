package com.example.a18731.password_validator;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by 18731 on 2018/2/9.
 */

public class Espresso {
    public void Equaltopass() {
        onView(withId(R.id.textview)).perform(typeText("password"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.editText)).check(matches(withText("password")));
    }
    public void lessthan8() {
        onView(withId(R.id.textview)).perform(typeText("123456"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.editText)).check(matches(withText("123456")));
    }
    public void specialchar() {
        onView(withId(R.id.textview)).perform(typeText("@@123456"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.editText)).check(matches(withText("@@123456")));
    }
    public void weak() {
        onView(withId(R.id.textview)).perform(typeText("qwertyuio"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.editText)).check(matches(withText("qwertyuio")));
    }
    public void notstrongEnough() {
        onView(withId(R.id.textview)).perform(typeText("12345678A"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.editText)).check(matches(withText("12345678A")));
    }
    public void strong() {
        onView(withId(R.id.textview)).perform(typeText("12345abcdeF"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.editText)).check(matches(withText("12345abcdeF")));
    }
}
