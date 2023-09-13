package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    public void user_enters_the_login_details_and_clicks_on_login(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.enterlogindetails(username,password);
    }
    @Then("Error msg is shown")
    public void error_msg_is_shown() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.Verifyerrormsg();
    }


    @Then("Verify user is in home page")
    public void verifyUserIsInHomePage() {
        loginPage.verifylogin();
    }
}
