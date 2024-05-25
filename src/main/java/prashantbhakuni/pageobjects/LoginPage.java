package prashantbhakuni.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#btn-make-appointment")
	WebElement appointmentBtn;
	
	@FindBy(id = "txt-username")
	WebElement username;
	
	@FindBy(id="txt-password")
	WebElement userPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;

	public BookingPage loginWebsite(String userId, String password)
	{
		appointmentBtn.click();
		username.sendKeys(userId);
		userPassword.sendKeys(password);
		loginBtn.click();
		BookingPage bookingpage = new BookingPage(driver);
		return bookingpage;
	}
	
	@FindBy(css=".text-danger")
	WebElement errorMessage;
	
	public String getErrorMessage()
	{
		String errorMessageText = errorMessage.getText();
		return errorMessageText;
	}
	
	public void goTo()
	{
		driver.get("https://katalon-demo-cura.herokuapp.com/");
	}
}
