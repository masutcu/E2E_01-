package stepdefinitions.e2e_test;

import io.cucumber.java.en.*;
import pages.MedunnaHomePage;
import pages.MedunnaLoginPage;
import pages.MedunnaRoomPage;
import utilities.ConfigReader;
import utilities.Driver;

public class MedunnaSignInStepDefinitions  {
    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
    MedunnaLoginPage medunnaLoginPage = new MedunnaLoginPage();
    MedunnaRoomPage medunnaRoomPage = new MedunnaRoomPage();
    @Given("go to {string}")
    public void go_to(String url) {
        Driver.getDriver().get(url);

    }
    @When("click on user icon")
    public void click_on_user_icon() {
        medunnaHomePage.userIcon.click();

    }
    @When("click on sign in option")
    public void click_on_sign_in_option() {
        medunnaHomePage.signInOption.click();

    }
    @When("send user name into username input")
    public void send_user_name_into_username_input() {
        medunnaLoginPage.usernameInput.sendKeys(ConfigReader.getProperty("medunna_username"));

    }
    @When("send password into password input")
    public void send_password_into_password_input() {
        medunnaLoginPage.passwordInput.sendKeys(ConfigReader.getProperty("medunna_password"));

    }
    @When("click on sign in submit button")
    public void click_on_sign_in_submit_button() {
        medunnaLoginPage.signInSubmitButton.click();

    }
}
