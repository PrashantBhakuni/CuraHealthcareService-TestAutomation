package prashantbhakuni.pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='Appointment Confirmation']")
	WebElement confirmationMessage;

	public String getConfirmationMessage() {
		return confirmationMessage.getText();
	}

	@FindBy(id = "facility")
	WebElement facility;

	@FindBy(id = "hospital_readmission")
	WebElement hospitalReadmission;

	@FindBy(id = "program")
	WebElement program;

	@FindBy(id = "visit_date")
	WebElement visitDate;

	@FindBy(id = "comment")
	WebElement comment;

	public String verifyFacilityName() {

		String facilityText = facility.getText();
		return facilityText;
	}
	public String verifyHospitalReadmission() {

		String hospitalReadmissionText = hospitalReadmission.getText();
		return hospitalReadmissionText;
	}
	public String verifyProgramName() {
		String programText = program.getText();
		return programText;
	}
	public String verifyVisitDate() {
		String visitDateText = visitDate.getText();
				return visitDateText;
	}
	public String verifyComment() {
		String commentText = comment.getText();
		return commentText;
	}
	
	@FindBy(xpath="//a[normalize-space()='Go to Homepage']")
	WebElement hompageBtn;
	
	@FindBy(id="menu-toggle")
	WebElement menuBar;
	
	public MenuBarPages openMenu()
	{
		menuBar.click();
		MenuBarPages menubarpages = new MenuBarPages(driver);
		return menubarpages;
	}
	
	public void gotoHomepage()
	{
		hompageBtn.click();
	}
	
}
