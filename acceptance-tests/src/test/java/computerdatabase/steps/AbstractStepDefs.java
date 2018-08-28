package computerdatabase.steps;

import computerdatabase.configuration.AppConfig;
import configuration.WebdriverConfig;
import datacontainer.DataContainer;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.ContextConfiguration;
import pages.entitypages.addcomputerpage.AddComputerPage;
import pages.entitypages.editcomputerpage.EditComputerPage;
import pages.homepage.HomePage;

@ContextConfiguration(classes = {AppConfig.class})
public class AbstractStepDefs {

    @Autowired
    @Lazy
    public WebDriver driver;

    @Value("${server.url}")
    public String serverUrl;

    @Autowired
    @Lazy
    public DataContainer dataContainer;

    @Autowired
    @Lazy
    protected HomePage homePage;

    @Autowired
    @Lazy
    protected AddComputerPage addComputerPage;

    @Autowired
    @Lazy
    protected EditComputerPage editComputerPage;

    @After
    public void closeDriver() {
        //driver.close();
        driver.quit();
    }
}
