package nhs.eddi.apitests.apisteps;


import io.restassured.response.Response;
import nhs.eddi.apitests.apihelper.ApiHelper;

public class CountrySearchSteps {
  private Response response;
  private ApiHelper apiHelper = new ApiHelper();
  private String authToken;

  public Response searchCountryByCode(String code) {
    // authToken = apiHelper.getAuthToken();
    response = apiHelper.formatGetJsonRequest(code);
    return response;
  }
}
