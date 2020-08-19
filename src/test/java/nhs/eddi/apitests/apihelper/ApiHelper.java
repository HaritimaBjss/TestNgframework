package nhs.eddi.apitests.apihelper;

import io.restassured.response.Response;
import nhs.eddi.apitests.common.CustomApiRequests;

public class ApiHelper {

  private String apiUrl = "https://api.github.com/users/"; // (get URL from properties )

  private CustomApiRequests customApiRequests = new CustomApiRequests();
  private Response jsonResponse;

  public Response formatPostRequest(String json, String endpoint, String apiKey) {
    String url = apiUrl + endpoint;
    jsonResponse = customApiRequests.postMethod(json, url, apiKey);
    return jsonResponse;
  }

  public Response formatGetJsonRequest(String endpoint) {
    String url = apiUrl + endpoint;
    jsonResponse = customApiRequests.getMethod(url);
    return jsonResponse;
  }

/*  public String getAuthToken() {
  }*/
}
