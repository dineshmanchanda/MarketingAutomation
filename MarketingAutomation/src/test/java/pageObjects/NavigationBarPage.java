package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBarPage extends BasePage {

	public WebDriver driver;

	public NavigationBarPage(WebDriver driver) {

		super(driver);
	}

	// Home
	@FindBy(xpath = "//ul[@class='nav-items']//li[text()='Home']")
	WebElement nav_home_loc;

	// Patients
	@FindBy(xpath = "//ul[@class='nav-items']//li[text()='Patients']")
	WebElement nav_patients_loc;

	// Inbox
	@FindBy(xpath = "//ul[@class='nav-items']//li[contains(text(),'Inbox')]")
	WebElement nav_inbox_loc;

	// Campaign
	@FindBy(xpath = "//ul[@class='nav-items']//li[text()='Campaign']")
	WebElement nav_campaign_loc;

	// Dashboard
	@FindBy(xpath = "//ul[@class='nav-items']//li[text()='Dashboards']")
	WebElement nav_dashboards_loc;

	// Reports
	@FindBy(xpath = "//ul[@class='nav-items']//li[text()='Reports']")
	WebElement nav_reports_loc;
	
	//Profile
	@FindBy(xpath="//span[@id='matMenuId']")
	WebElement nav_profile_loc;
	
	//Profile-dropdown
	@FindBy(xpath="//span[text()='Logout']")
	WebElement nav_profile_drp_logout_loc;

	// Clicking on the Campaign In Navigation
	public void nav_campaign() {
		nav_campaign_loc.click();
	}
	
	// Clicking on the profile In Navigation
		public void nav_profile() {
			nav_profile_loc.click();
		}

		// Clicking on the Logout button in profile In Navigation
				public void nav_profile_drp_logout() {
					nav_profile_drp_logout_loc.click();
				}

}
