package com.testing.Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {
    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;

    public LoginPage(Page page) {
        super(page);
        this.usernameInput = page.locator("[data-test='username']");
        this.passwordInput = page.locator("[data-test='password']");
        this.loginButton = page.locator("[data-test='login-button']");
    }

    public void inputUsername(String user) {
        usernameInput.fill(user);
    }

    public void inputPassword(String pass) {
        passwordInput.fill(pass);
    }

    public void clickButtonLogin() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return page.locator(".error-message-container.error").textContent();
    }

    public void login(String username, String password) {
        usernameInput.fill(username);
        passwordInput.fill(password);
        loginButton.click();
    }

}
