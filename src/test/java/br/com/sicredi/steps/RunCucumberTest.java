package br.com.sicredi.steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/br/com/sicredi/features",
        glue = "br/com/sicredi/steps"
)
public class RunCucumberTest {
}
