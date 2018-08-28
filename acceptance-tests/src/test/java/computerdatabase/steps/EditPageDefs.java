package computerdatabase.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.CoreMatchers.equalTo;

public class EditPageDefs extends AbstractStepDefs {

    @Then("^The Edit page should be open$")
    public void theEditPageShouldBeOpen() {
        int computerId = (Integer) dataContainer.getValueFromTestStorage("COMPUTER_NUMBER") + 1;
        MatcherAssert.assertThat("The Edit Page has bot been open", editComputerPage.getCurrentUrl(), equalTo(serverUrl + "/" + String.valueOf(computerId)));
    }

    @Then("^'Computer Name' field has the correct value$")
    public void computeNameFieldHasTheCorrectValue() {
        MatcherAssert.assertThat("The 'Computer Name' value is not correct", editComputerPage.getComputerNameValue(), equalTo(dataContainer.getValueFromTestStorage("Computer name")));
    }

    @Then("^'Introduced date' field has the correct value$")
    public void introducedDateFieldHasTheCorrectValue() {
        MatcherAssert.assertThat("The 'Computer Name' value is not correct", editComputerPage.getIntroducedDateValue(), equalTo(dataContainer.getValueFromTestStorage("Introduced date")));
    }

    @Then("^'Discontinued date' field has the correct value$")
    public void discontinuedDateFieldHasTheCorrectValue() {
        MatcherAssert.assertThat("The 'Computer Name' value is not correct", editComputerPage.getDiscontinuedDateValue(), equalTo(dataContainer.getValueFromTestStorage("Discontinued date")));
    }

    @Then("^'Company' field has the correct value$")
    public void computeFieldHasTheCorrectValue() {
        MatcherAssert.assertThat("The 'Computer Name' value is not correct", editComputerPage.getCompanyValue(), equalTo(dataContainer.getValueFromTestStorage("Company")));
    }

    @When("^I click on the 'Delete' button$")
    public void iClickOnTheDeleteBtn() {
        editComputerPage.clickOnDeleteBtn();
    }
}
