package testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(    features = "src/test/resources/Features",
    glue = {"Stepdefinition"},
    plugin={"pretty","html:target/htmlReporting/cucumber-reports.html", "json:target/jsonReports/cucumber.json"},
    // tags = "@deletePlace",
    monochrome = true
)
public class PlaceValidationTest {

}


// mvn test -Dcucumber.filter.tags="@addPlace"