package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://trello.com/login")
public class LoginPage extends GeneralPage{
    @FindBy(id="user")
    private WebElement usernameInput;
    @FindBy(css="#password")
    private WebElement passwordInput;
    @FindBy(id="login-submit")
    private WebElement loginButton;

    public void inputUsername(String username){
        usernameInput.sendKeys(username);
    }
    public void inputPassword(String password) {
        getElementWithValueAttribute("Log in with Atlassian").click();
        passwordInput.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
}
