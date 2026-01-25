package com.testing.Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutStepOnePage extends BasePage {

    private final Locator firstName;
    private final Locator lastName;
    private final Locator postalCode;
    private final Locator continueButton;

    public CheckoutStepOnePage(Page page){
        super(page);

        this.firstName = page.locator("[data-test='firstName']");
        this.lastName = page.locator("[data-test='lastName']");
        this.postalCode = page.locator("[data-test='postalCode']");
        this.continueButton = page.locator("[data-test='continue']");
    }

    public void inputFirstName(String nameFirst){
        firstName.fill(nameFirst);
    }

    public void inputLastName(String nameLast){
        lastName.fill(nameLast);
    }

    public void inputPostalCode(String code){
        postalCode.fill(code);
    }

    public void clickContinueButton(){
        continueButton.click();
    }
}
