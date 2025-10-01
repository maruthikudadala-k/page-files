package com.fleetservice.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginSteps {
    
    @Given("user is on the login page")
    public void userIsOnLoginPage() {
        // Implementation
    }
    
    @When("user enters username {string}")
    public void userEntersUsername(String username) {
        // Implementation
    }
    
    @When("user enters password {string}")
    public void userEntersPassword(String password) {
        // Implementation
    }
    
    @When("user clicks on login button")
    public void userClicksLoginButton() {
        // Implementation
    }
    
    @Then("user should see the dashboard")
    public void userShouldSeeDashboard() {
        // Implementation
    }
    
    @Then("user should see error message {string}")
    public void userShouldSeeErrorMessage(String message) {
        // Implementation
    }
}
