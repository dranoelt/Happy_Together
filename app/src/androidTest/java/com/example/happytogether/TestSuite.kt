package com.example.happytogether

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses (
    LoginIntentTest::class,
    StartUpTest::class,
    LogoutIntentTest::class
)
class TestSuite