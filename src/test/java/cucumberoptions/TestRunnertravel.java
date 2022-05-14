package cucumberoptions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.cucumber.core.gherkin.vintage.internal.gherkin.events.PickleEvent;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

//import org.junit.runner.RunWith;



//import cucumber.api.CucumberOptions;

//import org.junit.runner.RunWith;

//import cucumber.api.CucumberOptions;
//import cucumber.api.Scenario;

//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class) //comment this now it is integrate wid testng
@CucumberOptions(
		features="src/test/java/features", 
		glue= "stepDefinations", 
		dryRun=false, //check the definiton is define or not if not it will will display the method in console when it is set to true
		strict=true,//check defintion
		monochrome=true,// shwo error in readable format
		
		plugin= {"pretty","html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/cucumberTestReport.json","rerun:target/rerun.txt"},
		tags= {"@travel"}  //{"@sokeetest","@regTEst"}== means run tc conatins both tag
		)
public class TestRunnertravel extends AbstractTestNGCucumberTests {
	
	
		
	
	//{"@sokeetest","@regTEst"}== means run tc conatins both tag
	//{"@sokeetest,@regTEst"}== means run tc conatins either of the tag
	//{"~@sokeetest","@regTEst"}  ==meanss exculde somketest
	
	
	
	  private TestNGCucumberRunner testNGcucumberRuner;
	 @BeforeClass(alwaysRun=true) public void setUpClass() {
		 testNGcucumberRuner=new TestNGCucumberRunner(this.getClass()); }
		  
		/*
		 * @SuppressWarnings("unused")
		 * 
		 * @Test(groups = "cucumber", description = "Runs Cucumber Scenarios",
		 * dataProvider = "scenarios") public void runScenario(PickleWrapper
		 * pickleWrapper, FeatureWrapper featureWrapper) throws Throwable {
		 * testNGcucumberRuner.runScenario(pickleWrapper.getPickle()); }
		 */

		
		  @Test(dataProvider="features") 
		  @Parameters("browser")
		  public void feature(PickleWrapper	 eventWrapper,FeatureWrapper cucumberFeature) throws Throwable {
			  testNGcucumberRuner.runScenario(eventWrapper.getPickle());
		  
		  
		  }
		 
		
		  @DataProvider(parallel=true) 
		  public Object[][] features(){ 
			  return  testNGcucumberRuner.provideScenarios(); 
			  }
		 

		
		  @AfterClass(alwaysRun=true) public void teardownClass() {
		  testNGcucumberRuner.finish(); }
	 
	 
	
	
	/*
	 * @Override
	 * 
	 * @DataProvider(parallel = true) public Object[][] scenarios() { return
	 * super.scenarios(); }
	 */
	 
	 
	  
	  
	 
}	
	
// inhert this class to work testng and cumber integration
