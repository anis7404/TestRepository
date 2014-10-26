package com.paxotech;

public class ArrayTest {

	public static void main(String[] args) {

/*		String[] myArray;
		// = new String[4];
		int num = 4;
		myArray = new String[num];
		
		myArray[0] = "Iftekhar";
		myArray[1] = "Ameera";*/
		
		
		String[][] myArray;
		myArray = new String[4][4];
		
		myArray[0][0] = "0,0";
		myArray[0][1] = "0,1";
		myArray[0][2] = "0,2";
		myArray[0][3] = "0,3";
		
		myArray[1][0] = "1,0";
		myArray[1][1] = "1,1";
		myArray[1][2] = "1,2";
		myArray[1][3] = "1,3";
		
		myArray[2][0] = "2,0";
		myArray[2][1] = "2,1";
		myArray[2][2] = "2,2";
		myArray[2][3] = "2,3";
		
		myArray[3][0] = "3,0";
		myArray[3][1] = "3,1";
		myArray[3][2] = "3,2";
		myArray[3][3] = "3,3";
		
		for(int i = 0; i < myArray.length; i++){
			for(int j = 0; j < myArray[i].length; j++){
				System.out.print(myArray[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		
		
		
		
		
	}

}
