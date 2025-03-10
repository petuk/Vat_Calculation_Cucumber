import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import cucumber.api.junit.Cucumber;
@CucumberOptions(
        features = "src/test/resources/vat_calculator.feature",
        glue = "src/test/java/VatCalculatorSteps.java"
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}