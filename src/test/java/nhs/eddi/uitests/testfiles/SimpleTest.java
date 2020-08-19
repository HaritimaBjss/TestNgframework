package nhs.eddi.uitests.testfiles;

import nhs.eddi.uitests.steplibrary.LandingStepLib;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public class SimpleTest {
  private static final Logger LOGGER = LoggerFactory.getLogger(SimpleTest.class);

  @Test
  public void searchGoogleTest(){
    LOGGER.info("Launch Google");
    LandingStepLib.getInstance().launchGoogle();
    LandingStepLib.getInstance().searchText("Bjss");
  }


}
