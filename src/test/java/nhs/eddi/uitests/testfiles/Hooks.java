package nhs.eddi.uitests.testfiles;

import nhs.eddi.uitests.common.TestContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class Hooks {
  private static final Logger LOGGER = LoggerFactory.getLogger(Hooks.class);
  public WebDriver driver;

  public WebDriver getDriver() {
    return driver;
  }

  @BeforeMethod(alwaysRun = true)
  public void initialiseDriver() {
    driver = TestContext.getInstance().getWebDriver();
  }

  /** Test Data and browser cleanup method.
   *
   */
  @AfterMethod(alwaysRun = true)
  public void afterScenario() {
    driver = TestContext.getInstance().getWebDriver();
    LOGGER.info("Cleanup browsers");
    TestContext.getInstance().closeAll();
  }
}
