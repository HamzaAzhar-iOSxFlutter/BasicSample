package com.example.android.testing.espresso.BasicSample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class InstrumentedTesting {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkChangeTextButtonAndEmptyEditTextOpenActivity() {
        onView(withId(R.id.activityChangeTextBtn)).perform(click())
        onView(withId(R.id.show_text_view)).check(matches(withText("")))
    }

    @Test
    fun checkEditTextChangesTheTextButtonWithString() {
        onView(withId(R.id.editTextUserInput)).perform(typeText("abcdef"), closeSoftKeyboard())
        onView(withId(R.id.changeTextBt)).perform(click())
        onView(withId(R.id.textToBeChanged)).check(matches(withText("abcdef")))
    }

    @Test
    fun checkChangeTextButtonWithStringAndEditTextOpenActivity() {
        onView(withId(R.id.editTextUserInput)).perform(typeText("abcdef"), closeSoftKeyboard())
        onView(withId(R.id.activityChangeTextBtn)).perform(click())
        onView(withId(R.id.show_text_view)).check(matches(withText("abcdef")))
    }

    @Test
    fun checkForCorrectStringsInMainActivity() {
        onView(withId(R.id.textToBeChanged)).check(matches(withText("")))
    }

    @Test
    fun checkTheEditTextChangeInTextButton() {
        onView(withId(R.id.editTextUserInput)).perform(typeText("123"), closeSoftKeyboard())
        onView(withId(R.id.changeTextBt)).perform(click())

        onView(withId(R.id.textToBeChanged)).check(matches(withText("123")))
    }

    @Test
    fun checkChangeTextButtonAndEditTextOpenActivity() {
        onView(withId(R.id.editTextUserInput)).perform(typeText("123"), closeSoftKeyboard())
        onView(withId(R.id.activityChangeTextBtn)).perform(click())

        onView(withId(R.id.show_text_view)).check(matches(withText("123")))
    }

    @Test
    fun checkEmptyEditTextChangeTextButton() {
        onView(withId(R.id.changeTextBt)).perform(click())
        onView(withId(R.id.textToBeChanged)).check(matches(withText("")))
    }
}