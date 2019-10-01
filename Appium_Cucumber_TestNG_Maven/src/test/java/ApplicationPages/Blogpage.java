package ApplicationPages;

import webconnector.WebConnector;

public class Blogpage {
	WebConnector wc=new WebConnector();

	public void verifyPageTitle() {
    	try {
    		wc.PerformActionOnElement("RecentPosts_BlogPage","WaitForElementDisplay","");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}