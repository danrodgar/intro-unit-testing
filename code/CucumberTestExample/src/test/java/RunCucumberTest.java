import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = "cucumber.glue", value = "steps")
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty,html:target/site/cucumber.html,json:target/cucumber/cucumber.json,junit:target/cucumber/cucumber.xml")
@ConfigurationParameter(key = "cucumber.execution.dry-run", value = "true")
@ConfigurationParameter(key = "cucumber.monochrome", value = "true")
public class RunCucumberTest {
}