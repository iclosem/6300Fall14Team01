##**Requirements Document -- Team 01**
###Project 1: Average Sentence Length

###Contents

- [User Requirements](#User Requirements)
  - [Software Interfaces](#software-interfaces)
  - [User Interfaces](#user-interfaces)
  - [User Characteristics](#user-characteristics)
- [System Requirements](#system-requirements)
  - [Functional Requirements](#functional-requirements)
  - [Roles](#Non-Functional Requirements)

####User Requirements

#####Software Interfaces

- **Command Line**, Windows, Linux, Mac
- **File System** : retrieves student essay
- **Java Compiler**
- **Make** (Makefiles for automating building and testing)
- **Java Libraries**: All java libraries are contained within the Standard Library:
```java
//this is the library that is built for filehandling,
//to read the file in as a string use readAllBytes
import java.nio.file.Files; 
//this will help open the file: Paths.get(filename)
import java.nio.file.Paths;
//for testing
import org.junit.Test;
``` 
 
#####User Interfaces

- Command line input
	- Required input: a text input file
	- Optional input: sentence delimiters, minimum word length
- Documentation view or help interface
- Output view 

######User Characteristics

- College students with at least some experience with computer file systems
- Mixed computer proficiency from beginner to advanced
- Experience varies across multiple platforms

####System Requirements

These subsections contain all the software requirements at a level of detail sufficient to enable designers/developers to design/develop a system that satisfies the client’s requirements, and enough detail to allow testers to test that the system satisfies those requirements. This part of the document provides a numbered list of simple, complete, and consistent functional and non-functional requirements.
 
#####Functional Requirements

| Req#  				| Requirement		| Comment						| Priority |
| --------------------- |:---------------------:|:-----------------------------:|:-----:| 
| F_01 | System will produce a friendly feedback message(s) to user, to assist in case of user operational error. | Users may range in levels of technical background  | high
| F_02 | System will output the average (mean) number of words per sentence, rounded down to the nearest integer | | high
| F_03 | System will have flexibility in defining a word by its length of characters | | high
|F_04 | System default for minimum character length defining a word will be set to three |  | high
|F_05 | System allows minimum character length defining a word to set by the user to a positive integer using the flag -l |  | high
| F_06 | System default for sentence delimiters will be .?!; | | high
| F_07 | System allows user to specify sentence delimiters with flag -d | | high
| F_08 | System will compile with javac, java  1.6 or 1.7 | | high
| F_09 | System will be executable from the command line | | high
| F_10 | System will allow for the input of a file path || high 
| F_11 | System will allow the user to input these types of files (TYPES) | | high
| F_12 | System will cap the size of allowed file type at (size) | | medium
| F_13 | System default for character length to define a word set to three. || medium


#####Non-Functional Requirements

| Req#  				| Requirement		| Comment						| Priority |
| --------------------- |:---------------------:|:-----------------------------:|:-----:| 
| NF_01 | System will accommodate up to 270 students  | 45 students per unit, up to 6 units per semester  | high		
| NF_02 | System will run from command line in java-based tool | | medium
| NF_03 | System will provide promts and communication to user in English as standard language || high
| NF_04 | Software is documented well enough for the lowest skill users to operate || medium 
| NF_05 | Software operates at a reasonable speed across all platforms || medium
| NF_06 | Software requires minimal installation steps || medium
| NF_07 | Software documentation is easily accessible || medium
| NF_08 | Software operates at a reasonable speed across all platforms || medium
| NF_09 | Software will process and out put average sentence length in reasonable time || medium
| NF_10 | Software is documented thoroughly enough for the lowest skill users to operate  || medium
| NF_11 | System will give the user a warning when input is null or empty | | medium
| NF_12 | System will be available to user 24 hours a day 7 days a week, with exception of maintenance hours | | medium 
| NF_13 | System upgrade and maintenance will be completed within preaproved time slots | Maintenance hours should not interfe with student's assignment timelines| medium
| NF_14 | System will run on operating systems Mac, Windows and Linux |Students may be working with different operating systems|High


