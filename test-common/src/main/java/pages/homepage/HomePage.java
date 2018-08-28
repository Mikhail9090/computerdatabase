package pages.homepage;

import annotations.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.AbstractPage;

@PageObject
public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "add")
    WebElement addComputerBtn;

    @FindBy(className = "alert-message")
    WebElement warningMessage;

    @FindBy(xpath = "//section[@id='main']/h1")
    WebElement computerCounter;

    @FindBy(id = "searchbox")
    WebElement searchInput;

    @FindBy(id = "searchsubmit")
    WebElement searchBtn;

    @FindBy(xpath = "//li[@class='current']/a")
    WebElement tableCounter;

    @FindBy(tagName = "em")
    WebElement errorTableMessage;

    public void open() {
        driver.get(serverUrl);
    }

    public void clickOnAddNewComputerBtn() {
        addComputerBtn.click();
    }

    public String getTextFromCounterBar() {
        return computerCounter.getText();
    }

    public String getTextFromWarningMessage() {
        return warningMessage.getText();
    }

    public int getComputerNumber() {
        return Integer.parseInt(computerCounter.getText().replace(" computers found", ""));
    }

    public boolean isPageDisplayed() {
        return isPageDisplayed(serverUrl);
    }

    public void performSearch(String value) {
        searchInput.click();
        searchInput.sendKeys(value);
        searchBtn.click();
    }

    public String getTextFromTableCounter() {
        return tableCounter.getText();
    }

    public void openTheDisplayedCompanyInTheTable(String companyName) {
        driver.findElement(By.xpath("//a[text()='" + companyName + "']")).click();
    }

    public boolean isErrorTableMessageDisplayed() {
        return errorTableMessage.isDisplayed();
    }
}
