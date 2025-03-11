import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class VatCalculatorSteps {

    private WebDriver driver;

    @Given("I am on the VAT Calculator page")
    public void iAmOnTheVATCalculatorPage() {
        System.setProperty("web driver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.calkoo.com/en/vat-calculator");
    }

    @When("I enter {string} into the Gross Amount field")
    public void iEnterIntoTheGrossAmountField(String grossAmount) {
        WebElement grossAmountField = driver.findElement(By.id("Price"));
        grossAmountField.clear();
        grossAmountField.sendKeys(grossAmount);
    }

    @When("I enter {string} into the Net Amount field")
    public void iEnterIntoTheNetAmountField(String netAmount) {
        WebElement netAmountField = driver.findElement(By.id("NetPrice"));
        netAmountField.clear();
        netAmountField.sendKeys(netAmount);
    }

    @When("I enter {string} into the Vat Amount field")
    public void iEnterIntoTheVatAmountField(String vatAmount) {
        WebElement vatAmountField = driver.findElement(By.id("VATsum"));
        vatAmountField.clear();
        vatAmountField.sendKeys(vatAmount);
    }

    @When("I select {string} from the VAT Rate")
    public void iSelectFromTheVATRate(String vatRate) {
        Select vatRateRadio = new Select(driver.findElement(By.id("VAT_" + vatRate )));
        vatRateRadio.selectByVisibleText(vatRate);
    }

    @Then("the calculated VAT should be {string}")
    public void theCalculatedVATShouldBe(String expectedVat) {
        WebElement vatResultField = driver.findElement(By.id("VATsum"));
        String actualVat = vatResultField.getAttribute("value");
        Assert.assertEquals(actualVat, expectedVat);
    }

    @Then("the calculated Gross Amount should be {string}")
    public void theCalculatedGrossAmountShouldBe(String expectedGross) {
        WebElement grossResultField = driver.findElement(By.id("Price"));
        String actualGross = grossResultField.getAttribute("value");
        Assert.assertEquals(actualGross, expectedGross);
    }

    @Then("the calculated Net Amount should be {string}")
    public void theCalculatedNetAmountShouldBe(String expectedNet) {
        WebElement netResultField = driver.findElement(By.id("NetPrice"));
        String actualNet = netResultField.getAttribute("value");
        Assert.assertEquals(actualNet, expectedNet);
        driver.quit();
    }
}