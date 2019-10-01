package stepdefs;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;

import ApplicationPages.Blogpage;
import io.cucumber.java.en.And;
import listeners.ExtentReportListener;

public class BlogPageSteps  extends ExtentReportListener {
    private Blogpage blogPage;

    public BlogPageSteps() {
        this.blogPage = new Blogpage();
    }
    
    @And("^User verify that Blog page title is displayed$")
    public void blogPageIsDisplayed() throws Exception {
    	ExtentTest logInfo=null;
    	try {
    		logInfo=test.createNode(new GherkinKeyword("And"), "verify that Blog Page Title is displayed");
    		this.blogPage.verifyPageTitle();
    		logInfo.pass("Blog Page Title is displayed");
            logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
    } catch (AssertionError | Exception e) {
        testStepHandle("FAIL",driver,logInfo,e);            
    }
    }
}