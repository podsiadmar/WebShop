package BDD.cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= "src/main/java/BDD/features/",
        glue= "stepDefinition"
)
public class TestRunner {

}
