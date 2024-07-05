package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCampaignPage extends BasePage {

	public WebDriver driver;

	public CreateCampaignPage(WebDriver driver) {

		super(driver);
	}

	// Name Input Field
	@FindBy(id = "campaignName")
	WebElement txt_ccp_name_loc;

	// Description Input Field
	@FindBy(id = "campaignDescription")
	WebElement txt_ccp_description_loc;

	// Email Display Name Input Field
	@FindBy(id = "emailDisplayName")
	WebElement txt_ccp_emailDisplayName_loc;

	// Email Subject Input Field
	@FindBy(id = "emailSubject")
	WebElement txt_ccp_emailSubject_loc;

	// Email Preview text Input Field
	@FindBy(id = "emailPreviewText")
	WebElement txt_ccp_emailPreviewText_loc;

	// Save as Draft Button
	@FindBy(id = "saveAsDraftBtn")
	WebElement btn_ccp_saveAsDraft_loc;

	// Ready Button
	@FindBy(id = "readyBtn")
	WebElement btn_ccp_ready_loc;

	// Cancel Button
	@FindBy(id = "cancelBtn")
	WebElement btn_ccp_cancel_loc;

	// Bread crumb Hyperlink
	@FindBy(id = "redirectToCampaigns")
	WebElement btn_ccp_breadcrumbCampaign_loc;

	// Toaster message on Clicking Save as Draft Button
	@FindBy(xpath = "//div[@role='alert']")
	WebElement toaster_ccp_getConfirmationMessage_loc;

	// Sending Name to the Name input field
	public void ccp_name(String name) {
		txt_ccp_name_loc.sendKeys(name);
	}

	public String ccp_getConfirmationMessage() {

		try {
			return (toaster_ccp_getConfirmationMessage_loc.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

}
