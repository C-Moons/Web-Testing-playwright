package com.testing.Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutStepTwoPage extends BasePage {

    private final Locator finishButton;

    public CheckoutStepTwoPage(Page page){
        super(page);

        this.finishButton = page.locator("[data-test='finish']");
    }

    public void clickFinishButton(){
        finishButton.click();
    }
}
