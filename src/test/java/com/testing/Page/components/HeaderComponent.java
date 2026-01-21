package com.testing.Page.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HeaderComponent extends BaseComponent{
    private final Locator cartIcon;

    public HeaderComponent(Page page) {
        super(page);
        // Selector sesuai data-test di foto lo
        this.cartIcon = page.locator("[data-test='shopping-cart-badge']");
    }

    public boolean isCartVisible() {
        return waitingElementReady(cartIcon).isVisible();
    }
}
