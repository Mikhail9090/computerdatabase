package pages.entitypages.editcomputerpage;

import annotations.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.context.annotation.Bean;
import pages.AbstractPage;
import pages.entitypages.EntityPage;

@PageObject
public class EditComputerPage extends EntityPage {

    public EditComputerPage (WebDriver driver) {
        super(driver);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @FindBy(xpath = "//input[@class='btn danger']")
    WebElement deleteBtn;

    public void clickOnDeleteBtn() {
        deleteBtn.click();
    }
}
