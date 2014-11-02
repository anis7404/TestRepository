package com.paxotech.selenium.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyTestClass {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("I am in @BeforeClass");
	}
	
	@Before
	public void setUp() throws Exception {
		System.out.println("I am in @Before");
	}

	@Test
	public void test1() {
		System.out.println("I am in test1");
	}
	@Test
	public void test2() {
		System.out.println("I am in test2");
	}
	@Test
	public void test3() {
		System.out.println("I am in test3");
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("I am in @After");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("I am in @AfterClass");
	}

	

}
