package testing_folder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class base_test extends data_provider{
	public static WebDriver driver;
	String browsername ;
	 ExtentReports extent;
	 
	 
	 
	
	public String set_property() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream("C:\\Users\\reach\\eclipse-workspace\\BCLC\\src\\resources\\global.properties");
		prop.load(fs);
		 browsername = prop.getProperty("browser");
		return browsername;
	
	}
	
	public void initialization() throws InterruptedException, IOException
	{ String actual_browsername=set_property();
		if(actual_browsername.equalsIgnoreCase("chrome"))
		{
			System.out.println("inside initilization");
		driver= new ChromeDriver();
		driver.get("https://qa6.playnow.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		}
		
		
	}
	
	public ExtentReports extent_report()
	{
		
		 System.out.println(testname);
		Date currentDate = new Date();
	String dateee= currentDate.toString();;
	String dateee3=dateee.replace(':', '-');
		
		String path= System.getProperty("user.dir")+"//reports//"+dateee3+".html";
		System.out.println("inside extent");
		ExtentSparkReporter report= new ExtentSparkReporter(path);
		report.config().setDocumentTitle("BCLC report");
		report.config().setReportName("gaurav kumar report");
		 extent= new ExtentReports();
		  extent.attachReporter(report);
		  extent.setSystemInfo("Tester", "Gaurav Kumar");
		  System.out.println("exit extent");
		return extent;
		
	
		
	}
	
	public String Screesnhot(String testcasename) throws IOException
	{
		
		TakesScreenshot sc= (TakesScreenshot)driver;
		File source=sc.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//"+testcasename+".png");
		FileUtils.copyFile(source, file);
		
		return System.getProperty("user.dir")+"//reports//"+testcasename+".png";
		
	}

}
