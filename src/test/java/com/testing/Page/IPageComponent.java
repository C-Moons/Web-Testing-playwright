package com.testing.Page;

import com.microsoft.playwright.Locator;

public interface IPageComponent {
    default Locator waitingElementReady(Locator locator) {
        locator.waitFor(); 
        return locator;
    }
}
