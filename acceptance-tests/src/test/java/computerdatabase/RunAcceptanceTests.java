package computerdatabase;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {
                "com.github.kirlionik.cucumberallure.AllureReporter",
                "html:target/cucumber-html-report"},
        //tags = {"@create", "@read", "@regression"}
        tags = {"~@Ignore"}
)
public class RunAcceptanceTests {
}

