package prashantbhakuni.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuBarPages {
	
	public MenuBarPages(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[href='history.php#history']")
	private WebElement historyBtn;
	
	@FindBy(css=".panel")
	private List<WebElement> appointmentRecords;
	
	public void getHistoryPage()
	{
		historyBtn.click();
	}
	
	public int countRecords()
	{
		return appointmentRecords.size();	
	}
	
	@FindBy(xpath="//div[@class=' col-sm-offset-2 col-sm-8'][last()]/div/div[1]")
	private WebElement visitDate;
	
	@FindBy(xpath="//div[@class=' col-sm-offset-2 col-sm-8'][last()]/div/div/div[2]/p")
	private WebElement facilityName;
	
	@FindBy(xpath="//div[@class=' col-sm-offset-2 col-sm-8'][last()]/div/div/div[5]/p")
	private WebElement hospitalReadmission;
	
	@FindBy(xpath="//div[@class=' col-sm-offset-2 col-sm-8'][last()]/div/div/div[8]/p")
	private WebElement programName;
	
	@FindBy(xpath="//div[@class=' col-sm-offset-2 col-sm-8'][last()]/div/div/div[11]/p")
	private WebElement comment;
	
	public String verifyFacilityName() {

		String facilityNameText = facilityName.getText();
		return facilityNameText;
	}
	public String verifyHospitalReadmission() {

		String hospitalReadmissionText = hospitalReadmission.getText();
		return hospitalReadmissionText;
	}
	public String verifyProgramName() {
		String programNameText = programName.getText();
		return programNameText;
	}
	public String verifyVisitDate() {
		String visitDateText = visitDate.getText();
				return visitDateText;
	}
	public String verifyComment() {
		String commentText = comment.getText();
		return commentText;
	}

	@FindBy(css="a[href='authenticate.php?logout']")
	private WebElement logoutBtn;
	
	public void logOut()
	{
		logoutBtn.click();
	}
	
}
