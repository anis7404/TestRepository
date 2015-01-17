package com.paxovision.selenium;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.paxovision.selenium.heatclinic.HeatclinicApplication;
import com.paxovision.selenium.heatclinic.utils.SpecializedScreenRecorder;


public class ScriptBase {

	private ScreenRecorder screenRecorder;
	protected WebDriver driver ;
	private HeatclinicApplication heatClinic;
	

    
	@BeforeMethod
	@Parameters({"browser"})
	public void beforeMethod(@Optional("ff")String browser, Method method) throws Exception {
		
		startRecording(method.getName());
		
		if(browser.contentEquals("ff")){
			//driver = new FirefoxDriver();
			
			//File profileDirectory = new File(System.getProperty("user.dir") + "/src/test/resources/profile/");
			//FirefoxProfile profile = new FirefoxProfile(profileDirectory);
			//profile.setEnableNativeEvents(true);
			
			//FirefoxProfile profile = new FirefoxProfile();
			//profile.setPreference("browser.cache.disk.enable", false);
			//driver = new FirefoxDriver(profile);
			
			driver = new FirefoxDriver();
		}
		else if (browser.contentEquals("ch"))
		{
			//String chromeDriverFile = this.getClass().getResource("driver/32/chromedriver.exe").getPath();
			File chromeDriverFile = new File(System.getProperty("user.dir") +  "/src/test/resources/driver/32/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", chromeDriverFile.getAbsolutePath());
			driver = new ChromeDriver();
		} 
		else if(browser.contentEquals("ie")){
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setJavascriptEnabled(true);
			capabilities.setBrowserName("internet explorer");
			capabilities.setCapability("requireWindowFocus",true);
			//capabilities.setCapability("platform", "WIN8.0");
			//capabilities.setCapability("version", "10");

			//File driverFile = new File("C:/MyDevelopments/EclipseRepository/SeleniumWebDriver05/drivers/IEDriverServer.exe");
			File driverFile = new File(System.getProperty("user.dir") +  "/driver/32/IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", driverFile.getAbsolutePath());
			driver = new InternetExplorerDriver(capabilities);
		}
		

		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("http://demo.broadleafcommerce.org/");
		
	}
	
	
	@AfterMethod
	public void afterMethod() throws Exception {
		driver.close();
		//driver.quit();
		driver = null;
		heatClinic = null;
		
		stopRecording();
	}
	

	public HeatclinicApplication heatClinic(){
		if(heatClinic == null){
			heatClinic = new HeatclinicApplication(driver);
		}
		
		return heatClinic;
	}
	
	protected void startRecording(final String methodName) throws Exception {

		String fileSeparator = System.getProperty("file.separator");
		String useDir = System.getProperty("user.dir");
		String timeString = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String fileNameStartWith = methodName; // this.getClass().getSimpleName();
		String canonicalName = this.getClass().getCanonicalName();

		String hierarchy = Joiner.on(fileSeparator).join(
						   Splitter.on('.').split(canonicalName));

		File path = new File(useDir + fileSeparator + "target" + fileSeparator
				+ "videos" + fileSeparator + timeString + fileSeparator
				+ hierarchy + fileSeparator);

		if (!path.exists()) {
			path.mkdir();
		}

		this.screenRecorder = new SpecializedScreenRecorder(path, fileNameStartWith);
		this.screenRecorder.start();
	}

	protected void stopRecording() throws Exception {
		this.screenRecorder.stop();
	}
}
