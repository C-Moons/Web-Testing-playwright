package com.testing.hook;



import com.testing.utils.DriverUtil;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;



public class Hook {
    
    @BeforeAll
    public static void beforeHook(){
        DriverUtil.setup();
    }

    @AfterAll
    public static void afterHook(){
        DriverUtil.destroy();
    }
}
