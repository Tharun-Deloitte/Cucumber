package StepDefinitions;

import PageObjects.*;
import com.aventstack.extentreports.util.Assert;
import com.sun.source.tree.AssertTree;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.Assertion;
import utils.GenericUtils;
import utils.TestContextSetup;

import java.util.ArrayList;

public class CheckoutScenario {

    CheckoutPage checkoutPage;
    HomePage homepage;
    CartPage cartPage;
    TestContextSetup testContextSetup;

    public CheckoutScenario(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
        this.checkoutPage=testContextSetup.pageObjectManager.getCheckoutPage();
        this.homepage=testContextSetup.pageObjectManager.getHomePage();
        this.cartPage=testContextSetup.pageObjectManager.getCartPage();
    }


    @When("User adds product {string}")
    public void userAddsAnyOneProduct(String productname) {
        homepage.clickaddtocart(productname);
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


    @And("Go to cart page")
    public void goToCartPage() {
        homepage.gotocartpage();
    }

    @Then("Verify same products are displayed in cart page")
    public void verifySameProductsAreDisplayedInCartPage() {
        ArrayList<ArrayList<String>> ProductListFromCSV;
        ArrayList<ArrayList<String>> ProductListFromCartPage;
        ProductListFromCSV= GenericUtils.readCSVToList();
        ProductListFromCartPage= cartPage.verifyCartPageProducts();
        boolean areListsEqual = ProductListFromCartPage.equals(ProductListFromCSV);
        System.out.println(ProductListFromCartPage);
        System.out.println(ProductListFromCSV);
        System.out.println(areListsEqual);
        assert  areListsEqual;
    }
}
