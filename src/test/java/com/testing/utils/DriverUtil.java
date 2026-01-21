package com.testing.utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DriverUtil {
    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;
    
    public static void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setArgs(java.util.Arrays.asList("--start-maximized")));

        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(null)); 
        page = context.newPage();
    }

    public static Page getPage() {
        return page;
    }

    public static void destroy() {
        if (page != null) page.close();
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
