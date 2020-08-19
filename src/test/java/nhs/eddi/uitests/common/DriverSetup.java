package nhs.eddi.uitests.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverSetup {
  private static final Logger LOGGER = LoggerFactory.getLogger(DriverSetup.class);
  private static DriverSetup driverSetup = new DriverSetup();

  private DriverSetup() {

  }

  public static DriverSetup getInstance() {
    return driverSetup;
  }

  public WebDriver getDriver() {
    try {
      setupChromeDriverBinary();
      final ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.setAcceptInsecureCerts(true);
      chromeOptions.addArguments(
          "--ignore-certificate-errors",
          "--disable-download-notification",
          "--no-sandbox",
          "--disable-gpu");
      if (SystemUtils.IS_OS_LINUX) {
        chromeOptions.addArguments(
            "--headless",
            "--allow-running-insecure-content",
            "--disable-web-security");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.acceptInsecureCerts();
      } else if (SystemUtils.IS_OS_MAC || SystemUtils.IS_OS_WINDOWS) {
        chromeOptions.addArguments(
            "--incognito",
            "--start-fullscreen");
      }
      return new ChromeDriver(ChromeDriverService.createDefaultService(), chromeOptions);
    } catch (UnreachableBrowserException e) {
      LOGGER.info("Error due to " + e.getMessage());
      throw new UnreachableBrowserException(e.getMessage());
    }

  }

  private void setupChromeDriverBinary() {
    try {
      if (SystemUtils.IS_OS_MAC || SystemUtils.IS_OS_WINDOWS || SystemUtils.IS_OS_LINUX) {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriverManager.chromedriver().setup();
      }else {
        System.getenv();
      }
    } catch (Exception e) {
      LOGGER.info("Driver Binary not setup correctly...");
      e.printStackTrace();
    }
  }

}
