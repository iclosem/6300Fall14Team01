## **iScream - User Manual** 

##### CS6300 Fall 2014 Team 01

Contents
-----------------

- [Introduction](#introduction)
  - [Scope and Purpose](#scope-and-purpose)
  - [Process Overview](#process-overview)
  - [Process a Purchase](#process-a-purchase)
  - [Process a Preorder](#process-a-preorder)
  - [Edit VIP Customer Data](#edit-vip-customer-data)
  - [Daily Sales Report](#daily-sales-report)
  - [Create a VIP Customer](#create-a-vip-customer)
- [Appendix](#appendix)
  - [Team Members](#team-members)

## Introduction

#### Scope and Purpose

iScream is a mobile device application designed to manage sales and customer data for an ice cream cart business.  It allows the creation and maintenance of a database of "VIP" customers and tracks rewards these customers earn based on their continued patronage. 

This User manual outlines the basic operation of iScream including instructions for all of the application features and how each feature is intended to be used during normal business operation. Minimal previous mobile device experience is required for the user, and it is assumed that the user is fully trained on the operation of the ice cream cart business and its reward system for VIP customers.  

The mobile device utilized must run the Android operating system version 4.4.2 (API 19 Kit Kat).


#### Process Overview

iScream manages 5 basic user input scenarios represented by tabs on the application's main screen. 

1.	Process a Purchase - the **SELL PRODUCT** Screen.
2.	Process a Preorder - the **PREORDER PRODUCT** Screen.
3.	Review, Edit, delete VIP customer data - the **MANAGE VIP** Screen.
4.	Pull a daily Sales report - the **GENERATE REPORTS** Screen.
5.	Create VIP customer - the **CREATE VIP** Screen.

[Charts built with yuml...editing link here](http://yuml.me/edit/5b927c22)
![Cart Manager](http://yuml.me/5b927c22)

#### Process a Purchase

- To process a puchase, select the **SELL PRODUCT** button from the main interface
  - If the customer is a VIP, select their name from the sliding list of VIP names in the middle of the Sell screen.
  - Select the items to be purchased from the item selection sliding menu (top of the screen) to add them to the shopping cart.
  - For multiples of the same item, simply tap the same listed item more than once.
  - Discounts and free item credits are applied automatically.
  - Tap the "Purchase" button to record the purchase.
  - Tap the "Clear" button to clear the cart and start over without processing the purchase.   

#### Process a Preorder

- To process a preorder, select the **PREORDER PRODUCT** button from the main interface
  - Select the VIP customer's name from the sliding list in the middle of the Preorder screen (required).
  - Select the items to be purchased from the item selection sliding menu (top of the screen) to add them to the shopping cart.
  - Enter the pickup date in the designated text box (format: YYYY-MM-DD).
  - Tap the "Preorder" button to record the preorder.
  - If sufficient preorder slots are not available for the date requested, an error message will be returned asking the user to choose a different pickup date or quantity.
  -  Tap the "Clear" button to clear the cart and start over without processing the preorder. 
 
#### Edit VIP Customer Data

- To review, edit or delete VIP customer data, select the **MANAGE VIP** button from the main interface.  
	- Enter the Customer VIP ID
	- Tap the "Retrieve" button to bring up the customer's data.
	- Edit the fields as needed and tap the "Save" button to record changes.
	- Tap the "Delete" button to remove the VIP customer from the database.
	- Tap the "List" button to see the entire VIP customer list.

#### Daily Sales Report

- To access the sales reports features, select the **GENERATE REPORTS** button from the main interface.
	- Sales and Preorders 
		- Select the desired date
		- For the daily sales report, select the Daily Sales Report button.
		- For the daily preorders report, select the Daily Preorders button.
	- VIP data
		- Enter the VIP number in the VIP ID text box.
		- For the full purchase history, tap the Purchase History button.
		- For the 30 day purchase history, tap the 30 Day Purchases button. 


#### Create a VIP Customer

- To create a new VIP customer select the **CREATE VIP** button from the Main Interface
	- Enter the customer name, address and birth date in the appropriate fields.
	- Tap the "Register" button to add the customer to the VIP database.  
	- The customer's VIP ID will be displayed.  Provide this to the customer.
	




## Apendix

### Troubleshooting:
- **Caution**: _DO NOT_ clear the application data from the "Settings" menu of your device without backing up iScream.  This will result in the loss of all customer and sales data.  Consult your device and/or provider documentation for the most effective way to back up your app data.

### Contacts
- For user support, contact any of our team members below.
 

#### Team Members:

| Name  				| GATECH Username		| E-mail						| Alias |
| --------------------- |:---------------------:|:-----------------------------:|:-----:| 
| [Alex Bowers Schoen](http://github.com/bowersaa )  	| abowers9				| alexandra.bowers@gmail.com 	| [ABS](http://github.com/bowersaa )   |
| [Alex Hortin](http://github.com/hortinstein) 	 		| ahortin3				| hortinstein@gmail.com  		| [AH](http://github.com/hortinstein )    |
| [Charles Cone](http://github.com/ccone8)  	 		| ccone8		        | charlesprestoncone@gmail.com  | [CC](http://github.com/ccone8 )    |

