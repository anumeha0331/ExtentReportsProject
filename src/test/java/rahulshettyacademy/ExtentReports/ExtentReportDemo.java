package rahulshettyacademy.ExtentReports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	ExtentReports extent;
	@BeforeTest
	public void Demo1() {
		String path= System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("Web Automation Results");
		report.config().setDocumentTitle("Test Automation");
		
		 extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester","Anumeha");
	}
	@Test
	public void initialDemo() {
	ExtentTest test= extent.createTest("initialDemo");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Ajay\\Documents\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.rahulshettyacademy.com");
	System.out.println(driver.getTitle());
	driver.close();
	test.fail("Results do not match");
	extent.flush();
	}
}
