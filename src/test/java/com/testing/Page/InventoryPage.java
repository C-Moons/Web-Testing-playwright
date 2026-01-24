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
    private final Locator inventoryItemName;

    public InventoryPage(Page page) {
        super(page);
        
        
        this.headerComponent = new HeaderComponent(page);
        this.navbarComponent = new NavbarComponent(page);

        
        this.productSort = page.locator("[data-test='product-sort-container']");
        this.priceOfProducts = page.locator(".inventory_item_price");
        this.inventoryItemName = page.locator("[data-test='inventory-item-name']");

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

    private String formatProductNameForDataTest(String productName) {
        return productName.toLowerCase().replace(" ", "-");
    }

    public void addToCart(String productName) {
        String removeSelector = "[data-test='remove-" + formatProductNameForDataTest(productName) + "']";
        Locator removeButton = page.locator(removeSelector);
        if (removeButton.isVisible()) {
            return;
        }
        String addSelector = "add-to-cart-" + formatProductNameForDataTest(productName);
        Locator addToCartButton = page.locator("[data-test='" + addSelector + "']");
        addToCartButton.click();
    }

//remove button
    public void removeProductButton(String productName) {
        String dataTestSelector = "remove-" + formatProductNameForDataTest(productName);
        Locator removeButtonInventory = page.locator("[data-test='" + dataTestSelector + "']");

        if (removeButtonInventory.isVisible()) {
            removeButtonInventory.click();
        }
    }

//Sorting
    public void sortingByValue(String urutan){
        String sortValue = "";
        if (urutan.contains("low to high"))
            sortValue = "lohi";
        else if (urutan.contains("high to low"))
            sortValue = "hilo";
        else if (urutan.contains("Z to A"))
            sortValue = "za";
        else
            sortValue = "az";
        waitingElementReady(productSort).selectOption(sortValue);
    }

    public String getFirstProductName(){
        return inventoryItemName.first().textContent();
    }

    public String getFirstProductPrice(){
        return priceOfProducts.first().textContent();
    }
}
