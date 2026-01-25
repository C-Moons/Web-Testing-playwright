package com.testing.Page.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HeaderComponent extends BaseComponent{
    private final Locator shoppingCartBadge;
    private final Locator shoppingCartLink;

    public HeaderComponent(Page page) {
        super(page);
        
        this.shoppingCartBadge = page.locator(".shopping_cart_badge");
        this.shoppingCartLink = page.locator("[data-test='shopping-cart-link']");
    }

    public boolean isCartVisible() {
        return waitingElementReady(shoppingCartBadge).isVisible();
    }

        public String getShoppingCartBadgeValue() {
        if (shoppingCartBadge.isVisible()) {
            return shoppingCartBadge.textContent();
        }
        return "";
    }

    public void cartLinkButton(){
        shoppingCartLink.click();
    }
}
