package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Employee.feature",
        glue = "steps",
        plugin = {"pretty"},
        tags = "@employee"
)
public class EmployeeRunner {

}
