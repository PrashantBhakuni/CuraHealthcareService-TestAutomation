package prashantbhakuni.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingPage {

	private WebDriver driver;

	public BookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='Make Appointment']")
	private WebElement bookingPageText;

	public String getBookingPageText() {
		return bookingPageText.getText();
	}

	@FindBy(xpath = "//form/div/div/select")
	private WebElement facilitydropDown;

	@FindBy(css = "option[value ='Tokyo CURA Healthcare Center']")
	private WebElement tokyoFacility;

	@FindBy(css = "option[value = 'Hongkong CURA Healthcare Center']")
	private WebElement hongkongFacility;

	@FindBy(css = "option[value = 'Seoul CURA Healthcare Center']")
	private WebElement seoulFacility;

	@FindBy(id = "chk_hospotal_readmission")
	private WebElement checkReadmission;

	public void selectFacility(String facilityName) {

		String tokyoFacilityName = tokyoFacility.getText();
		String hongkongFacilityName = hongkongFacility.getText();
		String SeoulFacilityName = seoulFacility.getText();

		if (facilityName.equals(tokyoFacilityName)) {
			tokyoFacility.click();
		} else if (facilityName.equals(hongkongFacilityName)) {
			hongkongFacility.click();
		} else if (facilityName.equals(SeoulFacilityName)) {
			seoulFacility.click();
		}
	}

	public void readmission() {
		checkReadmission.click();
	}

	@FindBy(id = "radio_program_medicare")
	private WebElement medicareProgram;

	@FindBy(xpath = "//div[@class='form-group'][3]/div/label[1]")
	private WebElement medicareTextEle;

	@FindBy(id = "radio_program_medicaid")
	private WebElement medicaidProgram;

	@FindBy(xpath = "//div[@class='form-group'][3]/div/label[2]")
	private WebElement medicaidTextEle;

	@FindBy(id = "radio_program_none")
	private WebElement noneProgram;

	@FindBy(xpath = "//div[@class='form-group'][3]/div/label[3]")
	private WebElement noneTextEle;

	public void selectProgram(String program) {

		String medicareText = medicareTextEle.getText();
		String medicaidText = medicaidTextEle.getText();
		String noneText = noneTextEle.getText();
		if (program.equals(medicareText)) {
			medicareProgram.click();
		} else if (program.equals(medicaidText)) {
			medicaidProgram.click();
		} else if (program.equals(noneText)) {
			noneProgram.click();
		}
	}

	@FindBy(id = "txt_visit_date")
	private WebElement datePicker;

	@FindBy(css = "div[class='datepicker-days'] th[class='datepicker-switch']")
	private WebElement selectYear;

	@FindBy(id = "txt_comment")
	private WebElement addComment;

	public void selectAppointmentDay(String visitDate) {
		datePicker.sendKeys(visitDate);
	}

	public void writeComment(String comment) {
		addComment.sendKeys(comment);
	}

	@FindBy(id = "btn-book-appointment")
	private WebElement submitBtn;

	public ConfirmationPage bookAppointment() {
		submitBtn.click();
		ConfirmationPage confirmationpage = new ConfirmationPage(driver);
		return confirmationpage;
	}
	

}
