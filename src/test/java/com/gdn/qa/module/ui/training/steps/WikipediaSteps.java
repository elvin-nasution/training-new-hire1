package com.gdn.qa.module.ui.training.steps;

import com.gdn.qa.automation.core.CucumberStepsDefinition;
import com.gdn.qa.automation.core.context.StepDefinition;
import com.gdn.qa.module.ui.training.pages.WikipediaPage;
import com.gdn.qa.module.ui.training.properties.WebProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@StepDefinition
@CucumberStepsDefinition
public class WikipediaSteps extends ScenarioSteps {

    @Autowired
    private WikipediaPage wikipediaPage;

    @Autowired
    private WebProperties webProperties;

    @Given("user open Wikipedia")
    public void userOpenWikipedia() {
        wikipediaPage.openAt(webProperties.getEndpoint().get("wikionary"));
    }

    @When("user search fruit {string}")
    public void userSearchFruitFruit(String arg0) {
        wikipediaPage.typeToSearchButton(arg0);
        wikipediaPage.clickSearchButton();
    }

    @Then("user should be able to see {string} page")
    public void userShouldBeAbleToSeeFruitPage(String arg0) {
        assertThat(wikipediaPage.getPageHeading(), equalToIgnoringCase(arg0));
    }
}