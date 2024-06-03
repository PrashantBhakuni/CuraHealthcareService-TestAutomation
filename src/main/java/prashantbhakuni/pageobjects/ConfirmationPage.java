package prashantbhakuni.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

	private WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private @FindBy(xpath = "//h2[text()='Appointment Confirmation']")
	WebElement confirmationMessage;

	public String getConfirmationMessage() {
		return confirmationMessage.getText();
	}

	@FindBy(id = "facility")
	private WebElement facility;

	@FindBy(id = "hospital_readmission")
	private WebElement hospitalReadmission;

	@FindBy(id = "program")
	private WebElement program;

	@FindBy(id = "visit_date")
	private WebElement visitDate;

	@FindBy(id = "comment")
	private WebElement comment;

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
	private WebElement hompageBtn;
	
	@FindBy(id="menu-toggle")
	private WebElement menuBar;
	
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
