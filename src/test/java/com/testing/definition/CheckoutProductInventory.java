package com.testing.definition;

import org.testng.Assert;

import com.testing.Page.CartPage;
import com.testing.Page.InventoryPage;
import com.testing.Page.LoginPage;
import com.testing.Page.CheckoutStepOnePage;
import com.testing.Page.CheckoutStepTwoPage;
import com.testing.utils.DriverUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CheckoutProductInventory {

    private LoginPage loginPage = new LoginPage(DriverUtil.getPage());
    private InventoryPage inventoryPage = new InventoryPage(DriverUtil.getPage());
    private CartPage cartPage = new CartPage(DriverUtil.getPage());
    private CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(DriverUtil.getPage());
    private CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(DriverUtil.getPage());

    @Given("Saya akses web dan login ke halaman Inventory dengan username {string} dan password {string}.")
    public void accessBrowserAndLogin(String user, String pass) {
        DriverUtil.getPage().navigate("https://www.saucedemo.com/");
        loginPage.inputUsername(user);
        loginPage.inputPassword(pass);
        loginPage.clickButtonLogin();
        Assert.assertTrue(DriverUtil.getPage().url().contains("inventory.html"));
    }

    @And("saya menekan keranjang belanja.")
    public void clickCartButton() {
        inventoryPage.getHeaderComponent().cartLinkButton();
    }

    @And("saya menekan tombol Checkout di halaman keranjang.")
    public void checkoutButton() {
        cartPage.buttonCheckout();
    }

    @And("Saya input nama depan {string}, belakang {string}, dan kode pos {string}.")
    public void inputForm(String first_name, String last_name, String postal_code) {
        checkoutStepOnePage.inputFirstName(first_name);
        checkoutStepOnePage.inputLastName(last_name);
        checkoutStepOnePage.inputPostalCode(postal_code);
    }

    @And("Saya menekan tombol continue.")
    public void clickButtonContinue() {
        checkoutStepOnePage.clickContinueButton();
    }

    @Then("Saya menekan tombol finish.")
    public void clickFinishButton() {
        checkoutStepTwoPage.clickFinishButton();
        Assert.assertTrue(DriverUtil.getPage().url().contains("checkout-complete.html"));
    }
}
