package mar11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdvanceReports {
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	//I want to generate html reports for that add @BeforeTest
	@BeforeTest
	public void generateReport()
	{
		//define path of html
		report = new ExtentReports("./ExtentReports/Demo.html");
	}
	//@BeforeMethod means It will participate for each every test method in a class before executing each test method
	@BeforeMethod
	public void setUp()
	{
		//launch driver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
	}
	@Test
	public void passTest()
	{
		//start test case here
		logger = report.startTest("Test Pass");
		logger.assignAuthor("Ranga");
		String Expected ="Google";
		String Actual = driver.getTitle();
		if(Expected.equalsIgnoreCase(Actual))
		{
			logger.log(LogStatus.PASS, "Title is matching::"+Expected+"---------"+Actual);
		}
		else
		{
			logger.log(LogStatus.FAIL, "Title is Not matching::"+Expected+"---------"+Actual);
		}
		
	}
	@Test
	public void failTest()
	{
		logger= report.startTest("Fail Test");
		logger.assignAuthor("Ranga");
		String Expected ="Yahoo";
		String Actual = driver.getTitle();
		if(Expected.equalsIgnoreCase(Actual))
		{
			logger.log(LogStatus.PASS, "Title is matching::"+Expected+"---------"+Actual);
		}
		else
		{
			logger.log(LogStatus.FAIL, "Title is Not matching::"+Expected+"---------"+Actual);
		}
	}
	@AfterMethod
	public void tearDown()
	{
		report.endTest(logger);
		report.flush();
		driver.quit();
	}

	}

