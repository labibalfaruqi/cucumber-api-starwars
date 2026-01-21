package team.worlder.api.starwars;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.SpringFactory;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(objectFactory = SpringFactory.class,
    glue = "team.worlder.api.starwars.steps",
    features = "src/test/resources/features/",
    stepNotifications = true,
    tags = "@FilmsFeature or @VehiclesFeature")

public class AppTest {
}
