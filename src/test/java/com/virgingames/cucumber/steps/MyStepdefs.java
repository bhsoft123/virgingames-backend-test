package com.virgingames.cucumber.steps;

import com.virgingames.bookinginfo.UserSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;

import static org.hamcrest.Matchers.equalTo;

public class MyStepdefs {

    static ValidatableResponse response;

    @Steps
    UserSteps steps;

    @When("I send a GET request to user endpoint")
    public void iSendAGETRequestToUserEndpoint() {
        response = steps.getAllUsersOfBingo();
        response.log().all();
    }

    @Then("I verify the response code is {int}")
    public void iVerifyTheResponseCodeIs(int statusCode) {
        response.statusCode(statusCode);
    }

    @And("I send different query parameters {string}  {string}")
    public void iSendDifferentQueryParameters(String key, String value) {
        response = steps.getUsersWithQueryParams(key,value);
        response.log().all();
    }

    @Then("I verify for each id {string} currency {string} is displayed correctly")
    public void iVerifyForEachIdIdCurrencyCurrencyIsDisplayedCorrectly(String id, String currency) {
        String s1= "data.pots.find{it.id == '";
        String s2= "'}.currency";
        response.body(s1+id+s2,equalTo(currency));
    }

    @And("I verify for each id {string} name {string} is displayed correctly")
    public void iVerifyForEachIdNameIsDisplayedCorrectly(String id, String name) {
        String s1= "data.pots.find{it.id == '";
        String s2= "'}.name";
        response.body(s1+id+s2,equalTo(name));
    }
    }

