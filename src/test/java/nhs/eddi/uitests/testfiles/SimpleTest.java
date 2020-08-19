package nhs.eddi.uitests.testfiles;

import nhs.eddi.uitests.steplibrary.LandingStepLib;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SimpleTest extends Hooks {
  private static final Logger LOGGER = LoggerFactory.getLogger(SimpleTest.class);
  LandingStepLib landingStepLib = LandingStepLib.getInstance();

  @Test(description = "Simple test to search BJSS", groups = "Regression")
  public void searchGoogleTest() {
    LOGGER.info("Launch Google");
    landingStepLib.launchGoogle();
    landingStepLib.searchText("Bjss");
    Assert.fail("Assert fail");
  }


}
