# Design Document

**Author**: [CS6300 Fall 2014 Team #1](https://github.com/gt-ud-softeng/6300Fall14Team01) 

## 1 Design Considerations

### 1.1 Assumptions

  - Initially there are  not have concurrent access requirements
  - Android will be the systems platform
  - Android Hardware will support android API level 19

### 1.2 Constraints

  - The system requires persistent state
  - The system requires keeping track of multiple customers


### 1.3 System Environment

  - The system must function on Kit-Kat, API level 19 Android, ie Nexus 4 or newer
  
## 2 Architectural Design

The architecture provides the high-level design view of our system and provides a basis for more detailed design work. These subsections describe the top-level components of the system and their relationships.

### 2.1 Component Diagram

*This section should provide and describe a diagram that shows the various components and how they are connected. This diagram shows the logical/functional components of the system, where each component represents a cluster of related functionality. In the case of simple systems, where there is a single component, this diagram may be unnecessary; in these cases, simply state so and concisely state why.*

### 2.2 Deployment Diagram

This section describes how the different components will be deployed on actual hardware devices. 


[Charts built with yuml...editing link here](http://yuml.me/edit/7f384fe4)

![](http://yuml.me/7f384fe4)


## 3 Low-Level Design

Here the low-level design for each of the system components is shown. For each component, details are provided in the following UML diagrams to show its internal structure.

### 3.1 Class Diagram

This section shows the relationship of our classes.

[Charts built with yuml...editing link here](http://yuml.me/edit/54bf3642)
![](http://yuml.me/54bf3642)

*In the case of an OO design, the internal structure of a software component would typically be expressed as a UML class diagram that represents the static class structure for the component and their relationships.*

### 3.2 Other Diagrams

### 3.2.1 Sequence (optional)

### 3.2.2 State (option)

## 4 User Interface Design
[Charts built with lucidchart...editing link here](http://www.lucidchart.com/invitations/accept/52005991-2e84-40f0-af78-d7e0be970d2d)

### 4.1 Sell
This mockup would allow for the sale of ice cream

![](http://i.imgur.com/0P7eDRnl.png)

### 4.2 Preorder 
This mockup would allow for the preorder of ice cream

![](http://i.imgur.com/uDnYPtGl.png)

### 4.3 Vip 
This mockup would allow for the checking of VIP status

![](http://i.imgur.com/UVN0sLwl.png)

### 4.4 Report 
This mockup generates the required report

![](http://i.imgur.com/0vvLipPl.png)

### 4.5 Create 

This mockup would allow for the creation of users

![](http://i.imgur.com/l39y5Wkl.png)
