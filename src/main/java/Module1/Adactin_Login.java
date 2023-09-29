package Module1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adactin_Login 
{
	//POM Class-I	
	//1. Data members/Global Variables should be declared globally with access level private by using @Findby Annotation	

	 @FindBy(xpath="//input[@id='username']")	private WebElement UN;	
	//private WebElement UN=driver.findelement(By.xpath("//input[@id='username']"));

	 @FindBy(id="password")	private WebElement PSW;	 
	  //private WebElement PSW=driver.findelement(By.id("password"));

	 @FindBy(xpath="//input[@name='login']") private WebElement Loginbtn;  
	//private WebElement Loginbtn=driver.findelement(By.xpath("//input[@name='login']"));
			
	 //2. Initialize within a constructor with access level public using PageFactory Class
	 
	 	 public Adactin_Login(WebDriver driver)  //13 methods
	     {
	 		PageFactory.initElements(driver,this);
	     }
	 
	 //3. Utilize within a method with access level public
	 	 
	 	 public void enterUsername(String User)  //Velocity
	 	 {
	 		UN.sendKeys(User); //Velocity
	 	 }
	 	 
	 	 public void enterPassword(String Pass)  //H84D6N
	 	 {
	 		PSW.sendKeys(Pass); //C4472J
	 	 }
	 	 
	 	 public void clickloginbutton() 
		 {
	 		Loginbtn.click();
		 }
		
	
}
