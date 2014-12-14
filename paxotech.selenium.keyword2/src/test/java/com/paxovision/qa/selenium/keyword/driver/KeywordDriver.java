package com.paxovision.qa.selenium.keyword.driver;


import java.util.ArrayList;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.paxovision.framework.KeyWordScriptBase;
import com.paxovision.framework.excel.DataReaderPOI;
import com.paxovision.framework.excel.IDataReader;
import com.paxovision.framework.kw.TestStep;

public class KeywordDriver extends KeyWordScriptBase{
	
	@Test(dataProvider="AllScriptList")
	public void driver(String testCaseId, String testCaseName, String testCaseDescription, String testScriptName, String testDataId, String execute) throws Exception{

		System.out.println("Executing " + testCaseId + " ....");
		setTestDataId(testDataId);
		
		if(execute.toUpperCase().trim().contentEquals("Y")){
			loadTestScript(testScriptName);
			
			for(TestStep ts : testSteps){
				System.out.println("Processing: " + ts.toString());
				processKeyword(ts);		
			}
		}
		else
		{
			throw new SkipException("Test Script: " + testCaseId + " skiped ");
			
		}
	}
	
	
	
	
	@DataProvider(name="ScriptList")
	public String[][] getScriptList() throws Exception{
		
		
		IDataReader reader = new DataReaderPOI(System.getProperty("user.dir") + "/src/test/resources/scripts/KeywordScript01.xlsx");

		String[][] data = reader.getExcelSheetData("TestCases",true);
		
		//return data;
		
		
		//************** Optional *********************
		//*** only need if you want to remove N line from the test case list
		ArrayList<String[]> temList = new ArrayList<String[]>();
		for(int i = 0; i < data.length; i++){
			String[] x = data[i];
			if(x[5].contentEquals("Y")){
				temList.add(x);
			}
		}
		String[][] newData = new String[temList.size()][5];
		newData = temList.toArray(newData);
		return newData;
		
	}
	
	
	@DataProvider(name="ExecutiableScriptList")
	public String[][] getOnlyExecutableScriptList() throws Exception{
		
		
		IDataReader reader = new DataReaderPOI(System.getProperty("user.dir") + "/src/test/resources/scripts/KeywordScript01.xlsx");

		String[][] data = reader.getExcelSheetData("TestCases",true);
	
		//************** Optional *********************
		//*** only need if you want to remove N line from the test case list
		ArrayList<String[]> temList = new ArrayList<String[]>();
		for(int i = 0; i < data.length; i++){
			String[] x = data[i];
			if(x[5].contentEquals("Y")){
				temList.add(x);
			}
		}
		String[][] newData = new String[temList.size()][5];
		newData = temList.toArray(newData);
		return newData;
		
	}
	
	@DataProvider(name="AllScriptList")
	public String[][] getAllScriptList() throws Exception{
		
		
		IDataReader reader = new DataReaderPOI(System.getProperty("user.dir") + "/src/test/resources/scripts/KeywordScript01.xlsx");

		String[][] data = reader.getExcelSheetData("TestCases",true);
		
		return data;
	}
	
	
	
	

}
