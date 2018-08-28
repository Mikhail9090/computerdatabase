package pages;

import datacontainer.DataContainer;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;

public class AbstractPage {

    @Value("${server.url}")
    public String serverUrl;

    @Autowired
    @Lazy
    public WebDriver driver;

    @Autowired
    @Lazy
    public DataContainer dataContainer;

    public boolean isPageDisplayed(String url) {
        if (!url.equalsIgnoreCase(serverUrl)) {
            return driver.getCurrentUrl().equalsIgnoreCase(serverUrl + url);
        }
        return driver.getCurrentUrl().equalsIgnoreCase(serverUrl);
    }
}
