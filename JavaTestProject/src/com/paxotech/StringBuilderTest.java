package com.paxotech;

public class StringBuilderTest {

	public static void main(String[] args) {

		String text = "I am |";
		StringBuilder sb  = new StringBuilder(text);
		
		sb.append("Iftekhar");
		sb.append(" ").append("Alam").append(" ").append("Ivaan");
		
		int ind = sb.indexOf("|");
		sb.deleteCharAt(ind);
		
		sb.replace(2, 4, "was");
		
		text = sb.toString();
		
		System.out.println(text);
		
		
		String x;
		x = "I am ";
		x  = x + "Iftekhar";
		
	}

}
