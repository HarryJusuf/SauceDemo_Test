package SQATugasW6.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/SQATugasW6/cucumber/resources/features",
        glue = "src/test/java/SQATugasW6/cucumber/stepDef",
        plugin = {"html:target/HTML_report.html"}

)

public class runLogin {

}