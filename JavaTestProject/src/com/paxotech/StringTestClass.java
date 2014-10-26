package com.paxotech;

public class StringTestClass {

	public static void main(String[] args) {

		//String text = new String(); 
		//text = "Iftekhar Ivaan";
		
		String text;
		//text = " Iftekhar Alam Ivaan ";
		text = " Ameera| Zamani Iftekhar ";
		
		//int numx = 6;
		
		//Integer num2 = new Integer("6");
		//Integer num = 6;
		
	
		//text = text.toUpperCase();
		
		//text = text.toLowerCase();
		
		if(text.trim().contentEquals("Iftekhar Alam Ivaan")){
			System.out.println("Hi");
		}
		
		System.out.println(text.toUpperCase());
		//System.out.println(temp);
		
		System.out.println(text.length());
		
		System.out.println(text);
		System.out.println(text.replaceFirst(" ", ""));
		System.out.println(text.replaceAll(" ", ""));
		
		System.out.println(text.trim().endsWith("Ivaan"));
		System.out.println(text.trim().startsWith("Iftekhar"));
		System.out.println(text.trim().contains("Alam"));
		
		System.out.println(text.trim().substring(9,13));
		
		System.out.println(text.trim().substring(text.trim().indexOf(" ") + 1,text.trim().indexOf(" ", text.trim().indexOf(" ") + 1)));
		
		
		int firstSpace = text.trim().indexOf(" ");
		int secondSpace = text.trim().indexOf(" ", firstSpace + 1);
		
		String middleName = text.trim().substring(firstSpace + 1,secondSpace);
		
		System.out.println(middleName);
		
		char[] ch = text.toCharArray();
		for(int i = 0; i < ch.length; i++){
			System.out.println(ch[i] + ": " + (int) ch[i]);
		}
		
		int p = 124;
		char cha = (char) p;
		
		
		//System.out.println(text.trim().replace((char) 124, (char) 32));
		System.out.println(text);
		text = text.trim().replace((char) 124, (char) 32);
	
		System.out.println(text);
		
	 	System.out.println(text.charAt(2));
	 	
	 	
	 	  String str1 = "Strings are immutable";
	      String str2 = "Strings Are immutable";
	      String str3 = "Integers are not immutable";

	      int result = str1.compareToIgnoreCase( str2 );
	      System.out.println(result);
		  
	      result = str2.compareToIgnoreCase( str3 );
	      System.out.println(result);
		 
	      result = str3.compareToIgnoreCase( str1 );
	      System.out.println(result);
		
	}

}
