package Library_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class UtilityClass1
{
	//Name: Rahul
			//Date: 13/9/2023
			//Day: Wed
			//To fetch data from PF
			
			@Test                      //UserName   Password
			public static String getDataFromPF(String key) throws IOException 
			{
				
				//To reach upto Property File
			FileInputStream file=new FileInputStream("D:\\newbatch\\15_April_Maven_Project\\ProFile.properties");
				
			//Create Object of Properties Class
			Properties Prop=new Properties();
			
			//To Open property File
			  Prop.load(file);
			
			//To fetch data/value from Property File
			String  Value1=Prop.getProperty(key);   //UserName---->Velocity    
			                                       //Password---->H84D6N
			  return Value1;  //Velocity   //H84D6N
			
			}
			
			    //Name: Rahul
				//Date: 14/9/2023
				//Day: Thursday
				//To fetch data from Excelsheet
			
			@Test                                             //1            //0
			public static String getDatafromExcelsheet(int  RowIndex, int CellIndex) throws EncryptedDocumentException, IOException 
			{
				
				//To reach upto Excelsheet
			FileInputStream file=new FileInputStream("D:\\newbatch\\15_April_Maven_Project\\TestData\\15_April_Morning.xlsx");
				                                                                  //1                 //0
			String	Value2=WorkbookFactory.create(file).getSheet("Sheet14").getRow(RowIndex).getCell(CellIndex).getStringCellValue(); //Velocity!
				                                                                                                   //Adactin.com - Hotel Reservation System                  
				return Value2;  //Velocity!  // Adactin.com - Hotel Reservation System
			}
			
			
			 //Name: Rahul
			//Date: 15/9/2023
			//Day: Friday
			//To Capture Screenshot of Failed Test Cases
			
			@Test                                                           //TC101
			public static void CaptureScreenshot(WebDriver driver, String TestCaseID) throws IOException
			{
		        File Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
				System.out.println(Source);
				                                                        //TC101
				File Destination=new File("D:\\newbatch\\15_April_Maven_Project\\Screenshot\\."+TestCaseID+".jpg");
				
				FileHandler.copy(Source,Destination);
			}
			
}
