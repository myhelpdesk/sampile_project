package mar11;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UsingPropertyFile {

	public static void main(String[] args) throws Throwable {
//How to access from property files
		Properties conpro = new Properties();
		//load properties file
		conpro.load(new FileInputStream("OR.properties"));
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(conpro.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath(conpro.getProperty("Objuser"))).sendKeys("Admin");
		driver.findElement(By.xpath(conpro.getProperty("Objpass"))).sendKeys("Admin");
		driver.findElement(By.xpath(conpro.getProperty("Objlogin"))).click();
		driver.findElement(By.xpath(conpro.getProperty("ObjBranches"))).click();
		driver.findElement(By.xpath(conpro.getProperty("Objnewbranch"))).click();
		driver.findElement(By.xpath(conpro.getProperty("ObjBranchname"))).sendKeys("Ameerpet");
		driver.findElement(By.xpath(conpro.getProperty("ObjAdd1"))).sendKeys("Hydearbad1");
		driver.findElement(By.xpath(conpro.getProperty("ObjAdd2"))).sendKeys("Srnagar");
		driver.findElement(By.xpath(conpro.getProperty("ObjAdd3"))).sendKeys("Ameerpet23");
		driver.findElement(By.xpath(conpro.getProperty("ObjArea"))).sendKeys("Ameerpet67");
		driver.findElement(By.xpath(conpro.getProperty("Objzip"))).sendKeys("65478");
		new Select(driver.findElement(By.xpath(conpro.getProperty("ObjCountry")))).selectByIndex(1);
		new Select(driver.findElement(By.xpath(conpro.getProperty("Objstate")))).selectByIndex(2);
		new Select(driver.findElement(By.xpath(conpro.getProperty("Objcity")))).selectByIndex(1);
		driver.findElement(By.xpath(conpro.getProperty("Objsubmit"))).click();
		String alerttext = driver.switchTo().alert().getText();
		System.out.println(alerttext);
		driver.switchTo().alert().accept();
		driver.quit();
	}

}
