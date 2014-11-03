package edu.gatech.seclass.project2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createCustomerTest(){
		Customer newCust = new Customer("Pickles McGee", "01/02/03", "123 Main St.");
		assertEquals("Created cust", newCust.getName(), "Pickles McGee");
	}
	
	public void newCustomerTest(){
		Customer newCust = new Customer("Pickles McGee", "01/02/03", "123 Main St.");
		assertEquals("new cust", newCust.getVIPPointsTotal(), 0);
	}

}
