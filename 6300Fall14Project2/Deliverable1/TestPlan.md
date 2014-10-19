# Test Plan

**Author**: [CS6300 Fall 2014 Team #1](https://github.com/gt-ud-softeng/6300Fall14Team01) 

## 2 Testing Strategy

### 2.1 Overall strategy

Our overall testing strategy will be a mix of black-box and white-box testing. We will attempt to verify all user interactions with manual testing, and verify calculations with JUnit testing.

### 2.2 Test Selection

Test cases will be selected based on level of functionality and ability of the user to directly interact with the functionality.

In order to test the base functionality (database connectivity, computational functions), we will use automated JUnit testing in a white-box testing strategy. 

In order to test UI functionality, we will use black-box testing techniques with manual testing based off of scripts. Tests will be created to cover the use cases stated in the Use Case model.

### 2.3 Adequacy Criterion

We will verify the adequacy of our black-box testing by ensuring all use cases and user screens have testing associated with them. We will also verify that functions involving calculations are covered with JUnit testing, both negative and positive tests.  

### 2.4 Bug Tracking

Bugs will be tracked with a [Google spreadsheet](https://docs.google.com/forms/d/1gytVHrfrbv2MI5VQauExF8aECjGkEsM3ZttJiNqXxU4/viewform), with issues submitted through a form. 

The form will include fields for:
- Description
- Type of Bug
	- Bug
	- UI Issue
	- Investigation
	- Feature
	- Other categories as needed
- Priority


### 2.5 Technology

We intend to use JUnit to create any automated testing.


## 4 Test Cases


| Case Number | Purpose             | Steps                                                                                               | Expected Result                                     | Actual Result | Pass/Fail information | Tester's Initials | Notes |
|:-------------:|---------------------|-----------------------------------------------------------------------------------------------------|-----------------------------------------------------|---------------|-----------------------|:-------------------:|-------|
| 1           | System Start        | Open App                                                                                            | App Opens                                           |               |                       |                   |       |
| 2           | Create VIP Customer | <ul><li>Select VIPS tab</li><li>Select New User</li><li>Enter Customer's name</li><li>Enter Customer's address</li><li>Enter Customer's DOB</li><li>Click Create User</li></ul> | User is created with correct Name, Address, and DOB |               |                       |                   |       |
| 3           | Order Product | <ul><li>Select Sell tab</li><li>Select product</li><li>Select VIP Customer</li><li>Click Purchase</li></ul>|Verify that Purchase was made  |                       |                   |       |
| 4           |Points awarded on purchase| <ul><li>Check a VIP's points count</li><li>Complete a purchase for that VIP</li><li>Check the VIP's points status again</li></ul>|VIP's points should have increased by the whole dollar amount of the purchase|                       |                   |       |
| 5           | Generate Daily Report|<ul><li>Select Report Tab</li><li>Enter date</li><li>Click Generate</li></ul>| Daily report should be generated |                       |                   |       |
| 6           |Free Ice cream awarded on 50 points|<ul><li></li><li></li><li></li></ul>|VIP should have a free purchase award|                       |                   |       |
| 7           |Check VIP status|<ul><li>Select VIPS tab</li><li>Select VIP customer</li></ul>|Verify that their Name, Address, DOB, Points and status are displayed|                       |                   |       |
| 8           |Search Number|<ul><li>Select VIPS tab</li><li>Enter a current VIP's VIP number</li><li>Search</li></ul>| Verify that their Name, Address, DOB, Points and status are displayed |                       |                   |       |
| 9           | Create Preorder |<ul><li>Select Preorder Tab</li><li>Select Pickup date</li><li>Select VIP customer</li><li>Select Product</li><li>CLick Preorder</li></ul>|Preorder created|                       |                   |       |
| 10          | Check Daily report's correctness |<ul><li>Generate report for current day, note number of products sold and preorders</li><li>Create purchases and preorders for that date</li><li>Check daily report again</li></ul>|Numbers of purchases and preorders should have changed by the appropriate amount|                       |                   |       |
| 11          | Edit VIP's info |<ul><li>Select VIP customer</li><li>CLick Edit</li><li>Edit customer's information</li><li>Click save</li><li>Click on same customer again</li></ul>|Customer's information has been changed|                       |                   |       |
| 12          | Delete VIP|<ul><li>Select VIP</li><li>Click Delete</li><li>Click "Yes"</li><li>Search for VIP again</li></ul>|VIP Cusotmer is not found   |                       |                   |       |
| 13          | Process non-VIP sale |<ul><li>Select Purchase Tab</li><li>Select Product</li><li>Do not select VIP customer</li></ul>|Purchase completed without VIP customer|  |                 |       |
| 14          | Purchase Product with Reward |<ul><li>Select Purchase Tab</li><li>Select product</li><li>Select VIP customer with free rewards pending</li><li>Use the freebie to make purchase</li></ul>| Product is purchased, VIP customer's freebies are depleted by appropriate amount, rewards are not given, and daily report is updated appropriately    |                       |                   |       |
| 15          | Points not awarded on Preorder until pickup |<ul><li></li><li></li><li></li></ul>|               |                       |                   |       |
| 16          | Verify Gold Rewards |   <ul><li>Find customer with Gold Rewards earned</li><li></li><li></li></ul>|               |                       |                   |       |
| 17          | |    <ul><li></li><li></li><li></li></ul> |               |                       |                   |       |
| 18          | |   <ul><li></li><li></li><li></li></ul> |               |                       |                   |       |
| 19          | |   <ul><li></li><li></li><li></li></ul> |               |                       |                   |       |
| 20          | |   <ul><li></li><li></li><li></li></ul> |               |                       |                   |       |
| 21          | |   <ul><li></li><li></li><li></li></ul> |               |                       |                   |       |
| 22          | |                                                                                                     |                                                     |               |                       |                   |       |
| 23         | |                                                                                                     |                                                     |               |                       |                   |       |
| 24         | |                                                                                                     |                                                     |               |                       |                   |       |
