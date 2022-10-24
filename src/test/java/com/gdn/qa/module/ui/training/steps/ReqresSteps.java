package com.gdn.qa.module.ui.training.steps;

import com.gdn.qa.automation.core.CucumberStepsDefinition;
import com.gdn.qa.automation.core.context.StepDefinition;
import com.gdn.qa.automation.core.restassured.ResponseApi;
import com.gdn.qa.module.ui.training.api.controllers.ReqresController;
import com.gdn.qa.module.ui.training.models.responses.reqres.ListUsers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@StepDefinition
@CucumberStepsDefinition
public class ReqresSteps {

    @Autowired
    private ReqresController reqresController;

    private int page;

    private ListUsers listUsers;

    private Response listUsersResponse;

    @Given("I want to get users data for page {int}")
    public void getUsersDataForPage(int page) {
        this.page = page;
    }

    @When("I retrieve list of users data")
    public void iRetrieveListOfUsersData() {
        ResponseApi<ListUsers> responseApi = reqresController.getListUsers(page);
        listUsersResponse = responseApi.getResponse();
        listUsers = responseApi.getResponseBody();
    }

    @Then("I should get list of users")
    public void iShouldGetListOfUsers() {
        assertThat(listUsers.getData(), is(not(empty())));
        assertThat(Integer.parseInt(String.valueOf(listUsers.getPage())), equalTo(page));
        assertThat(listUsersResponse.asString(), JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/GetListUsers.json"));
    }
}