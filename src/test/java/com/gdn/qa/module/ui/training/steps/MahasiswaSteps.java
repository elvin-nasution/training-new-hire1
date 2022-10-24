package com.gdn.qa.module.ui.training.steps;

import com.gdn.qa.automation.core.CucumberStepsDefinition;
import com.gdn.qa.automation.core.context.StepDefinition;
import com.gdn.qa.module.ui.training.api.controllers.MahasiswaController;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@StepDefinition
@CucumberStepsDefinition
public class MahasiswaSteps {

    @Autowired
    private MahasiswaController mahasiswaController;

    private List<Map<String, String>> mahasiswaData;

    @Given("I have mahasiswa data")
    public void iHaveMahasiswaData(DataTable dataTable) {
        mahasiswaData = dataTable.asMaps(String.class, String.class);
    }

    @When("I insert mahasiswa data")
    public void iInsertMahasiswaData() {
        mahasiswaData.forEach(data -> mahasiswaController.insertMahasiswa(data));
    }

    @Then("mahasiswa data should be inserted successfully")
    public void mahasiswaDataShouldBeInsertedSuccessfully() {
    }
}