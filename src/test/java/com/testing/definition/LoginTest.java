package com.testing.definition;

import org.testng.Assert;

import com.microsoft.playwright.Page;
import com.testing.utils.DriverUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {

    private Page page = DriverUtil.page;

    @Given("Saya membuka browser dan mengakses halaman login.")
    public void openBrowserAndAccessLogin() {
        page.navigate("https://www.saucedemo.com/");
    }

    @When("Saya memasukkan kredensial yang valid berupa {string} dan {string}.")
    public void iEnterValidCredentials(String username, String password) {
        page.locator("[data-test='username']").fill(username);
        page.locator("[data-test='password']").fill(password);
    }

    @When("Saya menekan tombol Login.")
    public void iPressTheLoginButton() {
        page.locator("[data-test='login-button']").click();
    }

    @Then("Pengujian ini berdasarkan {string} dengan pesan {string}.")
    public void theTestIsBasedOnStatusWithMessage(String status, String error) {
        if (status.equalsIgnoreCase("valid")) {
            Assert.assertTrue(page.url().contains("inventory.html"));
        } else {
            Assert.assertTrue(page.locator(".error-message-container.error").isVisible());
        }
    }
}
