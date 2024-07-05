package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListCampaignPage extends BasePage {

	public WebDriver driver;

	public ListCampaignPage(WebDriver driver) {

		super(driver);
	}

	// Email Campaign text extracting
	@FindBy(xpath = "//b[text()='Email Campaigns']")
	WebElement list_emailCampaignText_loc;

	// Clicking on the Campaign In Navigation
	public String list_emailCampaignText() {
		return list_emailCampaignText_loc.getText();
	}

}
