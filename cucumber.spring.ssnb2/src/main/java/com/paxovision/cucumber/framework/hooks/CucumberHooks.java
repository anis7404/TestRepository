package com.paxovision.cucumber.framework.hooks;

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

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.paxovision.cucumber.framework.utils.SpecializedScreenRecorder;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CucumberHooks {

	@Autowired
	private Environment environment;
	@Autowired
	private WebDriver driver;
	
	private ScreenRecorder screenRecorder;
	private String executionFeature;
	private String executingScenario;
	
	 @Before
	 public void beforeScenario(Scenario scenario) throws Exception {

		 System.out.println("****** beforeScenario *************");
	    	String scenarioId = scenario.getId();
	    	String featureName = scenarioId.substring(0, scenarioId.indexOf(";"));
	    	
	    	this.executionFeature = featureName;
	    	this.executingScenario = scenario.getName();
	    	
	    	startRecording();
	    	
	 }
	 
	 @After
	 public void afterScenario(Scenario scenario) throws Exception {
		 System.out.println("****** afterScenario *************");
	    	if (scenario.isFailed()) {
	            final byte[] screenshot = ((TakesScreenshot) driver)
	                        .getScreenshotAs(OutputType.BYTES);
	            scenario.embed(screenshot, "image/png"); //stick it in the report
	    	}
	    	
	     stopRecording();
	    	
	 }
	 
	 
	private void startRecording() throws Exception {
		String useDir = System.getProperty("user.home");
		File file = new File(useDir + "\\selenium cucumber videos\\"
							 + this.executionFeature.replaceAll("[^a-zA-Z0-9.-]", "_"));
		String fileNameStartWith = this.executingScenario.replaceAll(
								   "[^a-zA-Z0-9.-]", "_");

		this.screenRecorder = new SpecializedScreenRecorder(file,fileNameStartWith);
		this.screenRecorder.start();

	}

	private void stopRecording() throws Exception {
		this.screenRecorder.stop();
	}
	 
}
