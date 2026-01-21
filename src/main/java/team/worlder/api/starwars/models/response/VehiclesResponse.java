package team.worlder.api.starwars.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehiclesResponse {
  private String name;
  private String model;
  private String manufacturer;

  @JsonProperty("cost_in_credits")
  private String costInCredits;

  private String length;

  @JsonProperty("max_atmosphering_speed")
  private String maxAtmospheringSpeed;

  private String crew;
  private String passengers;

  @JsonProperty("cargo_capacity")
  private String cargoCapacity;
  private String consumables;

  @JsonProperty("vehicle_class")
  private String vehicleClass;

  private ArrayList<String> pilots;
  private ArrayList<String> films;

  private String created;
  private String edited;
  private String url;
}
