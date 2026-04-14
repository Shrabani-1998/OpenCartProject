package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import javax.swing.text.DateFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public Properties p;
  
	@BeforeClass
	public void setup() throws IOException {
		
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public String getString() {
		return RandomStringUtils.randomAlphabetic(5);
	}
	public String getNumber() {
		return RandomStringUtils.randomNumeric(10);
	}
	
	public static String captureScreenshot(WebDriver driver, String testName) throws IOException {
		String timeStamp=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String trgFilePath=System.getProperty("user.dir")+"\\screenshots\\"+testName+"_"+timeStamp+".png";
		File trgFile=new File(trgFilePath);
		FileUtils.copyFile(src, trgFile);
		
		return trgFilePath;
		
	}
}

