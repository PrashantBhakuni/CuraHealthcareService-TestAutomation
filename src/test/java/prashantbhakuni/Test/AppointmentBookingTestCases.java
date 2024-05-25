package prashantbhakuni.Test;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import prashantbhakuni.TestComponents.BaseTest;
import prashantbhakuni.pageobjects.BookingPage;
import prashantbhakuni.pageobjects.ConfirmationPage;
import prashantbhakuni.pageobjects.MenuBarPages;

public class AppointmentBookingTestCases extends BaseTest {

	@Test
	public void bookingOne() {

		// Happy Path Testing

		String username = "John Doe";
		String password = "ThisIsNotAPassword";
		String facilityName = "Tokyo CURA Healthcare Center";
		String hospitalReadmission = "Yes";
		String programName = "Medicare";
		String visitDate = "04/06/2024";
		String comment = "I want the assistance of Dr. J Sharma";
		String confirmationMessage = "Appointment Confirmation";
		BookingPage bookingpage = loginpage.loginWebsite(username, password);
		bookingpage.readmission();
		bookingpage.selectAppointmentDay(visitDate);
		bookingpage.writeComment(comment);
		ConfirmationPage confirmationpage = bookingpage.bookAppointment();
		Assert.assertEquals(confirmationMessage, confirmationpage.getConfirmationMessage());
		Assert.assertEquals(facilityName, confirmationpage.verifyFacilityName());
		Assert.assertEquals(hospitalReadmission, confirmationpage.verifyHospitalReadmission());
		Assert.assertEquals(programName, confirmationpage.verifyProgramName());
		Assert.assertEquals(visitDate, confirmationpage.verifyVisitDate());
		Assert.assertEquals(comment, confirmationpage.verifyComment());
	}

	@Test
	public void bookingTwo() {

		// Happy Path Testing with different options selected.

		String username = "John Doe";
		String password = "ThisIsNotAPassword";
		String facilityName = "Hongkong CURA Healthcare Center";
		String hospitalReadmission = "No";
		String programName = "None";
		String visitDate = "04/06/2024";
		String comment = "I don't want readmission, but I want chocolates.";
		String confirmationMessage = "Appointment Confirmation";
		BookingPage bookingpage = loginpage.loginWebsite(username, password);
		bookingpage.selectFacility(facilityName);
		bookingpage.selectProgram(programName);
		bookingpage.selectAppointmentDay(visitDate);
		bookingpage.writeComment(comment);
		ConfirmationPage confirmationpage = bookingpage.bookAppointment();
		Assert.assertEquals(confirmationMessage, confirmationpage.getConfirmationMessage());
		Assert.assertEquals(facilityName, confirmationpage.verifyFacilityName());
		Assert.assertEquals(hospitalReadmission, confirmationpage.verifyHospitalReadmission());
		Assert.assertEquals(programName, confirmationpage.verifyProgramName());
		Assert.assertEquals(visitDate, confirmationpage.verifyVisitDate());
		Assert.assertEquals(comment, confirmationpage.verifyComment());
	}

	@Test
	public void bookingThree() throws InterruptedException {

		// clicking the "Book Appointment button" without selecting the date;

		String username = "John Doe";
		String password = "ThisIsNotAPassword";
		String facilityName = "Seoul CURA Healthcare Center";
		String hospitalReadmission = "No";
		String programName = "Medicare";
		String visitDate = "04/06/2025";
		String comment = "";
		String confirmationMessage = "Appointment Confirmation";

		BookingPage bookingpage = loginpage.loginWebsite(username, password);
		bookingpage.selectFacility(facilityName);
		bookingpage.bookAppointment();
		bookingpage.selectAppointmentDay(visitDate);
		ConfirmationPage confirmationpage = bookingpage.bookAppointment();
		Assert.assertEquals(confirmationMessage, confirmationpage.getConfirmationMessage());
		Assert.assertEquals(facilityName, confirmationpage.verifyFacilityName());
		Assert.assertEquals(hospitalReadmission, confirmationpage.verifyHospitalReadmission());
		Assert.assertEquals(programName, confirmationpage.verifyProgramName());
		Assert.assertEquals(visitDate, confirmationpage.verifyVisitDate());
		Assert.assertEquals(comment, confirmationpage.verifyComment());
	}

