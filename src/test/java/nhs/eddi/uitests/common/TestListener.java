package nhs.eddi.uitests.common;

import nhs.eddi.uitests.testfiles.Hooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {
  private static final Logger LOGGER = LoggerFactory.getLogger(TestListener.class);


  String filePath = "target\\Screenshots\\";
  
  @Override
  public void onTestFailure(ITestResult result) {
    Object currentClass = result.getInstance();
    WebDriver driver = ((Hooks) currentClass).getDriver();
   LOGGER.error(currentClass.toString());
    LOGGER.error("***** Error "+result.getName()+" test has failed *****");
    String methodName = result.getName().toString().trim();
    ITestContext context = result.getTestContext();
    // WebDriver driver = (WebDriver)context.getAttribute("driver");
    takeScreenShot(methodName, driver);
  }

  private void takeScreenShot(String methodName, WebDriver driver) {
    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    //The below method will save the screen shot in d drive with test method name
    String path = filePath+methodName+".png";
    LOGGER.info(path);
    try {
      FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
      LOGGER.info("***Placed screen shot in "+filePath+" ***");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
