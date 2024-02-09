package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (

        features="src/test/resources",
        glue= {"stepdefinitions","hooks"},
        tags="@grid_features",
        dryRun= false  //true yaparsak eksik olan stepdefinitionları görürüz
)


public class RunnerGrid {

}