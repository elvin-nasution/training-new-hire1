package com.gdn.qa.module.ui.training.steps;

import com.gdn.qa.automation.core.CucumberStepsDefinition;
//import hampcrest for assertions
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;

import com.gdn.qa.module.ui.training.pages.HomePage;
import com.gdn.qa.module.ui.training.pages.ProductPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

@CucumberStepsDefinition
public class SauceDemoSteps {

    @Autowired
    private HomePage loginPage;

    @Autowired
    private ProductPage productPage;


    @Given("user open sauce demo home page")
    public void userOpenSauceDemoHomePage() {
        loginPage.openSauceDemo();
    }

    @Then("user should be able to see {string}")
    public void userShouldBeAbleToSee(String expectedConditions) {
        assertThat("Page is not expected",
                loginPage.getTxtTitle(), equalTo(expectedConditions));
    }

    @When("user type {string} in username field")
    public void userTypeInUsernameField(String arg0) {
        loginPage.setUsernameForm("standard_user");
    }

    @When("user type {string} in password field")
    public void userTypeInPasswordField(String arg0) {
        loginPage.setPasswordForm("secret_sauce");
    }

    @When("user click on button login")
    public void userClickOnButtonLogin() {
        loginPage.clickLoginBtn();
    }

    @Then("user should be able to see product page")
    public void userShouldBeAbleToSeeProductPage(String expectedConditions) {
        assertThat("Page is not expected",
                productPage.getTxtProducts(), equalTo(expectedConditions));
    }
}
