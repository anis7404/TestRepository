package com.paxotech.selenium.test;



import org.testng.annotations.Test;

import com.paxotech.selenium.framework.ScriptBase;

public class ShopingCartTest  extends ScriptBase{
	@Test
	public void addToCart() {
		
		heatClinic().homePage().clickLoginLink();
		heatClinic().loginPage().login("iivaan@gmail.com", "ameera");
		//heatClinic().homePage().verifyLoginSuccess("Iftekhar");	
		
		heatClinic().homePage().clickCartLink();
		heatClinic().cart().removeAllItems();
		heatClinic().cart().close();
		
		//heatClinic().homePage().addToCart("Day of the Dead Scotch Bonnet Hot Sauce");
		heatClinic().homePage().addToCartEx("Hoppin' Hot Sauce");
		
		heatClinic().homePage().clickCartLink();
		heatClinic().cart().verifyCartDisplay();
		heatClinic().cart().verifyItemQuantity(1, 1);
		heatClinic().cart().verifyItemPrice(1, "$4.99");
		heatClinic().cart().verifyItemTotalSaving(1, "---");
		heatClinic().cart().verifyItemTotal(1, "$4.99");
		heatClinic().cart().verifySubTotal("$4.99");
		
		heatClinic().cart().changeItemQuantity("Hoppin' Hot Sauce", 2);
		heatClinic().cart().updateItemQuantity("Hoppin' Hot Sauce");
		
		heatClinic().cart().verifyItemQuantity("Hoppin' Hot Sauce", 2);
		heatClinic().cart().verifyItemPrice("Hoppin' Hot Sauce", "$4.99");
		heatClinic().cart().verifyItemTotalSaving("Hoppin' Hot Sauce", "---");
		heatClinic().cart().verifyItemTotal("Hoppin' Hot Sauce", "$9.98");
		heatClinic().cart().verifySubTotal("$9.98");
		
		heatClinic().cart().close();

	}
	
	@Test
	public void addToCart2() {
		
		heatClinic().homePage().clickLoginLink();
		heatClinic().loginPage().login("iivaan@gmail.com", "ameera");
		//heatClinic().homePage().verifyLoginSuccess("Iftekhar");	
		
		
		heatClinic().homePage().addToCart("Day of the Dead Scotch Bonnet Hot Sauce");
		heatClinic().homePage().addToCartEx("Hoppin' Hot Sauce");
				
		heatClinic().homePage().clickCartLink();
		heatClinic().cart().removeAllItemsNotGood();
		heatClinic().cart().close();
		
		

	}
	
	@Test
	public void checkoutTest() {
		
		heatClinic().homePage().addToCart("Day of the Dead Scotch Bonnet Hot Sauce");
		heatClinic().homePage().addToCartEx("Hoppin' Hot Sauce");
				
		heatClinic().homePage().clickCartLink();
		heatClinic().cart().checkout();
		heatClinic().checkoutPage().checkOutAsGuest("iivaan@yahoo.com");
		heatClinic().checkoutPage().billingInformation("Iftekhar", "Ivaan", "4062339429", "398 plainfield Ave", "", "Floral Park", "NY", "11001");
		
		

	}
}
