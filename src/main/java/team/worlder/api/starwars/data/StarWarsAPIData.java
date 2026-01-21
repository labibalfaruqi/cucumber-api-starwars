package team.worlder.api.starwars.data;

import lombok.Data;
import org.springframework.stereotype.Component;
import team.worlder.api.starwars.models.response.FilmsResponse;
import team.worlder.api.starwars.models.response.VehiclesResponse;

import java.util.List;

@Data
@Component("team.worlder.api.starwars.data.StarWarsAPIData")
public class StarWarsAPIData {
  //response
  public List<FilmsResponse> filmsResponseList;
  public List<VehiclesResponse> vehiclesResponseList;

  //request
  private Integer id;

  //data
  private String parameter;
}
