package StepDefinitions;

import PageObjects.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class CheckoutScenario {

    CheckoutPage checkoutPage;
    HomePage homepage;
    TestContextSetup testContextSetup;

    public CheckoutScenario(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
        this.checkoutPage=testContextSetup.pageObjectManager.getCheckoutPage();
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

    @And("Delete one product from cart")
    public void deleteOneProductFromCart() {
        homepage.Deleteitem();
    }

    @Then("Cart number decreases")
    public void cartNumberDecreases() throws InterruptedException {
        homepage.CartCountDecreases();
    }

    @Given("Verfy user is in checkout page")
    public void verfyUserIsInCheckoutPage() {
        homepage.gotocartpage();
        homepage.clickoncheckoutpage();
    }

    @When("User clicks continue button")
    public void userClicksContinueButton() {
        checkoutPage.clickContinue();
    }

    @Then("Error for checkout page is displayed")
    public void errorForCheckoutPageIsDisplayed() {
        checkoutPage.VerifyErrormsg();
    }
}
