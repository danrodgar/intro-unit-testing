package uah;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

class PlaywrightExampleTest {

  @Test
  void testUniversityLandingPageTitle() {
    // Keep local/CI runs deterministic: enable browser tests explicitly.
    Assumptions.assumeTrue(
        Boolean.parseBoolean(System.getProperty("run.playwright", "false")),
        "Skipping Playwright browser test (set -Drun.playwright=true to run)");

    try (Playwright playwright = Playwright.create()) {
      Browser browser =
          playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
      Page page = browser.newPage();
      page.navigate("https://escuelapolitecnica.uah.es/");

      String title = page.title();
      assertTrue(title.toLowerCase().contains("escuela politécnica".toLowerCase()));

      browser.close();
    }
  }
}
