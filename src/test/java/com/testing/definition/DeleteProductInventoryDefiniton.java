package com.testing.definition;

import org.testng.Assert;

import com.testing.Page.InventoryPage;
import com.testing.Page.LoginPage;
import com.testing.utils.DriverUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DeleteProductInventoryDefiniton {

    private LoginPage loginPage = new LoginPage(DriverUtil.getPage());
    private InventoryPage inventoryPage = new InventoryPage(DriverUtil.getPage());

    @Given("Saya melakukan login dengan username {string} & password {string} dan berada di halaman Invetory.")
    public void accessBrowserAndLoginPage(String username, String pass) {
        DriverUtil.getPage().navigate("https://www.saucedemo.com/");
        loginPage.inputUsername(username);
        loginPage.inputPassword(pass);
        loginPage.clickButtonLogin();
        Assert.assertTrue(DriverUtil.getPage().url().contains("inventory.html"));
    }

    @And("Saya menekan tombol Remove pada produk {string}.")
    public void pressRemoveButton(String productname) {
        inventoryPage.removeProductButton(productname);
    }

    @Then("Ikon keranjang belanja menunjukkan {string}.")
    public void cartIconShowsNumber(String count) {
        Assert.assertEquals(inventoryPage.getHeaderComponent().getShoppingCartBadgeValue(), count);
    }

}
