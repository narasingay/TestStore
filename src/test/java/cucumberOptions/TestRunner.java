package cucumberOptions;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "stepDefinations", tags = "@Validateproducttdetails", dryRun = false, monochrome = true, strict = true, plugin = {
		"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "html:target/cucumber-report.html", 
		"json:target/report2.json", "junit:target/report3.xml" })

public class TestRunner {

	
}
