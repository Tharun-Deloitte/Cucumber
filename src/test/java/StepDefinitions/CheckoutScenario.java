package StepDefinitions;

import PageObjects.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class CheckoutScenario {

    LoginPage loginPage;
    HomePage homepage;
    TestContextSetup testContextSetup;

    public CheckoutScenario(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
        this.loginPage=testContextSetup.pageObjectManager.getLoginPage();
        this.homepage=testContextSetup.pageObjectManager.getHomePage();

    }

    @When("^User adds the (.+)$")
    public void user_adds_the_productname(String productname) {
        homepage.clickaddtocart();
    }

    @Then("Cart number increases")
    public void cart_number_increases() {
        homepage.compareCartcount();
    }

    @And("Get the cart count")
    public void getTheCartCount() {
        homepage.GetCartCountBefore();

    }
}
