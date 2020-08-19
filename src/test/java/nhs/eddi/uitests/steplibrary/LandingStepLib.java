package nhs.eddi.uitests.steplibrary;

import nhs.eddi.uitests.common.ReadProperties;
import nhs.eddi.uitests.common.TestContext;
import nhs.eddi.uitests.pageobjects.LandingPage;

public class LandingStepLib {
  private static LandingStepLib landingStepLib = new LandingStepLib();
  private LandingPage landingPage;

  private LandingStepLib() {
    landingPage = LandingPage.getInstance();
  }

  public static LandingStepLib getInstance() {
    return landingStepLib;
  }

  public void launchGoogle() {
    landingPage.getUrl(ReadProperties.getInstance().getLoginUrl());
  }

  public void searchText(String bjss) {
    landingPage.sendText(bjss);
  }

}
