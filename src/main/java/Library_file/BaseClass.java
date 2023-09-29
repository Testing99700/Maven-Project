package Library_file;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass
{
	public WebDriver driver; 
	
	public void InitilizationBrowser()
	{
		ChromeOptions CO=new ChromeOptions();
		 CO.addArguments("--remote-allow-Origins=*", "ignore-certificate-errors");
		 
		 driver=new ChromeDriver(CO);
		
		//To enter URL/open an application
		driver.get("http://adactinhotelapp.com//HotelAppBuild2//index.php");
		
		//To maximize browser
		driver.manage().window().maximize();
		
		//To wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
