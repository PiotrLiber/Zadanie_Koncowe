package Zadanie2;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import javax.naming.Name;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlightReservation {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/");
    }

    @Test

    public void FlightBookingFromWarsawToNewYork() throws IOException {

        //Klikam w button FLIGHTS
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement FlightsElement = driver.findElement(By.xpath
                          ("/html/body/div[5]/section/div[2]/div/div/div[2]/ul/li[2]/a/span"));
        WebElement ExpectedFlightsElement = wait.until((ExpectedConditions.elementToBeClickable(FlightsElement)));
        System.out.println("Taki text zawiera element Flights - " + FlightsElement.getText());
        ExpectedFlightsElement.click();

        //Wybor lotniska wylotowego
        // Szukam i Klikam w pole "Enter location"
        WebElement FlightFromElement = driver.findElement(By.id("s2id_origin"));
        FlightFromElement.click();

        //Szukam pola w ktore bede mogl wpisac nazwe lotniska wylotowego
        WebElement FlightFromInputElement = driver.findElement(By.xpath("/html/body/div[18]/div/input"));
        System.out.println("Atrybut button Flight - " + FlightFromInputElement.getAttribute("class"));
        FlightFromInputElement.sendKeys("warsaw");
        //Czekam az pojawi sie lista wyboru z lotniskiem i klikam w lotnisko w Warszawie
        WebElement ExpectedWarsawElement = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath
                                                                  ("/html/body/div[18]/ul/li[1]/div/span"))));
        System.out.println("Taki text zawiera wybrane lotnisko wylotowe - " + ExpectedWarsawElement.getText());
        ExpectedWarsawElement.click();

        //Wybor lotniska wylotowego
        // Szukam i Klikam w pole "Enter location"
        WebElement FlightDestinationElement = driver.findElement(By.id("s2id_destination"));
        FlightDestinationElement.click();


        //Szukam pola w ktore bede mogl wpisac nazwe lotniska docelowego
        WebElement FlightDestinationInputElement = driver.findElement(By.xpath("/html/body/div[19]/div/input"));
        FlightDestinationInputElement.sendKeys("new york");
        //Czekam az pojawi sie lista wyboru z lotniskiem i klikam w lotnisko w New York
        WebElement ExpectedNewYorkElement = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath
                                                                    ("/html/body/div[19]/ul/li/div/span"))));
        System.out.println("Taki text zawiera wybrane lotnisko docelowe - " + ExpectedNewYorkElement.getText());
        ExpectedNewYorkElement.click();

        // zaznaczam podroz tam i z powrotem
        WebElement RoundTrip = driver.findElement(By.xpath
                     ("/html/body/div[5]/section/div[2]/div/div/div[2]/div[1]/div[3]/form/div[9]/div[2]/div/div/ins "));
        RoundTrip.click();

        //okreslam date wylotu
        WebElement DepartureDate = driver.findElement(By.id("departure"));
        DepartureDate.click();
        DepartureDate.clear();
        DepartureDate.sendKeys("2019-08-18");

        //okreslam date powrotu
        WebElement ArrivalDate = driver.findElement(By.id("arrival"));
        ArrivalDate.click();
        ArrivalDate.clear();
        ArrivalDate.sendKeys("2019-08-28");

        //okreslam ilosc pasazerow
        WebElement PassengersElement = driver.findElement(By.xpath
                                ("/html/body/div[5]/section/div[2]/div/div/div[2]/div[1]/div[3]/form/div[5]/div/input"));
        PassengersElement.click();
        WebElement ExpectedDoneButtonToAcceptPassengers = wait.until((ExpectedConditions.visibilityOfElementLocated
                                                          (By.id("sumManualPassenger"))));
        ExpectedDoneButtonToAcceptPassengers.click();

        //klikam wyszukanie polaczen
        WebElement SearchElement = driver.findElement(By.xpath
                                  ("/html/body/div[5]/section/div[2]/div/div/div[2]/div[1]/div[3]/form/div[6]/button"));
        SearchElement.click();

        //klikam button 'BOOK NOW'
        WebElement ExpectedBookButtonElement = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath
                                  ("/html/body/div[5]/div[4]/div[2]/div[1]/div[1]/div[3]/form/div/button/span"))));
        ExpectedBookButtonElement.click();

        // wybieram Guest Booking
        WebElement ExpectedGuestBookingButtonElement = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("/html/body/div[5]/div[2]/div[1]/div[2]/div[2]/a"))));
        ExpectedGuestBookingButtonElement.click();

        // **************            wypelniam formularz z danymi       ***********************

        WebElement cookiebutton = driver.findElement(By.id("cookyGotItBtn"));
        cookiebutton.click();

                                          // Traveler Info
        // Name
        WebElement NameElement = driver.findElement(By.id("name"));
        System.out.println("Takie ma ID pole name - " + NameElement.getAttribute("id"));
        NameElement.sendKeys("Piotr");

        // Surname
       WebElement SurnameElement = driver.findElement(By.id("surname"));
       System.out.println("Takie ma ID pole surname - " + SurnameElement.getAttribute("id"));
       SurnameElement.sendKeys("Kwiatkowski");

       // Email

        List<WebElement> EmailElement = driver.findElements(By.id("email"));
        EmailElement.get(1).sendKeys("piotr@test.com");

        // phone
        WebElement PhoneElement = driver.findElement(By.id("phone"));
        System.out.println("Takie ma ID pole phone - " + PhoneElement.getAttribute("id"));
        PhoneElement.sendKeys("+48504474465");

        // birthday
        WebElement BirthdayElement = driver.findElement(By.id("birthday"));
        System.out.println("Takie ma ID pole birthday - " + BirthdayElement.getAttribute("id"));
        BirthdayElement.sendKeys("1978-03-03");

        // ID number
        WebElement IdNumberElement = driver.findElement(By.id("cardno"));
        System.out.println("Takie ma ID pole ID Number - " + IdNumberElement.getAttribute("id"));
        IdNumberElement.sendKeys("ANU132587");

        // expiration date
        WebElement ExpDateElement = driver.findElement(By.id("expiration"));
        System.out.println("Takie ma ID pole expiration date - " + ExpDateElement.getAttribute("id"));
        ExpDateElement.sendKeys("2021-01-05");

        // Szukam i Klikam w pole 'Nationality'
        WebElement Nationality = driver.findElement(By.xpath("/html/body/div[5]/form/div/div[1]/div[2]/section/div/div[9]/div/div/a"));
        Nationality.click();
                             // ************* Payment Information  ********************
        // Card Type

        WebElement CardType1 = driver.findElement(By.name("name_card"));
        System.out.println("Takie ma name pole card type - " + CardType1.getAttribute("name"));
        Select CardType = new Select(driver.findElement(By.id("cardtype")));
        CardType.selectByIndex(3);

        //card number
        WebElement CardNumberElement = driver.findElement(By.id("card-number"));
        System.out.println("Takie ma ID pole Card number - " + CardNumberElement.getAttribute("id"));
        CardNumberElement.sendKeys("4220409000032914");

        // Card Expire Date (Month)
        Select CardExpireMonth = new Select(driver.findElement(By.id("expiry-month")));
        CardExpireMonth.selectByIndex(4);

        // Card Expire Date (Year)
        Select CardExpireYear = new Select(driver.findElement(By.id("expiry-year")));
        CardExpireYear.selectByIndex(5);

        // CVV number
        WebElement CVVElement = driver.findElement(By.id("cvv"));
        System.out.println("Takie ma ID pole CVV  - " + CVVElement.getAttribute("id"));
        CVVElement.sendKeys("345");

        // screenshot

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
// Now you can do whatever you need to do with it, for example copy somewhere
        FileUtils.copyFile(scrFile, new File("./screenshot.png"));




    }

}
