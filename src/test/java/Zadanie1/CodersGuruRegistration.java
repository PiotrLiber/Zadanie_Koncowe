package Zadanie1;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class CodersGuruRegistration {

    private WebDriver driver;

    String LoginName;

    @Given("^an open browser on Coders Guru main page https://tester\\.codersguru\\.pl/$")
    public void anOpenBrowserOnCodersGuruMainPageHttpsTesterCodersguruPl() {
        System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://tester.codersguru.pl");
    }

    @When("^button 'Załóż konto' is clicked$")
    public void buttonZałóżKontoIsClicked() {
        WebElement ZalozKontoElement = driver.findElement(By.xpath("/html/body/section[3]/div/form/input[2]"));
        ZalozKontoElement.click();
    }

    @Then("^new page with text 'Zarejestruj się' is appeared$")
    public void newPageWithTextZarejestrujSięIsAppeared() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement ZarejestrujSieElement = driver.findElement(By.xpath("/html/body/div/div/h1"));
        WebElement ExpectedText = wait.until((ExpectedConditions.visibilityOf(ZarejestrujSieElement)));
        System.out.println("Taki text zawiera element Zarejestruj sie - " + ZarejestrujSieElement.getText());

    }

    @When("^button 'Prywatnie' is clicked$")
    public void buttonPrywatnieIsClicked() {
        WebElement PrivateAccountElement = driver.findElement(By.id("person"));
        PrivateAccountElement.click();
        System.out.println("Taki text zawiera element Prywatnie - " + PrivateAccountElement.getText());

    }

    @And("^enter e-mail adress \"([^\"]*)\" in 'E-mail' field$")
    public void enterEMailAdressInEMailField(String arg0) {
        WebElement EmailAdressElement = driver.findElement(By.id("fos_user_registration_form_email"));
        EmailAdressElement.click();
        EmailAdressElement.sendKeys(arg0);

    }

    @And("^enter name \"([^\"]*)\" in 'Imię' field$")
    public void enterNameInImięField(String name) {
        WebElement NameElement = driver.findElement(By.id("fos_user_registration_form_name"));
        NameElement.click();
        NameElement.sendKeys(name);
    }

    @And("^enter surname \"([^\"]*)\" in 'Nazwisko' field$")
    public void enterSurnameInNazwiskoField(String arg0) {
        WebElement LastNameElement = driver.findElement(By.id("fos_user_registration_form_lastname"));
        LastNameElement.click();
       LastNameElement.sendKeys(arg0);

    }

    @And("^enter password \"([^\"]*)\" in 'Hasło' field$")
    public void enterPasswordInHasłoField(String arg0) {
        WebElement PasswordElement = driver.findElement(By.id("fos_user_registration_form_plainPassword_first"));
        PasswordElement.click();
        PasswordElement.sendKeys(arg0);
    }

    @And("^re-enter password \"([^\"]*)\" in 'Powtórz hasło' field$")
    public void reEnterPasswordInPowtórzHasłoField(String arg0) {
        WebElement RepeatPasswordElement = driver.findElement(By.id("fos_user_registration_form_plainPassword_second"));
        RepeatPasswordElement.click();
        RepeatPasswordElement.sendKeys(arg0);
    }

    @And("^enter city \"([^\"]*)\" in 'Miasto' field$")
    public void enterCityInMiastoField(String arg0) {
        WebElement CityElement = driver.findElement(By.id("form_city"));
        CityElement.click();
        CityElement.sendKeys(arg0);

    }

    @And("^enter zip code \"([^\"]*)\" in 'Kod pocztowy' field$")
    public void enterZipCodeInKodPocztowyField(String arg0) {
        WebElement ZipCodeElement = driver.findElement(By.id("form_postal_code"));
        ZipCodeElement.click();
        ZipCodeElement.sendKeys(arg0);
    }

    @And("^enter street name \"([^\"]*)\" in 'Ulica' field$")
    public void enterStreetNameInUlicaField(String arg0) {
        WebElement StreetNameElement = driver.findElement(By.id("form_street"));
        StreetNameElement.click();
        StreetNameElement.sendKeys(arg0);
    }

    @And("^enter house number \"([^\"]*)\" in 'Numer domu/lokalu' field$")
    public void enterHouseNumberInNumerDomuLokaluField(String arg0) {
        WebElement HouseNumberElement = driver.findElement(By.id("form_number"));
        HouseNumberElement.click();
        HouseNumberElement.sendKeys(arg0);
    }

    @And("^click checkbox 'Zapoznałem się z Regulaminem'$")
    public void clickCheckboxZapoznałemSięZRegulaminem() {
        WebElement AcceptRegulationsElement = driver.findElement(By.xpath("/html/body/div/div/div/form/div[12]/input"));
        AcceptRegulationsElement.click();

    }

    @And("^button 'Zarejestruj' is clicked$")
    public void buttonZarejestrujIsClicked() {
        WebElement RegisterButtonElement = driver.findElement(By.id("register-submit-btn"));
        RegisterButtonElement.click();

    }


    @Then("^new page is opened with \"([^\"]*)\" in the upper right corner$")
    public void newPageIsOpenedWithInTheUpperRightCorner(String LoginName) {
        WebElement UserNameElement = driver.findElement(By.id("user-name"));
        String RegisterUserName = UserNameElement.getText();
        assertEquals(LoginName, RegisterUserName);
        System.out.println("Taki jest login name " + LoginName);






    }
}
