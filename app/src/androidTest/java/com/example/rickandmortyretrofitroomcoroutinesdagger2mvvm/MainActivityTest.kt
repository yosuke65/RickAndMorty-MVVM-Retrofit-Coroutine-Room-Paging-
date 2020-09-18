package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.server.MyMockServer

import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.ui.main.MainActivity
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private lateinit var mockWebServer: MockWebServer

    @get:Rule
//    val activityRule = ActivityScenarioRule(MainActivity::class.java)
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    @Before
    fun setup(){
        mockWebServer = MockWebServer()
        mockWebServer.start(8080)
    }
    @After
    fun tearDown(){
        mockWebServer.shutdown()
    }

    @Test
    fun onCharacterCardClick() {
        Espresso
            .onView(
                ViewMatchers.withId(R.id.constraint_layout_main)
            ).check(
                ViewAssertions.matches(
                    ViewMatchers.isDisplayed()
                )
            )
    }

}