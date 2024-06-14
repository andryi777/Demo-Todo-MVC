package demo.test.runner;

import org.junit.runner.RunWith;

//import io.cucumber.junit.CucumberOptions;

@RunWith(RunPersonalizar.class)

//@CucumberOptions(features = { "src/test/resources/features/" }, tags = "@THA-2", glue = { "demo" }, plugin = {
//		"pretty", "html:target/serenity-reports/serenity-html-report",
//		"json:target/serenity-reports/cucumber_report.json", "rerun:target/serenity-reports/rerun.txt" })

public class RunDemo {

	@RunBefore
	public static void previo() {

	}
}
