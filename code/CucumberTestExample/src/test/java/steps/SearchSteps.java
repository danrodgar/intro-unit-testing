package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;

import java.net.URL;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SearchSteps {
    //private WebDriver driverChrome;
    private WebDriver driverFirefox;
    private Pattern pattern;
    private Screen screen = new Screen();

    //Establish the init page from which the program will start making the scenario
    @Given("the user is located in the index page")
    public void userIsInIndexPage() throws Throwable
    {
        /*WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driverChrome = new ChromeDriver(options);
        driverChrome.navigate().to("https://uah.es/es/");
        driverChrome.manage().window().maximize();
        driverChrome.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);*/

        driverFirefox = new FirefoxDriver();
        driverFirefox.navigate().to("https://uah.es/es/");
    }

    //Search for an element related with studies and click it
    @When("the user enters studies section")
    public void userEnterStudySection() throws Throwable
    {
        //driverChrome.findElement(By.linkText("ESTUDIOS")).click();
        driverFirefox.findElement(By.linkText("ESTUDIOS")).click();
    }

    //Search for an element related with degrees and click it
    @When("the user clicks in the degree section")
    public void userClickDegreesSection() throws Throwable
    {
        //driverChrome.findElement(By.linkText("Grados")).click();
        driverFirefox.findElement(By.linkText("Grados")).click();
    }

    //Search the button related to Covid-19 information
    @When("the user enters the Covid-19 information")
    public void userClickCovidInformation() throws Throwable
    {
        //A overlay screen will apear that asks you to take the screen shot
        // select the area you want to capture
        ScreenImage scrImgFile = screen.userCapture();

        //This method will save the file to the current directory
        String path = scrImgFile.getFile(".");

        //This will print the full path of the save file
        System.out.println(path);

        pattern = new Pattern(path);
        screen.click(pattern);
    }

    //Search the button related to EPS protocols
    @When("the user clicks at the Protocols from EPS")
    public void userClickProtocolsEPS() throws Throwable
    {
        Thread.sleep(2000);
        //A overlay screen will apear that asks you to take the screen shot
        // select the area you want to capture
        ScreenImage scrImgFile = screen.userCapture();

        //This method will save the file to the current directory
        String path = scrImgFile.getFile(".");

        //This will print the full path of the save file
        System.out.println(path);

        pattern = new Pattern(path);

        screen.click(pattern);
    }

    //Verify if the final page correspond to what it is look for
    @Then("the page with the degrees is shown")
    public void degreePage() throws Throwable
    {
        //String titleChrome = driverChrome.findElement(By.linkText("Grados")).getText();
        String titleFirefox = driverFirefox.findElement(By.linkText("Grados")).getText();
        //Assert.assertEquals(titleChrome, "Grados");
        Assertions.assertEquals("Grados", titleFirefox);
    }

    //Verify if the final page from EPS Covid-19 Information correspond to what it is look for
    @Then("the page from general information from UAH regarding Covid-19 is shown")
    public void EPSInformationCovidPage() throws Throwable
    {
        //String titleChrome = driverChrome.findElement(By.linkText("Escuela Politécnica Superior")).getText();
        String titleFirefox = driverFirefox.findElement(By.linkText("Escuela Politécnica Superior")).getText();
        //Assert.assertEquals(titleChrome, "Escuela Politécnica Superior");
        Assertions.assertEquals("Escuela Politécnica Superior", titleFirefox);
    }
}