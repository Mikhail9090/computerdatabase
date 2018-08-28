package configuration;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static javaslang.API.Case;
import static javaslang.API.Match;

public class WebdriverConfig {
    private final String CHROME = "Chrome";
    private final String FIREFOX = "Firefox";

    @Value("${webdriver.browser:Firefox}")
    private String browserName;

    @Bean
    public WebDriver webDriver() throws IOException {
        return Match(browserName).of(
                Case(CHROME::equalsIgnoreCase, this::initChrome),
                Case(FIREFOX::equalsIgnoreCase, this::initFirefox)
        );
    }

    private WebDriver initFirefox() {
        FirefoxDriverManager.getInstance().arch32().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    private WebDriver initChrome() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
}
