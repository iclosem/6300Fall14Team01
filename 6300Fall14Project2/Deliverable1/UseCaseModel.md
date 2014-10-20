## Use Case Model

**Author**: [CS6300 Fall 2014 Team #1](https://github.com/gt-ud-softeng/6300Fall14Team01)
 
### 1) Use Case Diagram

[Charts built with yuml...editing link here](http://yuml.me/edit/26df9b41)
![Cart Manager](http://yuml.me/26df9b41)

### 2) Use Case Descriptions

#### **Cart Manager - Edit VIP** 
- **Requirements**: Allows the cart manager to make changes to the VIP customer database, including the creation and removal of VIP customers.
- **Pre-conditions**: The cart manager must have customer data to add, change or remove from the VIP database
- **Post-conditions**: the VIP database must be intact and updated per according to the cart manager's needs. 
- **Scenarios**:
  - 1. A customer requests VIP status.  The manager will input name, address, birth date, etc and save the customer as a VIP, which will generate a VIP ID # and a new database entry which will track points and rewards.
  - 2. A customer's information has changed.  The manager will update the customer's database entry with the new information.
  - 3. A customer has lost his VIP privileges.  The manager will recall and erase this customer's VIP database entry.
  
   
	
#### **Cart Manager - Process Purchase**
- **Requirements**: The cart manager logs the purchase of an item and, if applicable, updates the customer's VIP database entry with any VIP points or rewards accrued or redeemed.  The purchase is also entered into the Sales database for the cart for reporting purposes.
- **Pre-conditions**: the manager has made a sale.
- **Post-conditions**: the purchase is logged into the appropriate databases for tracking sales and VIP rewards.
-  **Scenarios**:
  - 1. A non-VIP customer buys an ice cream.  The cart manager will log this purchase into the application as a non-VIP sale, which will update only the Sales database with the purchase information.
  - 2. A VIP customer buys a frozen yogurt.  The cart manager will log this purchase under the customer's VIP ID which will apply any discounts and update both the VIP database with points accrued and the Sales database with the purchase information.  
		    		
#### **Cart Manager - Process Preorder**  
- **Requirements**: The cart manager takes and reserves an ice cream preorder for a VIP customer.  This can be done up to 1 week in advance provided there are available preorder slots for the cart on the date requested.  This is logged as a preorder in the Sales database on the day the preorder is requested.
- **Pre-conditions**: The cart manager has a preorder to process.
- **Post-conditions**: either the pre-order is logged into the sales database or the customer is notified that there are no preorder slots remaining.
- Scenarios:
  - 1. A VIP customer requests a preorder for an ice cream for 11/15/2014.  The cart manager determines there is availability of slots for that date via the sales database and reserves the ice cream for the customer in the Sales Database.


#### **Cart Manager - Generate Daily Report**
- **Requirements**: the cart manager pulls a report from the sales database which shows all purchases and preorders taken on the requested date.  
- **Pre-conditions**: a report is needed by the Cart Manager
- **Post-conditions**: a report is generated.
- **Scenarios**: 
  - 1. The cart manager wants to know what was purchased and preordered at his cart on 11/15/2014.  He enters the date into the application and the report is output to the device.
