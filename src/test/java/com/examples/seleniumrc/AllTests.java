package com.examples.seleniumrc;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AppTest.class, TestCase1.class, TestCase2.class, KyotokimonoRentalTest.class })
public class AllTests {

}
