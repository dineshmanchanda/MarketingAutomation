package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ListCampaignPage;
import pageObjects.NavigationBarPage;
import pageObjects.loginPage;
import testBase.BaseClass;

public class TC01_CreateCampaignPage extends BaseClass {

	loginPage lp;
	NavigationBarPage nav;
	ListCampaignPage list;

	@Test(priority = 1, groups={"Sanity", "Master"})
	public void loginVerify() {

		lp = new loginPage(driver);
		logger.info("Starting login verification test");
		try {
			logger.info("Opening the Login Page");
			logger.info("Entering the Username on Login Page");
			lp.login_username(p.getProperty("username"));
			logger.info("Entering the Password on Login Page");
			lp.login_password(p.getProperty("password"));
			logger.info("Clicking on the Login Button");
			lp.login_button();

			String homePageText = lp.home_Page_Confirmation();
			Assert.assertEquals(homePageText, "Inbox", "Home page title mismatch!");

			logger.info("Login verification test passed");

		} catch (Exception e) {
			logger.error("Login verification test failed", e);
			Assert.fail("Exception during login verification: " + e.getMessage());
		}

	}

	@Test(priority = 2, dependsOnMethods = { "loginVerify" }, groups = {"Regression","Master"})

	public void clickingCampaignNavigation() {

		nav = new NavigationBarPage(driver);
		logger.info("Starting clicking on Campaign in navigation test");

		try {
			logger.info("Clicked on Campaign in Navigation");
			nav.nav_campaign();

			list = new ListCampaignPage(driver);
			String emailCampaignText = list.list_emailCampaignText();
			Assert.assertEquals(emailCampaignText, "Email Campaigns", "Text doesn't Matches");
			logger.info("Clicking Campaign test passed");

		} catch (Exception e) {
			logger.error("Clicking Campaign in Navigation test failed", e);
			Assert.fail("Exception during clicking Navigation: " + e.getMessage());
		}

	}

}
