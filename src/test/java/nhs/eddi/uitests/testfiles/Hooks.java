package nhs.eddi.uitests.testfiles;

import nhs.eddi.uitests.common.TestContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;

import java.io.IOException;


public class Hooks {
  private static final Logger LOGGER = LoggerFactory.getLogger(Hooks.class);
  @AfterSuite
  public void afterScenario() throws IOException {
    WebDriver driver = TestContext.getInstance().getWebDriver();
    LOGGER.info("Cleanup browsers");
    TestContext.getInstance().closeAll();
  }
}
