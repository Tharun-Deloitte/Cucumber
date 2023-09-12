package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.TestContextSetup;
import PageObjects.LoginPage;


public class LoginStepDefinition {
    LoginPage loginPage;
    TestContextSetup testContextSetup;

    public LoginStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
        this.loginPage=testContextSetup.pageObjectManager.getLoginPage();

    }
    @Given("User is on SauceLabs Login Page")
    public void user_is_on_sauce_labs_login_page() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.getTitleLoginPage().contains("Swag Labs");
    }

    @When("^User enters the login details (.+) (.+) and clicks on login$")
    public void user_enters_the_login_details_dssdfsfs_sdvsss_and_clicks_on_login(String username,String password) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(username+password);
    }
    @Then("Error msg is shown")
    public void error_msg_is_shown() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Error msg is displayed");
    }



}
