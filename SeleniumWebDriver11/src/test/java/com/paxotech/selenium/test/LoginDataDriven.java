package com.paxotech.selenium.test;

import java.text.SimpleDateFormat;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;










import com.paxotech.selenium.framework.ScriptBase;
import com.paxotech.selenium.framework.excel.DataReaderPOI;
import com.paxotech.selenium.framework.excel.IDataReader;


public class LoginDataDriven extends ScriptBase {

	IDataReader dataReader = null;
	
	@BeforeClass
	public void beforeClass() throws Exception{
		String fileName = System.getProperty("user.dir") +   "/src/test/resources/testData/HeatclinicTestData.xlsx";
		dataReader = new DataReaderPOI(fileName);
		((DataReaderPOI)dataReader).setSimpleDateFormat(new SimpleDateFormat("MM/dd/yy"));
	}
	
	@Test
	public void validUserValidPassword1() {
		
			heatClinic().homePage().clickLoginLink();
			heatClinic().loginPage().login("iivaan@gmail.com", "ameera");
			heatClinic().homePage().verifyLoginSuccess("Iftekhar");	
			heatClinic().homePage().clickLogoutLink();	
			
	}
	
	@Test
	public void validUserValidPassword2() {
		
			heatClinic().homePage().clickLoginLink();
			heatClinic().loginPage().login("steav@gmail.com", "sam2014");
			heatClinic().homePage().verifyLoginSuccess("Steav");	
			heatClinic().homePage().clickLogoutLink();	
			
	}
	
	
	@Test
	public void validUserValidPasswordDD1() throws Exception {
		
		IDataReader dataReader = null;
		String fileName = System.getProperty("user.dir") +   "/src/test/resources/testData/HeatclinicTestData.xlsx";
		dataReader = new DataReaderPOI(fileName);
		((DataReaderPOI)dataReader).setSimpleDateFormat(new SimpleDateFormat("MM/dd/yy"));
		
		String[][] data = dataReader.getExcelSheetData("Sheet2");
		
		for(int i = 1; i < data.length; i++){
			
			heatClinic().homePage().clickLoginLink();
			heatClinic().loginPage().login(data[i][0], data[i][1]);
			heatClinic().homePage().verifyLoginSuccess(data[i][2]);	
			heatClinic().homePage().clickLogoutLink();	
			
		}	
	}
	
	
	@Test(dataProvider="dp2")
	public void validUserValidPasswordDD2(String userid, String password, String userName) throws Exception {
			
		heatClinic().homePage().clickLoginLink();
		heatClinic().loginPage().login(userid, password);
		heatClinic().homePage().verifyLoginSuccess(userName);	
		heatClinic().homePage().clickLogoutLink();		
		
	}
	
	
	@Test(dataProvider="dp3")
	public void validUserValidPasswordDD3(String testCase, String description, String rowId) throws Exception {
		
		String[] data = dataReader.getExcelRowData("Sheet2", new Integer(rowId.split("\\.")[0]));
		
		heatClinic().homePage().clickLoginLink();
		heatClinic().loginPage().login(data[0], data[1]);
		heatClinic().homePage().verifyLoginSuccess(data[2]);	
		heatClinic().homePage().clickLogoutLink();		
		
	}
	
	
	@DataProvider(name="dp1")
	public String[][] getTestData() throws Exception{
		
		IDataReader dataReader = null;
		String fileName = System.getProperty("user.dir") +   "/src/test/resources/testData/HeatclinicTestData.xlsx";
		dataReader = new DataReaderPOI(fileName);
		((DataReaderPOI)dataReader).setSimpleDateFormat(new SimpleDateFormat("MM/dd/yy"));
		
		String[][] data = dataReader.getExcelSheetData("Sheet2",true);
		
		return data;
		
	
	}
	
	@DataProvider(name="dp2")
	public String[][] getTestData2() throws Exception{
	
		String[][] data = new String[2][3];
		
		data[0][0] = "iivaan@gmail.com" ;
		data[0][1] = "ameera" ;
		data[0][2] = "Iftekhar" ;
		
		data[1][0] = "iivaan@gmail.com" ;
		data[1][1] = "ameera" ;
		data[1][2] = "Iftekhar" ;
		
		return data;
	}
	
	@DataProvider(name="dp3")
	public String[][] getTestData3() throws Exception{
		
		String[][] data = dataReader.getExcelSheetData("Sheet1",true);
		
		return data;
	}
	
	
	
}
