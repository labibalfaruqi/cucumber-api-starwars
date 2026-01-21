package team.worlder.api.starwars.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "starwars-api")
public class StarWarsAPIProperties {
  private String url;
}
