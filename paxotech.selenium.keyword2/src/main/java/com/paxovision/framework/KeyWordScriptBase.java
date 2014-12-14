package com.paxovision.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.paxovision.framework.excel.DataReaderPOI;
import com.paxovision.framework.excel.IDataReader;
import com.paxovision.framework.kw.PageObject;
import com.paxovision.framework.kw.TestObject;
import com.paxovision.framework.kw.TestStep;

public class KeyWordScriptBase {

	private String objectMapFileName ;
	private String keywordScriptFileName;
	private String testDataFileName;
	
	IDataReader objectMapReader;
	IDataReader keywordScriptReader;
	

	protected HashMap<String, PageObject> objectMap;
	protected ArrayList<TestStep> testSteps;
	
	protected HashMap<String, HashMap<String, String>> testData;

	protected WebDriver driver;
	
	protected String testDataId;
	 
	
	

	@BeforeMethod
	public void beforeMethod() throws Exception{
		objectMapFileName = System.getProperty("user.dir") + "/src/test/resources/scripts/KeywordScript01.xlsx";
		loadObjectMap(objectMapFileName);
		
		
		testDataFileName = System.getProperty("user.dir") + "/src/test/resources/scripts/KeywordScript01.xlsx";
		loadTestData(testDataFileName);
		
		//System.out.println(testData.get("1").get("EmailAddress"));
		
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod(){
		driver.close();
		driver.quit();
	}
	
	protected void loadTestScript(String testScript) throws Exception{
		keywordScriptFileName = System.getProperty("user.dir") + "/src/test/resources/scripts/KeywordScript01.xlsx";
		loadTestSteps(keywordScriptFileName,testScript);
	}
	
	protected void loadTestSteps(String file,String script) throws Exception {
		
		keywordScriptReader = new DataReaderPOI(file);
		testSteps = new ArrayList<TestStep>();
		
		String[][] steps = keywordScriptReader.getExcelSheetData(script);
		for(int i = 1 ; i < steps.length; i++){
			String stepId = steps[i][0];
			String page = steps[i][1];
			String element = steps[i][2];
			String keyword = steps[i][3];
			String data = steps[i][4];
			
			TestStep t = new TestStep(stepId, page, element, keyword, data);
			System.out.println(t);
			testSteps.add(t);	
		}
	}


	protected void loadObjectMap(String file) throws Exception {
		objectMapReader = new DataReaderPOI(file);
		String[][] objMap = objectMapReader.getExcelSheetData("ObjectMap");
		
		objectMap = new HashMap<String, PageObject>();

		for(int i = 1 ; i < objMap.length; i++){
				
			String objMapId = objMap[i][0];
			String page = objMap[i][1];
			String element = objMap[i][2];
			String findBy = objMap[i][3];
			String using = objMap[i][4];
			
			if( objectMap.containsKey(page)){
				PageObject pageObject = objectMap.get(page);
				TestObject to = new TestObject(objMapId, page, element, findBy, using);  
				pageObject.put(element, to);
				System.out.println(to);
			}
			else
			{
				PageObject pageObject = new PageObject();
				TestObject to =  new TestObject(objMapId, page, element, findBy, using);
				pageObject.put(element, to);
				System.out.println(to);
				objectMap.put(page, pageObject);
			}
		}
	}
	
	
	public void loadTestData(String file) throws Exception{
		IDataReader reader = new DataReaderPOI(file);
		
		testData = new HashMap<String, HashMap<String,String>>();
		
		String[][] data = reader.getExcelSheetData("TestData", true);
		
		for(int i = 1; i < data[0].length; i++){
			HashMap<String, String> dataSet = new HashMap<String, String>();
			for(int j = 0; j < data.length ; j++){
				String varName = data[j][0];
				String variableValue = data[j][i];
				dataSet.put(varName, variableValue);
			}
			
			String testDataId = dataSet.get("TDID").replaceAll("\\.0", "");
			testData.put(testDataId, dataSet);
		}
	}
	
	protected void processKeyword(TestStep ts){
		if(ts.getPage().trim().contentEquals("")){
			String keyword = ts.getKeyword();
			
			if(keyword.toUpperCase().trim().contentEquals("STARTAPPLICATION")){
				driver.navigate().to(ts.getData());
			}
			else
			{
				System.out.println("Invalid Keyword: " + keyword);
				throw new RuntimeException("Invalid keyword : " + keyword + " in step " + ts.getStepId());
			}
		}
		else
		{
			HashMap<String, TestObject> page = this.objectMap.get(ts.getPage());
			TestObject to = page.get(ts.getElement());
			
			WebElement element = driver.findElement(getWebElementFindBy(to));
			String keyword = ts.getKeyword();
			if(keyword.toUpperCase().trim().contentEquals("SETTEXT")){
				element.sendKeys(getTestDataFromDataVariable(ts.getData()));
			}
			else if(keyword.toUpperCase().trim().contentEquals("CLICK")){
				element.click();
			}
			else if(keyword.toUpperCase().trim().contentEquals("VERIFYTEXT")){
				String text = element.getText();
				Assert.assertEquals(text,getTestDataFromDataVariable( ts.getData()));
			}
			else
			{
				System.out.println("Invalid Action: " + keyword);
				throw new RuntimeException("Invalid Action : " + keyword + " in step " + ts.getStepId());
			}
			
		}
		
	}
	
	public String getTestDataFromDataVariable( String value){
		
		String testDataSetId = getTestDataId();
		
		if(testDataSetId != null && !testDataSetId.contentEquals("")){
			if(value.startsWith("${") && value.endsWith("}")){
				
				String key = value.substring(2, value.length() - 1);
				
				if(testData.containsKey(testDataSetId)){
					if( testData.get(testDataSetId).containsKey(key)){
						String tmp =  testData.get(testDataSetId).get(key);
						return tmp;
					}
				}
			}
		}
		return value;
	}
	
	
	public String getTestDataId() {
		return testDataId;
	}

	public void setTestDataId(String testDataId) {
		this.testDataId = testDataId.replaceAll("\\.0", "");;
	}
	
	protected  By getWebElementFindBy(TestObject to) {

		By by = null;

		try {
			String strBy = to.getFindBy();
			String strUsing = to.getUsing();
			if (strBy.equalsIgnoreCase("id")) {
				by = By.id(strUsing);
			} else if (strBy.equalsIgnoreCase("xpath")) {
				by = By.xpath(strUsing);
			} else if (strBy.equalsIgnoreCase("name")) {
				by = By.name(strUsing);
			} else if (strBy.equalsIgnoreCase("link")) {
				by = By.linkText(strUsing);
			} else if (strBy.equalsIgnoreCase("class")) {
				by = By.className(strUsing);
			} else if (strBy.equalsIgnoreCase("css")) {
				by = By.cssSelector(strUsing);
			} else if (strBy.equalsIgnoreCase("partial")) {
				by = By.partialLinkText(strUsing);
			} else if (strBy.equalsIgnoreCase("tag")) {
				by = By.tagName(strUsing);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return by;
	}
	
}
