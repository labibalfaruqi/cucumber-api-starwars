package team.worlder.api.starwars.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import team.worlder.api.starwars.data.StarWarsAPIData;
import team.worlder.api.starwars.models.response.FilmsResponse;
import team.worlder.api.starwars.models.response.VehiclesResponse;
import team.worlder.api.starwars.properties.StarWarsAPIProperties;
import team.worlder.api.starwars.services.StarWarsAPIController;

@Slf4j
public class StarWarsAPISteps {
  // properties
  @Autowired
  StarWarsAPIProperties starWarsAPIProperties;

  // data
  @Autowired
  StarWarsAPIData starWarsAPIData;

  // controller
  @Autowired
  StarWarsAPIController starWarsAPIController;

  @Given("prepare get all {string} data")
  public void prepareGetAllData(String parameter) {
    log.info("Step: prepare get all {} data", parameter);
    starWarsAPIData.setParameter(parameter);
    starWarsAPIData.setId(null);
    starWarsAPIData.setFilmsResponseList(null);
    starWarsAPIData.setVehiclesResponseList(null);
  }

  @When("send get all {string} data")
  public void sendGetAllData(String parameter) {
    log.info("Step: send get all {} data", starWarsAPIData.getParameter());
    switch (starWarsAPIData.getParameter()) {
      case "films":
        starWarsAPIData.setFilmsResponseList(starWarsAPIController.getFilms());
        break;
      case "vehicles":
        starWarsAPIData.setVehiclesResponseList(starWarsAPIController.getVehicles());
        break;
    }
  }

  @Given("prepare get specific {string} data with id {}")
  public void prepareGetSpecificDataWithId(String parameter, Integer id) {
    log.info("Step: prepare get all {} data", parameter);
    starWarsAPIData.setParameter(parameter);
    starWarsAPIData.setId(id);
    starWarsAPIData.setFilmsResponseList(null);
    starWarsAPIData.setVehiclesResponseList(null);
  }

  @When("send get specific {string} data")
  public void sendGetSpecificFilmsData(String parameter) {
    log.info("Step: send get all {} data", starWarsAPIData.getParameter());
    switch (starWarsAPIData.getParameter()) {
      case "films":
        starWarsAPIData.setFilmsResponseList(starWarsAPIController.getSpecificFilms(starWarsAPIData.getId()));
        break;
      case "vehicles":
        starWarsAPIData.setVehiclesResponseList(starWarsAPIController.getSpecificVehicles(
            starWarsAPIData.getId()));
        break;
    }
  }

  @Then("verify {string} for id number {string} is {string}")
  public void verifyFieldForIdNumberIsValue(String field, String id, String expectedValue) {
    log.info("Step: verify '{}' for id number '{}' is '{}'", field, id, expectedValue);

    String url = String.format("%s%s/%s",
        starWarsAPIProperties.getUrl(),
        starWarsAPIData.getParameter(),
        id);

    switch (starWarsAPIData.getParameter()) {
      case "films":
        FilmsResponse filmsResponse =
            starWarsAPIData.getFilmsResponseList()
                .stream()
                .filter(f -> f.getUrl().equals(url))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Film with URL " + url + " not found"));
        switch (field) {
          case "title" -> Assert.assertEquals(expectedValue, filmsResponse.getTitle());
          case "episodeId" -> Assert.assertEquals(expectedValue, filmsResponse.getEpisodeId());
          case "director" -> Assert.assertEquals(expectedValue, filmsResponse.getDirector());
          case "producer" -> Assert.assertEquals(expectedValue, filmsResponse.getProducer());
          case "releaseDate" -> Assert.assertEquals(expectedValue, filmsResponse.getReleaseDate());
          default -> throw new IllegalArgumentException("Unknown field: " + field);
        }
        break;
      case "vehicles":
        VehiclesResponse vehiclesResponse =
            starWarsAPIData.getVehiclesResponseList()
                .stream()
                .filter(f -> f.getUrl().equals(url))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Film with URL " + url + " not found"));
        switch (field) {
          case "name" -> Assert.assertEquals(expectedValue, vehiclesResponse.getName());
          case "model" -> Assert.assertEquals(expectedValue, vehiclesResponse.getModel());
          case "manufacturer" ->
              Assert.assertEquals(expectedValue, vehiclesResponse.getManufacturer());
          case "costInCredits" ->
              Assert.assertEquals(expectedValue, vehiclesResponse.getCostInCredits());
          case "length" -> Assert.assertEquals(expectedValue, vehiclesResponse.getLength());
          case "maxAtmospheringSpeed" ->
              Assert.assertEquals(expectedValue, vehiclesResponse.getMaxAtmospheringSpeed());
          case "crew" -> Assert.assertEquals(expectedValue, vehiclesResponse.getCrew());
          case "passengers" -> Assert.assertEquals(expectedValue, vehiclesResponse.getPassengers());
          case "cargoCapacity" ->
              Assert.assertEquals(expectedValue, vehiclesResponse.getCargoCapacity());
          case "consumables" ->
              Assert.assertEquals(expectedValue, vehiclesResponse.getConsumables());
          case "vehicleClass" ->
              Assert.assertEquals(expectedValue, vehiclesResponse.getVehicleClass());
          default -> throw new IllegalArgumentException("Unknown field: " + field);
        }
        break;
    }
  }
}
