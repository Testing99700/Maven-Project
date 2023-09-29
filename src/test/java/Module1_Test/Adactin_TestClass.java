package Module1_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library_file.BaseClass;
import Library_file.UtilityClass1;
import Module1.Adactin_Login;
import Module1.Adactin_Welcome_HomePage;

public class Adactin_TestClass extends BaseClass
{
	Adactin_Login Login;
	Adactin_Welcome_HomePage Home;
	String TestCaseID;  //TC100   //TC101
	
	@BeforeClass
	public void OpenBrowser() 
	{
		InitilizationBrowser();		
		//Create Object Of POM-I
		Login=new Adactin_Login(driver);	
		//Create Object Of POM-II
		Home=new Adactin_Welcome_HomePage(driver);	
	}
		
	@BeforeMethod
	public void LoginToAPP() throws IOException 
	{
		Login.enterUsername(UtilityClass1.getDataFromPF("UserName"));  //Velocity
		Login.enterPassword(UtilityClass1.getDataFromPF("Password"));   //H84D6N
		Login.clickloginbutton();

	}
	
	@Test(priority=1)                          //Test Method/case
	public void VerifyUserName() throws EncryptedDocumentException, IOException 
	{
		TestCaseID="TC100";

	String	ActualUserName=Home.getUsername();  //Velocity!
	String ExpectedUsername=UtilityClass1.getDatafromExcelsheet(0,0);  //Velocity!
	Assert.assertEquals(ActualUserName,ExpectedUsername);  //Velocity!   //Velocity!
	
	}
	
	@Test(priority=2)  
	public void GetTitleofApp() throws EncryptedDocumentException, IOException 
	{
		TestCaseID="TC101";
		String ActualTitle=driver.getTitle();  // Adactin.com - Search Hotel
		String ExpectedTitle=UtilityClass1.getDatafromExcelsheet(1, 0);  // Adactin.com - Search Hotel
		Assert.assertEquals(ActualTitle,ExpectedTitle); 
	}
	
	@Test(priority=3) 
	public void BookAHotel() throws EncryptedDocumentException, IOException 
	{
		TestCaseID="TC103";
Home.SelectLocation(UtilityClass1.getDatafromExcelsheet(2, 0)); // Sydney
Home.SelectHotels(UtilityClass1.getDatafromExcelsheet(3, 0)); //Hotel Sunshine
Home.SelectRoomType(UtilityClass1.getDatafromExcelsheet(4, 0)); // Double
Home.SelectNumberofRooms(UtilityClass1.getDatafromExcelsheet(5, 0)); //4 - Four
Home.EnterCheckInDate(UtilityClass1.getDatafromExcelsheet(6, 0)); //15-10-2023
Home.EnterCheckOutDate(UtilityClass1.getDatafromExcelsheet(7, 0)); //18-10-2023
Home.SelectAdultsperRoom(UtilityClass1.getDatafromExcelsheet(8, 0));  //2 - Two
Home.SelectChildrenperRoom(UtilityClass1.getDatafromExcelsheet(9, 0));//1 - One
Home.ClickSearchButton();
Home.SelectRadioButton();
Home.ClickContinueButton();
Home.EnterFirstName(UtilityClass1.getDatafromExcelsheet(0, 1)); //Java
Home.EnterLastName(UtilityClass1.getDatafromExcelsheet(1, 1)); //Selenium
Home.EnterBillingAddress(UtilityClass1.getDatafromExcelsheet(2, 1)); //ABCD Road Pune
Home.EnterCreditCardNo(UtilityClass1.getDatafromExcelsheet(3, 1)); //1234567890123450
Home.SelectCreditCardType(UtilityClass1.getDatafromExcelsheet(4, 1));// VISA
Home.SelectEDMonth(UtilityClass1.getDatafromExcelsheet(5, 1));//March
Home.SelectEDYear(UtilityClass1.getDatafromExcelsheet(6, 1)); //2030
Home.EnterCVVNumber(UtilityClass1.getDatafromExcelsheet(7, 1));//1987
Home.ClickBookNowButton();
	}
	
	@AfterMethod                   //Pass  //Fail
	public void LogoutFromApp(ITestResult Result) throws IOException
	{
		  //Fail                   //Fail
		if(Result.getStatus()==ITestResult.FAILURE)  //false  true
		{
			UtilityClass1.CaptureScreenshot(driver, TestCaseID);  //TC100   //TC101
		}
		
		Home.clicklogoutbutton();
		Home.clickloginagainlink();		
	}

	
	@AfterClass
	public void CloseBrowser() 
	{
		driver.quit();
	}
}
