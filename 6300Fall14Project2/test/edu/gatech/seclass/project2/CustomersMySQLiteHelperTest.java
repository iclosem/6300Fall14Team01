package edu.gatech.seclass.project2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;


//following testing methodology here
//http://stackoverflow.com/questions/8499554/android-junit-test-for-sqliteopenhelper
public class CustomersMySQLiteHelperTest extends AndroidTestCase  {

	 private CustomersMySQLiteHelper db;

	 public void setUp(){
		 RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
		 db = new CustomersMySQLiteHelper(context);
	 }

	 public void testAddEntry(){
		 
		 ///adding new customer
		 Customer newCust = new Customer("Pickles McGee", "2013-12-01", "123 Main St.");
		 db.addCustomer(newCust);
		 //retrieving list of customers
		 List<Customer> list = new ArrayList<Customer>();
		 list = db.getCustomers();
		 Customer cust = list.get(0);
		 for(Customer customer: list){
			 assertEquals("customer created in DB", customer.getName(), "Pickles McGee");
		 }
	 }
	 public void testRmEntry(){
		 //adding another customer
		 Customer newCust = new Customer("Pickles McGee", "2013-12-01", "123 Main St.");
		 db.addCustomer(newCust);
		 List<Customer> list = new ArrayList<Customer>();
		 list = db.getCustomers();
		 Customer cust = list.get(0);
		 db.deleteCustomer(cust);
		 list = new ArrayList<Customer>();
		 assertEquals("no customers should be in list", list.size(), 0);
	 }
	 
	 public void testEditEntry(){
		 //adding another customer
		 Customer newCust = new Customer("Pickles McGee", "2013-12-01", "123 Main St.");
		 db.addCustomer(newCust);
		 List<Customer> list = new ArrayList<Customer>();
		 list = db.getCustomers();
		 Customer cust = list.get(0);
		 cust.awardPoints(100000);
		 db.updateCustomer(cust);
		 list = db.getCustomers();
		 cust = list.get(0);
		 for(Customer customer: list){
			 assertEquals("customer created in DB", customer.getVIPPointsTotal(), 100000);
		 }
	 }

	 public void tearDown() throws Exception{
		 db.close(); 
		 super.tearDown();
	 }
}
