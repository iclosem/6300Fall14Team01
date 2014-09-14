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
- **File System** : retrieves student essay from user specified file path
- **Java Compiler**
- **Make** (Makefiles for automating building and testing)
- **Java Libraries**: all java libraries are contained within the Standard Library:
```java
//this is the library that is built for file handling,
//to read the file in as a string use readAllBytes
import java.nio.file.Files; 
//this will help open the file: Paths.get(filename)
import java.nio.file.Paths;
//for testing
import org.junit.Test;
``` 
 
#####User Interfaces

- Command line input
	- Required input: a text input file path 
	- Optional input: sentence delimiters and/or minimum word length 
- Documentation view or help interface
- Output view


######User Characteristics

- College students with at least some experience with computer file systems
- Mixed computer proficiency from beginner to advanced
- Experience varies across multiple platforms

####System Requirements

#####Functional Requirements

| Req#  				| Requirement		| Comment						| Priority |
| --------------------- |:---------------------:|:-----------------------------:|:-----:| 
| F_01.0 | System will produce a friendly feedback message(s) to user, to assist in case of user operational error. | Users may range in levels of technical background  | high
| F_02.0 | System will output the average (mean) number of words per sentence, rounded down to the nearest integer | | high
| F_03.0 | System will have flexibility in defining a word by its length of characters |The professor is not interested in counting smaller words when averaging the length of a sentence. | high
|F_03.1 | System default for minimum character length defining a word will be set to three |  | high
|F_03.2 | System allows minimum character length defining a word to set by the user to a positive integer using the flag -l | | high
| F_04.0 | System allows user to specify sentence delimiters with flag -d |i.e. Should allow user to select a comma ',' as a sentence delimiter | high
| F_04.1 | System default for sentence delimiters will be .?!; || high
| F_05.0 | System will compile with javac, java  1.6 or 1.7 | | high
| F_06.0 | System will be executable from the command line | | high
| F_7.0 | System will allow for the input of a file path || high 
| F_7.1 | System will retrieve file from the file path specified by user || high 
| F_7.2 | System will allow the user to input these types of files (TYPES) | | high
| F_7.3 | System will cap the size of allowed file type at (size) | | medium
| F_7.4 | System will notify user if cap of file size exceeded) | | medium



#####Non-Functional Requirements

| Req#  				| Requirement		| Comment						| Priority |
| --------------------- |:---------------------:|:-----------------------------:|:-----:| 
| NF_01.0 | System will accommodate up to 270 students  | 45 students per unit, up to 6 units per semester  | high		
| NF_02.0 | System will run from command line in java-based tool | | medium
| NF_03.0 | System will provide prompts and communication to user in English as standard language || high
| NF_04.0 | Software is documented well enough for the lowest skill users to operate || medium 
| NF_04.1 | Software documentation will provide further information on error messages to assist user running system properly|| medium
| NF_04.2 | Software documentation will provide operational steps to assist user running system properly|| medium
| NF_04.3 | Software documentation will provide installation steps to assist user installing system properly| |medium
| NF_04.4 | Software documentation is easily accessible || medium
| NF_4.5 | Software is documented thoroughly enough for the lowest skill users to operate  || medium
| NF_4.6 | Software documents the defaults for minimum word length and sentence delimiters  || medium
| NF_05.0 | Software operates at a reasonable speed across all platforms || medium
| NF_06.0 | Software requires minimal installation steps |Users range in technical skills, installation should be minimal in steps| medium
| NF_7.0 | System will run on operating systems Mac, Windows and Linux |Students may be working with different operating systems|high
| NF_07.1 | Software operates at a reasonable speed across all platforms || medium
| NF_09.0 | Software will process and output average sentence length in reasonable time || medium
| NF_11.0 | System will give the user a warning when input is null or empty | | medium
| NF_12.0 | System will be available to user 24 hours a day 7 days a week, with exception of maintenance hours | | medium
| NF_12.1 | System upgrade and maintenance will be completed within pre-approved time slots | Maintenance hours should not interfere with student's assignment timelines| medium



