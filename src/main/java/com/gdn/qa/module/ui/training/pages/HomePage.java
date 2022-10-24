package com.gdn.qa.module.ui.training.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component("com.gdn.qa.module.ui.training.pages.HomePage")
public class HomePage extends PageObject {

    @FindBy(id = "login_credentials")
    private WebElementFacade txtTitle;

    @FindBy(id= "user-name")
    private WebElementFacade usernameForm;

    @FindBy(id = "password")
    private WebElementFacade passwordForm;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElementFacade loginBtn;


    public void openSauceDemo(){
        openAt("https://www.saucedemo.com/");
    }

    public void setUsernameForm(String username){
        usernameForm.type(username);
    }

    public void setPasswordForm(String password){
        passwordForm.type(password);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

    // for assertions
    public String getTxtTitle(){
        return txtTitle.waitUntilVisible().getText();
    }

}
