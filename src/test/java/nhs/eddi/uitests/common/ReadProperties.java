package nhs.eddi.uitests.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
  Properties prop = new Properties();

  /** read the properties file.
     *
  */
  public ReadProperties() {
    try {
      InputStream prop =
          new FileInputStream("src/test/java/nhs/eddi/uitests/resources/selenium.properties");
      this.prop.load(prop);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public String getLoginUrl() {
    return prop.getProperty("server.url");
  }
}