	@Test
	public void bookingFour() {
		// verifying booking details in history page
		String username = "John Doe";
		String password = "ThisIsNotAPassword";
		String facilityName = "Hongkong CURA Healthcare Center";
		String hospitalReadmission = "No";
		String programName = "None";
		String visitDate = "10/06/2025";
		String comment = "I want home health care and chocolates.";
		String confirmationMessage = "Appointment Confirmation";

		BookingPage bookingpage = loginpage.loginWebsite(username, password);
		bookingpage.selectFacility(facilityName);
		bookingpage.selectProgram(programName);
		bookingpage.selectAppointmentDay(visitDate);
		bookingpage.writeComment(comment);
		ConfirmationPage confirmationpage = bookingpage.bookAppointment();
		Assert.assertEquals(confirmationMessage, confirmationpage.getConfirmationMessage());
		Assert.assertEquals(facilityName, confirmationpage.verifyFacilityName());
		Assert.assertEquals(hospitalReadmission, confirmationpage.verifyHospitalReadmission());
		Assert.assertEquals(programName, confirmationpage.verifyProgramName());
		Assert.assertEquals(visitDate, confirmationpage.verifyVisitDate());
		Assert.assertEquals(comment, confirmationpage.verifyComment());

		MenuBarPages menubarpages = confirmationpage.openMenu();
		menubarpages.getHistoryPage();
		Assert.assertEquals(facilityName, menubarpages.verifyFacilityName());
		Assert.assertEquals(hospitalReadmission, menubarpages.verifyHospitalReadmission());
		Assert.assertEquals(programName, menubarpages.verifyProgramName());
		Assert.assertEquals(visitDate, menubarpages.verifyVisitDate());
		Assert.assertEquals(comment, menubarpages.verifyComment());
		confirmationpage.openMenu();
		menubarpages.logOut();
	}

	@Test
	public void bookingFive() {
		// verifying the number of records in history and the latest record details
		int numOfRecords = 0;
		String username = "John Doe";
		String password = "ThisIsNotAPassword";
		String facilityName1 = "Hongkong CURA Healthcare Center";
		String programName1 = "Medicaid";
		String visitDate1 = "05/06/2024";
		String comment1 = "This is the first appointment.";
		String confirmationMessage = "Appointment Confirmation";

		String facilityName2 = "Tokyo CURA Healthcare Center";
		String hospitalReadmission2 = "Yes";
		String programName2 = "Medicare";
		String visitDate2 = "10/06/2024";
		String comment2 = "This is the second appointment.";

		BookingPage bookingpage = loginpage.loginWebsite(username, password);
		bookingpage.selectFacility(facilityName1);
		bookingpage.selectProgram(programName1);
		bookingpage.selectAppointmentDay(visitDate1);
		bookingpage.writeComment(comment1);
		ConfirmationPage confirmationpage = bookingpage.bookAppointment();
		Assert.assertEquals(confirmationMessage, confirmationpage.getConfirmationMessage());
		numOfRecords++;
		confirmationpage.gotoHomepage();

		bookingpage.readmission();
		bookingpage.selectAppointmentDay(visitDate2);
		bookingpage.writeComment(comment2);
		confirmationpage = bookingpage.bookAppointment();
		Assert.assertEquals(confirmationMessage, confirmationpage.getConfirmationMessage());
		numOfRecords++;

		MenuBarPages menubarpages = confirmationpage.openMenu();
		menubarpages.getHistoryPage();
		Assert.assertEquals(numOfRecords, menubarpages.countRecords());
		Assert.assertEquals(facilityName2, menubarpages.verifyFacilityName());
		Assert.assertEquals(hospitalReadmission2, menubarpages.verifyHospitalReadmission());
		Assert.assertEquals(programName2, menubarpages.verifyProgramName());
		Assert.assertEquals(visitDate2, menubarpages.verifyVisitDate());
		Assert.assertEquals(comment2, menubarpages.verifyComment());
		confirmationpage.openMenu();
		menubarpages.logOut();
	}

	@Test(groups={"Error"})
	public void bookingSix() {
		// booking the appointment for past date
		String username = "John Doe";
		String password = "ThisIsNotAPassword";
		String facilityName = "Hongkong CURA Healthcare Center";
		String hospitalReadmission = "No";
		String programName = "None";
		String visitDate = "10/03/2024"; // current date: 21/05/2024
		String comment = "I want home health care and chocolates.";
		String confirmationMessage = "Appointment Confirmation";
		String errorMessage = "Please select a valid date";

		BookingPage bookingpage = loginpage.loginWebsite(username, password);
		bookingpage.selectFacility(facilityName);
		bookingpage.selectProgram(programName);
		bookingpage.selectAppointmentDay(visitDate);
		bookingpage.writeComment(comment);
		ConfirmationPage confirmationpage = bookingpage.bookAppointment();
		Assert.assertEquals(confirmationMessage, errorMessage);
	}

}
