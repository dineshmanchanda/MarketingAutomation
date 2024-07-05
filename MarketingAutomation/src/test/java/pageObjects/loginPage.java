package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage {

	public WebDriver driver;

	public loginPage(WebDriver driver) {

		super(driver);
	}

	// Username
	@FindBy(xpath = "//input[@id='inputEmail3']")
	WebElement txt_username_loc;
	// Password
	@FindBy(xpath = "//input[@id='inputPassword3']")
	WebElement txt_password_loc;
	// Login
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btn_login_loc;

	// Verify If login Or not
	@FindBy(xpath = "//span[text()='Inbox']")
	WebElement home_confirmation_text_loc;

	// Sending Username to username input field
	public void login_username(String username) {
		txt_username_loc.sendKeys(username);
	}
	
	// Clearing Username input field
		public void login_username_clear() {
			txt_username_loc.clear();
		}

	// Sending Password to password input field
	public void login_password(String password) {
		txt_password_loc.sendKeys(password);
	}
	
	// Clearing Password input field
		public void login_password_clear() {
			txt_password_loc.clear();
		}

	// Clicking on Login Button
	public void login_button() {
		btn_login_loc.click();
	}

	// Extracting text from Home Page
	public String home_Page_Confirmation() {

		try {
			return (home_confirmation_text_loc.getText());
		}

		catch (Exception e) {
			return (e.getMessage());
		}
	}
	
	public boolean isMyHomePageExists()   // MyAccount Page heading display status
	{
		try {
			return (home_confirmation_text_loc.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

}
