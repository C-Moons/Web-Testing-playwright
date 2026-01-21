package com.testing.Page.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class NavbarComponent extends BaseComponent {
    private final Locator burgerMenu;
    private final Locator resetSidebarLink;
    private final Locator logoutLink;

    public NavbarComponent(Page page) {
        super(page);
        
        this.burgerMenu = page.locator("#react-burger-menu-btn");
        this.resetSidebarLink = page.locator("#reset_sidebar_link");
        this.logoutLink = page.locator("#logout_sidebar_link");
    }

    
    public void clickBurgerMenu() {
        waitingElementReady(burgerMenu).click();
    }

    
    public void clickResetSideBar() {
        waitingElementReady(resetSidebarLink).click();
    }

    
    public void clickLogout() {
        waitingElementReady(logoutLink).click();
    }

}
