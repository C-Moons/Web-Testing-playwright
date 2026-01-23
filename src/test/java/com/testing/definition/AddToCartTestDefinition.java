package com.testing.definition;

import com.testing.Page.InventoryPage;
import com.testing.Page.LoginPage;
import com.testing.utils.DriverUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class AddToCartTestDefinition {

    private LoginPage loginPage = new LoginPage(DriverUtil.getPage());
    private InventoryPage inventoryPage = new InventoryPage(DriverUtil.getPage());

    // Add To Cart Test
    @Given("Saya sudah login dengan username {string} & password {string} dan berada di halaman Invetory.")
    public void userLoggedInAndOnInventoryPage(String username, String password) {
        DriverUtil.getPage().navigate("https://www.saucedemo.com/");
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickButtonLogin();
        Assert.assertTrue(DriverUtil.getPage().url().contains("inventory.html"));
    }

    @When("Saya menekan tombol Add to cart pada produk {string}.")
    public void iPressTheAddToCartButtonOnTheProduct(String productName) {
        inventoryPage.addToCart(productName);
    }

    @Then("Ikon keranjang belanja menunjukkan angka {string}.")
    public void theShoppingCartIconShowsTheNumber(String count) {
        Assert.assertEquals(inventoryPage.getHeaderComponent().getShoppingCartBadgeValue(), count);
    }

    
}
