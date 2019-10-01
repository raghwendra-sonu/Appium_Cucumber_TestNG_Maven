package ApplicationPages;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import webconnector.WebConnector;

import static webconnector.WebConnector.driver;

import java.io.IOException;

public class Homepage {
	WebConnector wc=new WebConnector();

    public void goToHomePage() throws InvalidFormatException, IOException{
    	String URL=wc.getSpecificColumnData("./src/test/testdata/data.xlsx","sheet1", "URL");
        driver.get(URL);
        wc.waitForCondition("PageLoad","",60);
    }

    public void checkBlogLinkDisplay() {
    	try {
			wc.PerformActionOnElement("BlogLink_HomePage","Click","");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}