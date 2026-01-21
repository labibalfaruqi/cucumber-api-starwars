package team.worlder.api.starwars.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmsResponse {
  private String title;

  @JsonProperty("episode_id")
  private String episodeId;

  @JsonProperty("opening_crawl")
  private String openingCrawl;

  private String director;

  private String producer;

  @JsonProperty("release_date")
  private String releaseDate;

  private ArrayList<String> characters;

  private ArrayList<String> planets;

  private ArrayList<String> starships;

  private ArrayList<String> vehicles;

  private ArrayList<String> species;

  private String created;

  private String edited;

  private String url;
}
