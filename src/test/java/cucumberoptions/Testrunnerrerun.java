package cucumberoptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="@target/rerun.txt",
		glue= "stepDefinations", 
		dryRun=false, //check the definiton is define or not if not it will will display the method in console when it is set to true
		strict=true,//check defintion
		monochrome=true,// shwo error in readable format
		plugin= {"pretty","html:target1/cucumber-reports/cucumber-pretty",
				"json:target1/cucumber-reports/cucumberTestReport.json"},
		tags= {"@CRM or @automationpractice"}    //{"@sokeetest","@regTEst"}== means run tc conatins both tag
		)
public class Testrunnerrerun extends AbstractTestNGCucumberTests {
		

}
