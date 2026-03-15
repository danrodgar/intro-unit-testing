package uah;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assumptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestClass {

  @Test
  public void testInitial() {
    Assumptions.assumeTrue(
        Boolean.parseBoolean(System.getProperty("run.selenium", "false")),
        "Skipping Selenium test: set -Drun.selenium=true to run");
    WebDriver driver = new FirefoxDriver();
    driver.get("https://escuelapolitecnica.uah.es/");
    driver.quit();
  }
}
