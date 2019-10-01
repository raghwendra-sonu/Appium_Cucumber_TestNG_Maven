package stepdefs;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import ApplicationPages.Homepage;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import listeners.ExtentReportListener;

public class HomePageSteps extends ExtentReportListener {
	private Homepage homePage;  
	public HomePageSteps() {
		this.homePage = new Homepage();
	}

	@BeforeStep
	public void beforeStep() throws InterruptedException {
		Thread.sleep(2000);
	}

	@Given("^User navigates to QATechTesting HomePage$")
	public void aUserNavigatesToHomePage() throws InvalidFormatException, IOException, ClassNotFoundException {
		ExtentTest logInfo=null;
		try {
			test = extent.createTest(Feature.class, "Home Page Verifications");                         
			test=test.createNode(Scenario.class, " Check Home page is displayed");                       
			logInfo=test.createNode(new GherkinKeyword("Given"), "User navigates to QATechTesting HomePage");
			this.homePage.goToHomePage();
			logInfo.pass("Opened chrome browser and navigated to Homepage");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));   
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);            
		}
	}

	@Then("^User verify that Blog Link is displayed$")
	public void googleLogoIsDisplayed() throws Exception {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "verify that Blog Link is displayed");
			this.homePage.checkBlogLinkDisplay();
			logInfo.pass("Blog Link is displayed");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);            
		}
	}
}
