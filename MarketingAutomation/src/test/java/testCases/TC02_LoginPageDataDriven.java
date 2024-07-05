package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.NavigationBarPage;
import pageObjects.loginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC02_LoginPageDataDriven extends BaseClass {
	loginPage lp;
	NavigationBarPage nav;

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = { "DataDriven", "Master" })
	public void loginDataDriven(String email, String pwd, String exp) {

		lp = new loginPage(driver);
		logger.info("Starting login verification test");

		try {
			nav = new NavigationBarPage(driver);
			logger.info("Opening the Login Page");

			lp.login_username_clear();
			lp.login_password_clear();
			logger.info("Entering the Username on Login Page");
			lp.login_username(email);
			logger.info("Entering the Password on Login Page");
			lp.login_password(pwd);
			logger.info("Clicking on the Login Button");
			lp.login_button();

			boolean targetPage = lp.isMyHomePageExists();

			if (exp.equalsIgnoreCase("Invalid")) {

				if (targetPage == true) {
					nav.nav_profile();
					nav.nav_profile_drp_logout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
			if (exp.equalsIgnoreCase("Valid")) {

				if (targetPage == true) {
					nav.nav_profile();
					Thread.sleep(4000);
					nav.nav_profile_drp_logout();
					Assert.assertTrue(true);
				}

				else {
					Assert.assertTrue(false);
				}
			}

		} catch (Exception e) {

			Assert.fail("An exception occurred: " + e.getMessage());
		}

	}

}
