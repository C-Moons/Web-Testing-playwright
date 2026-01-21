package com.testing.hook;



import com.microsoft.playwright.Page;
import com.testing.utils.DriverUtil;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;



public class Hook {
    
    @BeforeAll
    public static void beforeHook(){
        DriverUtil.setup();
    }

    @AfterAll
    public static void afterHook(){
        DriverUtil.destroy();
    }

    @After
    public void tearDown(Scenario scenario) {
        
            
            Page page = DriverUtil.getPage();
            
            
            final byte[] screenshot = page.screenshot(new Page.ScreenshotOptions()
                    .setFullPage(true)); 
            
            
            scenario.attach(screenshot, "image/png", scenario.getName());
        
    }
}
