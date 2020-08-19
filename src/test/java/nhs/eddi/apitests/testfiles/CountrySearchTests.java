package nhs.eddi.apitests.testfiles;

import io.restassured.response.Response;
import nhs.eddi.apitests.apisteps.CountrySearchSteps;
import org.testng.annotations.Test;

public class CountrySearchTests {

  CountrySearchSteps countrySearchSteps = new CountrySearchSteps();

  @Test
  public void verifyThatWeCanFindUnitedStatesOfAmericaUsingTheCodeUS() {
    Response response = countrySearchSteps.searchCountryByCode("eugenp");
  }
}