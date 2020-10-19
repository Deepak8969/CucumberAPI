package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},glue= {"stepDefinations"}, plugin= {"json:target/jsonReports/cucumber.json"})
public class TestRunner {

}
