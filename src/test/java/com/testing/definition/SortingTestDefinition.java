package com.testing.definition;

import org.testng.Assert;

import com.testing.Page.InventoryPage;
import com.testing.Page.LoginPage;
import com.testing.utils.DriverUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SortingTestDefinition {
private LoginPage loginPage = new LoginPage(DriverUtil.getPage());
    private InventoryPage inventoryPage = new InventoryPage(DriverUtil.getPage());

    @Given("Saya akses web dan login dengan username {string} & password {string} dan berada di halaman Invetory.")
    public void accessWebAndLogin(String user, String pass) {

        DriverUtil.getPage().navigate("https://www.saucedemo.com/");
        loginPage.inputUsername(user);
        loginPage.inputPassword(pass);
        loginPage.clickButtonLogin();
        Assert.assertTrue(DriverUtil.getPage().url().contains("inventory.html"));
    }

    @When("Saya memilih opsi urutan {string}")
    public void chooseSort(String urutan) {
        inventoryPage.sortingByValue(urutan);
    }

    @Then("Produk pertama yang tampil adalah {string} dengan harga {string}.")
    public void resultSort(String expectedName, String expectedPrice) {
    Assert.assertEquals(inventoryPage.getFirstProductName(), expectedName);
    Assert.assertEquals(inventoryPage.getFirstProductPrice(), expectedPrice);
    }
}
