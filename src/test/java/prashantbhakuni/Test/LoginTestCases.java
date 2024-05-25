package prashantbhakuni.Test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import prashantbhakuni.TestComponents.BaseTest;
import prashantbhakuni.pageobjects.BookingPage;
import prashantbhakuni.pageobjects.LoginPage;

public class LoginTestCases extends BaseTest {

	@Test
	public void loginOne() throws IOException {

		// Login with incorrect username and correct password

		String username = "IncorrectUsername";
		String password = "ThisIsNotAPassword";
		String errorMessage = "Login failed! Please ensure the username and password are valid.";
		loginpage.loginWebsite(username, password);
		Assert.assertEquals(errorMessage, loginpage.getErrorMessage());
	}

	@Test
	public void loginTwo() throws IOException {

		// Login with correct username and incorrect password

		String username = "John Doe";
		String password = "IncorrectPassword";
		String errorMessage = "Login failed! Please ensure the username and password are valid.";
		loginpage.loginWebsite(username, password);
		Assert.assertEquals(errorMessage, loginpage.getErrorMessage());
	}

	@Test
	public void loginThree() throws IOException {
		// Login with incorrect username and incorrect password

		String username = "IncorrectUsername";
		String password = "IncorrectPassword";
		String errorMessage = "Login failed! Please ensure the username and password are valid.";
		loginpage.loginWebsite(username, password);
		Assert.assertEquals(errorMessage, loginpage.getErrorMessage());
	}

	@Test
	public void loginFour() throws IOException {
		// Login without entering username or password

		String username = "";
		String password = "";
		String errorMessage = "Login failed! Please ensure the username and password are valid.";
		loginpage.loginWebsite(username, password);
		Assert.assertEquals(errorMessage, loginpage.getErrorMessage());
	}

	@Test
	public void loginFive() throws IOException {
		// Login with correct username and correct password

		String username = "John Doe";
		String password = "ThisIsNotAPassword";
		String bookingPageText = "Make Appointment";
		BookingPage bookingpage = loginpage.loginWebsite(username, password);
		Assert.assertEquals(bookingPageText, bookingpage.getBookingPageText());
	}
}
