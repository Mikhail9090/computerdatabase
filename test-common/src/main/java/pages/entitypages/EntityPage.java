package pages.entitypages;

import annotations.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.AbstractPage;

@PageObject
public class EntityPage extends AbstractPage {

    public EntityPage (WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.driver = webDriver;
    }

    @FindBy(id = "name")
    WebElement computerName;

    @FindBy(id = "introduced")
    WebElement introducedDate;

    @FindBy(id = "discontinued")
    WebElement discontinuedDate;

    @FindBy(id = "company")
    WebElement companyDropDown;

    @FindBy(xpath = "//div[@class='clearfix error']")
    WebElement validationFlag;

    @FindBy(xpath = "//a[text()='Cancel']")
    WebElement cancelBtn;

    public void specifyField(String fieldName, String fieldValue) {
        switch (fieldName) {
            case "Computer name":
                computerName.clear();
                computerName.sendKeys(fieldValue);
                break;
            case "Introduced date":
                introducedDate.clear();
                introducedDate.sendKeys(fieldValue);
                break;
            case "Discontinued date":
                discontinuedDate.clear();
                discontinuedDate.sendKeys(fieldValue);
                break;
            case "Company":
                selectValueInCompanyDropDown(fieldValue);
                break;
        }
    }

    private void selectValueInCompanyDropDown(String value) {
        if (value.equalsIgnoreCase("")) {
            companyDropDown.click();
            Select company = new Select(companyDropDown);
            company.selectByVisibleText("-- Choose a company --");
        } else {
            companyDropDown.click();
            Select company = new Select(companyDropDown);
            company.selectByVisibleText(value);
        }
    }

    public boolean isValidationFlagDisplayed() {
        return validationFlag.isDisplayed();
    }

    public void clickOnCancelBtn() {
        cancelBtn.click();
    }

    public String getComputerNameValue() {
        return computerName.getAttribute("value");
    }

    public String getIntroducedDateValue() {
        return introducedDate.getAttribute("value");
    }

    public String getDiscontinuedDateValue() {
        return discontinuedDate.getAttribute("value");
    }

    public String getCompanyValue() {
        Select company = new Select(companyDropDown);
        if (company.getFirstSelectedOption().getText().equalsIgnoreCase("-- Choose a company --")) {
            return "";
        }
        return company.getFirstSelectedOption().getText();
    }
}
