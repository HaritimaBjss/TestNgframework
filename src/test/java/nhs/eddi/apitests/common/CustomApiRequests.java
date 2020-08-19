package nhs.eddi.apitests.common;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class CustomApiRequests {
  private static final Logger LOGGER = LoggerFactory.getLogger(CustomApiRequests.class);
  private Response response;

  /**
   * get header
   *
   // * @param apiKey authToken
   * @return header
   */
  public Map<String, String> getHeaders() {
    return Map.of(
      "Connection", "keep-alive",
      "Content-Type", "application/json"
      //"Authorization", String.format("Bearer %s", apiKey)
    );
  }

  /**
   * post request.
   *
   * @param json   body
   * @param url    for API
   * @param apiKey authToken
   * @return response body in string
   */
  public Response postMethod(String json, String url, String apiKey) {
    try {
      response = RestAssured
        .given()
      //  .headers(this.getHeaders(apiKey))
        .baseUri(url)
        .body(json)
        .post();
    } catch (Exception e) {
      LOGGER.error(e.getMessage());
    }
    assertThat(response.getBody().asString(), is(notNullValue()));
    return response;
  }

  /**
   * get Method.
   *
   * @param url    for API
   // * @param apiKey authtoken
   * @return response body as string
   */
  public Response getMethod(String url) {
    try {
      response = RestAssured
        .given()
        .get(url);
      // JsonPath test = response.jsonPath();
      // LOGGER.info(test.get("id").toString());
      // LOGGER.info(responsebody.asString());
    } catch (Exception e) {
      LOGGER.error(e.getMessage());
    }
    // assertThat(response.getBody().asString(), is(notNullValue()));
    return response;
  }


}
