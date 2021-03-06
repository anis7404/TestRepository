package com.paxotech.selenium.framework;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.paxotech.selenium.framework.pom.HeatclinicApplication;
import com.paxotech.selenium.framework.util.SpecializedScreenRecorder;

public class ScriptBase {

	protected WebDriver driver ;
	private ScreenRecorder screenRecorder;
	
	private HeatclinicApplication heatClinic;
	

	//@BeforeMethod
	@BeforeClass
	public void beforeMethod() throws Exception {
		startRecording();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("http://demo.broadleafcommerce.org/");
	}
	
	
	//@AfterMethod
	@AfterClass
	public void afterMethod() throws Exception {
		driver.close();
		
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
	
	
	
	 public void startRecording() throws Exception{      
		 
		 String useDir = System.getProperty("user.dir");	
	     String timeString = new SimpleDateFormat("yyyyMMdd").format(new Date());
		 String fileNameStartWith  = "ScriptVideo";
		
		 File path = new File(useDir + 
				 			  System.getProperty("file.separator") + 
				 			  "target" + 
				 			  System.getProperty("file.separator") + 
				 			  "videos" + 
				 			  System.getProperty("file.separator") + 
				 			  timeString +
				 			  System.getProperty("file.separator"));
		 	   if(!path.exists()){
		 		  path.mkdir();
		 	   }
	    
	           Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	           int width = screenSize.width;
	           int height = screenSize.height;
	                          
	           Rectangle captureSize = new Rectangle(0,0, width, height);
	                          
	         GraphicsConfiguration gc = GraphicsEnvironment
	            .getLocalGraphicsEnvironment()
	            .getDefaultScreenDevice()
	            .getDefaultConfiguration();

	        this.screenRecorder = new SpecializedScreenRecorder(gc, captureSize,
	            new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
	            new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
	                 CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
	                 DepthKey, 24, FrameRateKey, Rational.valueOf(15),
	                 QualityKey, 1.0f,
	                 KeyFrameIntervalKey, 15 * 60),
	            new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
	                 FrameRateKey, Rational.valueOf(30)),
	            null, path, fileNameStartWith);
	        
	       this.screenRecorder.start();
	    
	    }

	    public void stopRecording() throws Exception
	    {
	      this.screenRecorder.stop();
	    }
	
}
