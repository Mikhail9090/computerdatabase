package pages.entitypages.addcomputerpage;

import annotations.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.entitypages.EntityPage;

@PageObject
public class AddComputerPage extends EntityPage {
    private final String PAGE_URL = "/new";

    public AddComputerPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[text()='Add a computer']")
    WebElement pageTitle;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement createComputerBtn;

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public void clickOnCreateComputerBtn() {
        createComputerBtn.click();
    }

    public boolean isPageDisplayed() {
        return isPageDisplayed(PAGE_URL);
    }
}
