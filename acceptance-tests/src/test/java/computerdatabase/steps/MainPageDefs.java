package computerdatabase.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.MatcherAssert;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class MainPageDefs extends AbstractStepDefs {

    @When("^I open the Home Page$")
    public void theMainPageHasBeenOpen() {
        homePage.open();
        dataContainer.setDataInTestStorage("COMPUTER_NUMBER", homePage.getComputerNumber());
    }

    @When("^I click on the 'Add a new computer' button on the Home Page$")
    public void iCLickOnTheAddANewComputerBtnOnTheHomePage() {
        homePage.clickOnAddNewComputerBtn();
    }

    @Then("^The Home Page should be open$")
    public void theHomePageShouldBeOpen() {
        MatcherAssert.assertThat("The Home Page has not been open", homePage.isPageDisplayed());
    }

    @Then("^The warning message should have the following text$")
    public void theWarningMessageShouldHaveTheFollowingText(String text) {
        MatcherAssert.assertThat("The text of the warning message is not correct", homePage.getTextFromWarningMessage(), equalTo(text));
    }

    @Then("^The quantity of computers increased by 1$")
    public void theQuantityOfComputersIncreasedByOne() {
        int storedNumber = (Integer) dataContainer.getValueFromTestStorage("COMPUTER_NUMBER");
        MatcherAssert.assertThat("The number of the stored computers is not correct", homePage.getComputerNumber(), equalTo(storedNumber + 1));
    }

    @Then("^The quantity of computers should not be changed$")
    public void theQuantityOfComputersShouldNotBeChnaged() {
        int storedNumber = (Integer) dataContainer.getValueFromTestStorage("COMPUTER_NUMBER");
        MatcherAssert.assertThat("The number of the stored computers is not correct", homePage.getComputerNumber(), equalTo(storedNumber));
    }

    @When("^I preform search by the name of the created computer$")
    public void iPerformSearchByTheNameOfTheCreatedComputer() {
        String value = String.valueOf(dataContainer.getValueFromTestStorage("Computer name"));
        homePage.performSearch(value);
    }

    @When("^I preform search by autogenerated value$")
    public void iPerformSearchByTAutogeneratedValue() {
        String value = UUID.randomUUID().toString();
        homePage.performSearch(value);
    }

    @When("^I preform search by the part of the autogenerated name of the created computer$")
    public void iPerformSearchByThePartOfTheAutogeneratedNameOfTheCreatedComputer() {
        String value = String.valueOf(dataContainer.getValueFromTestStorage("Computer name"));
        homePage.performSearch(value.substring(5));
    }

    @When("^I preform search by the part value$")
    public void iPerformSearchByTAutogeneratedValue(String value) {
        homePage.performSearch(value);
    }

    @Then("^The table counter shows '([^\"]*)' message$")
    public void theTableContainsOnlyOneRow(String message) {
        MatcherAssert.assertThat("'" + message + "' is not displayed in the table counter", homePage.getTextFromTableCounter(), equalTo(message));
    }

    @When("^I click on the created company in the table$")
    public void iClickOnTheCreatedCompanyInTheTable() {
        String value = String.valueOf(dataContainer.getValueFromTestStorage("Computer name"));
        homePage.openTheDisplayedCompanyInTheTable(value);
    }

    @Then("^'Nothing to display' message should be available$")
    public void nothingToDisplayMessageShouldBeAvailable() {
        MatcherAssert.assertThat("'Nothing to display' message is not available on the page", homePage.isErrorTableMessageDisplayed());
    }
}
