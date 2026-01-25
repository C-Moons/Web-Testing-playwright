package com.testing.Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CartPage extends BasePage {
    private final Locator checkoutButton;

    public CartPage(Page page) {
        super(page);

        this.checkoutButton = page.locator("[data-test='checkout']");
    }

    public void buttonCheckout() {
        checkoutButton.click();
    }
}
