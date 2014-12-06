package com.paxotech.test;

import java.text.SimpleDateFormat;

import selenium.datareader.DataReaderJXL;
import selenium.datareader.DataReaderPOI;
import selenium.datareader.IDataReader;

public class MyTest {

	public static void main(String[] args) throws Exception {
		
		IDataReader dataReader = null;
		
		//String fileName = System.getProperty("user.dir") +   "/src/test/resources/data/StudentData.xls";
		//dataReader = new DataReaderJXL(fileName);
		

		String fileName = System.getProperty("user.dir") +   "/src/test/resources/data/StudentData.xlsx";
		dataReader = new DataReaderPOI(fileName);
		((DataReaderPOI)dataReader).setSimpleDateFormat(new SimpleDateFormat("MM/dd/yy"));
		
		
		
		String[][] myData1 = dataReader.getExcelSheetData("Sheet1");
		for(int i = 0; i < myData1.length; i++){
			for(int j = 0; j < myData1[i].length; j++){
				System.out.print(myData1[i][j]);
				System.out.print(",");
			}
			System.out.println();
		}
		
		String[][] myData2 = dataReader.getExcelSheetData(0);
		for(int i = 0; i < myData2.length; i++){
			for(int j = 0; j < myData2[i].length; j++){
				System.out.print(myData2[i][j]);
				System.out.print(",");
			}
			System.out.println();
		}
		
		
		/*String[] data = dataReader.getExcelRowData("Sheet1", 1);
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i]);
			System.out.print(",");
		}*/
		
/*		String[] data = dataReader.getExcelRowData(0, 1);
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i]);
			System.out.print(",");
		}*/
		
/*		String[] data1 = dataReader.getExcelColData("Sheet1", 1);
		for(int i = 0; i < data1.length; i++){
			System.out.print(data1[i]);
			System.out.print(",");
		}
		System.out.println();
		String[] data2 = dataReader.getExcelColData(0, 1);
		for(int i = 0; i < data2.length; i++){
			System.out.print(data2[i]);
			System.out.print(",");
		}*/
		
		/*String data1 = dataReader.getExcelCellData("Sheet1", 1, 0);
		System.out.println(data1);
		
		String data2 = dataReader.getExcelCellData(0, 1, 0);
		System.out.println(data2);*/
		
		
		
	}

}
