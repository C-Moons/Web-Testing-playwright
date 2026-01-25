package com.testing.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features/LoginTest.feature", "src/test/resources/features/AddtoCartTest.feature", "src/test/resources/features/SortingTest.feature", "src/test/resources/features/DeleteFromInventoryTest.feature", "src/test/resources/features/CheckoutProduct.feature"},
    glue = {
                "com.testing.definition",
                "com.testing.hook",
}, plugin = { "pretty", "html:test-output", "json:target/cucumber/cucumber.json",
                "html:target/cucumber-html-report",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class RunnerTest extends AbstractTestNGCucumberTests{
    
}
