package team.worlder.api.starwars.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import team.worlder.api.starwars.models.response.FilmsResponse;
import team.worlder.api.starwars.models.response.VehiclesResponse;
import team.worlder.api.starwars.properties.StarWarsAPIProperties;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component("team.worlder.api.starwars.services.FilmsController")
@Service
public class StarWarsAPIController {
  @Autowired
  StarWarsAPIProperties starWarsAPIProperties;

  public List<FilmsResponse> getFilms() {
    String url = starWarsAPIProperties.getUrl() + "films";
    log.info("Request Details:");
    log.info(" - URL: {}", url);
    log.info(" - Method: GET");
    try {
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      log.info("Response Details:");
      log.info(" - Status Code: {}", response.statusCode());
      log.info(" - Body: {}", response.body());

      ObjectMapper mapper = new ObjectMapper();
      FilmsResponse[] filmsArray = mapper.readValue(response.body(), FilmsResponse[].class);
      List<FilmsResponse> filmsList = Arrays.asList(filmsArray);
      log.info("Total Films Parsed: {}", filmsList.size());

      return filmsList;

    } catch (Exception e) {
      log.error("API Error at {}: {}", url, e.getMessage());
      return Collections.emptyList();
    }
  }

  public List<FilmsResponse> getSpecificFilms(Integer id) {
    String url = String.format("%sfilms/%d", starWarsAPIProperties.getUrl(), id);
    log.info("Request Details:");
    log.info(" - URL: {}", url);
    log.info(" - Method: GET");
    try {
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      log.info("Response Details:");
      log.info(" - Status Code: {}", response.statusCode());
      log.info(" - Body: {}", response.body());

      ObjectMapper mapper = new ObjectMapper();
      FilmsResponse filmsResponse = mapper.readValue(response.body(), FilmsResponse.class);
      List<FilmsResponse> filmsList = Collections.singletonList(filmsResponse);
      log.info("Total Films Parsed: {}", filmsList.size());

      return filmsList;

    } catch (Exception e) {
      log.error("API Error at {}: {}", url, e.getMessage());
      return Collections.emptyList();
    }
  }

  public List<VehiclesResponse> getVehicles() {
    String url = starWarsAPIProperties.getUrl() + "vehicles";
    log.info("Request Details:");
    log.info(" - URL: {}", url);
    log.info(" - Method: GET");
    try {
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      log.info("Response Details:");
      log.info(" - Status Code: {}", response.statusCode());
      log.info(" - Body: {}", response.body());

      ObjectMapper mapper = new ObjectMapper();
      VehiclesResponse[] vehiclesArray =
          mapper.readValue(response.body(), VehiclesResponse[].class);
      List<VehiclesResponse> VehiclesList = Arrays.asList(vehiclesArray);
      log.info("Total Vehicles Parsed: {}", VehiclesList.size());

      return VehiclesList;

    } catch (Exception e) {
      log.error("API Error at {}: {}", url, e.getMessage());
      return Collections.emptyList();
    }
  }

  public List<VehiclesResponse> getSpecificVehicles(Integer id) {
    String url = String.format("%svehicles/%d", starWarsAPIProperties.getUrl(), id);
    log.info("Request Details:");
    log.info(" - URL: {}", url);
    log.info(" - Method: GET");
    try {
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      log.info("Response Details:");
      log.info(" - Status Code: {}", response.statusCode());
      log.info(" - Body: {}", response.body());

      ObjectMapper mapper = new ObjectMapper();
      VehiclesResponse vehiclesResponse = mapper.readValue(response.body(), VehiclesResponse.class);
      List<VehiclesResponse> vehiclesList = Collections.singletonList(vehiclesResponse);
      log.info("Total Vehicles Parsed: {}", vehiclesList.size());

      return vehiclesList;

    } catch (Exception e) {
      log.error("API Error at {}: {}", url, e.getMessage());
      return Collections.emptyList();
    }
  }
}
