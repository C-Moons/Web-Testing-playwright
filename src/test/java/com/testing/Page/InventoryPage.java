package com.testing.Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.testing.Page.components.HeaderComponent;
import com.testing.Page.components.NavbarComponent;

public class InventoryPage extends BasePage implements IPageComponent {
    private HeaderComponent headerComponent;
    private NavbarComponent navbarComponent;

    
    private final Locator productSort;
    private final Locator priceOfProducts;
    private final Locator textHeader;

    public InventoryPage(Page page) {
        super(page);
        
        
        this.headerComponent = new HeaderComponent(page);
        this.navbarComponent = new NavbarComponent(page);

        
        this.productSort = page.locator("[data-test='product-sort-container']");
        this.priceOfProducts = page.locator(".inventory_item_price");
        this.textHeader = page.locator(".title");
    }

    
    public HeaderComponent getHeaderComponent() {
        return headerComponent;
    }

    public NavbarComponent getNavbarComponent() {
    return navbarComponent;
    }
    
    public String getPathURL() {
        String[] path = page.url().split("/");
        return "/" + path[path.length - 1];
    }

}
