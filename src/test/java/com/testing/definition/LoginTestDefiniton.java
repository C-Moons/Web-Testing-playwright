package com.testing.definition;

import org.testng.Assert;

import com.testing.Page.LoginPage;
import com.testing.utils.DriverUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestDefiniton {

    private LoginPage loginPage = new LoginPage(DriverUtil.getPage());

    @Given("Saya membuka browser dan mengakses halaman login.")
    public void openBrowserAndAccessLogin() {
        DriverUtil.getPage().navigate("https://www.saucedemo.com/");
    }

    @When("Saya memasukkan kredensial yang valid berupa {string} dan {string}.")
    public void iEnterValidCredentials(String username, String password) {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
    }

    @When("Saya menekan tombol Login.")
    public void iPressTheLoginButton() {
        loginPage.clickButtonLogin();
    }

    @Then("Pengujian ini berdasarkan {string} dengan pesan {string}.")
    public void theTestIsBasedOnStatusWithMessage(String status, String error) {
        if (status.equalsIgnoreCase("valid")) {
            Assert.assertTrue(DriverUtil.getPage().url().contains("inventory.html"));
        } else {
            Assert.assertTrue(loginPage.getErrorMessage().contains(error));
        }
    }
}
