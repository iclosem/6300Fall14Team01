##**Requirements Document -- Team 01**
###Project 1: Average Sentence Length

###Contents

- [User Requirements](#User Requirements)
  - [Software Interfaces](#software-interfaces)
  - [User Interfaces](#user-interfaces)
  - [User Characteristics](#user-characteristics)
- [System Requirements](#system-requirements)
  - [Functional Requirements](#functional-requirements)
  - [Non-Functional Requirements](#Non-Functional Requirements)

####User Requirements

#####Software Interfaces

- **Command Line**, Windows, Linux, Mac
- **File System** : Retrieves student essay from user-specified file path
- **Java Compiler**
- **Make** (Makefiles for automating building and testing)
- **Java Libraries**: All java libraries are contained within the Standard Library:
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
| F_1.01 | System will produce a friendly feedback message to user if cap of file size is exceeded. "The file selected has exceeded the allowed file size of 50KB. Please confirm the correct file has been selected and/or modify the text file to fit within the sizing constraints."  | | medium
| F_1.02 | System will produce a friendly feedback message to user if file path input is not successful in loading file. "The file path that has been input was not successful, please re-enter file path.” | | medium
| F_1.03 | System will produce a friendly feedback message to user if sentence delimiters are not input correctly. "Sentence delimiters were not input correctly. Please retry or reference the help view.” | | medium
| F_1.04 | System will produce a friendly feedback message to user if defining word length not input correctly. "Minimum number of characters used to define a word was not input correctly. Please retry using a positive integer or reference the help view.” | | medium
| F_1.05 | System will produce a friendly feedback message to user when input is null or empty. "The .txt file being accessed is empty. Please confirm proper file path was used." | | medium
| F_1.06 | System will produce a friendly feedback message to user when processing exceeds three (3) seconds. "System loading, please be patient."| | low
| F_02.0 | System will output the average (mean) number of words per sentence, rounded down to the nearest integer | | high
| F_02.1 | System will output the constraints for word length used to calculate average sentence length | | low
| F_02.2 | System will output the constraints for sentence delimiters used to calculate average sentence length | | low
| F_03.0 | System will have flexibility in defining a word by its minimum length of characters. |The professor is not interested in counting smaller words when averaging the length of a sentence. | high
| F_03.0 | System will accept values between 1-15 to define a word by its minimum length of characters. | | medium
|F_03.1 | System default for minimum character length defining a word will be set to three |  | high
|F_03.2 | System allows minimum character length defining a word to set by the user to a positive integer using the flag -l | | high
| F_04.0 | System allows user to specify sentence delimiters with flag -d |e.g. Should allow user to select a comma ',' as a sentence delimiter | high
| F_04.1 | System default for sentence delimiters will be .?!; || high
| F_05.0 | System will compile with javac, java  1.6 or 1.7 | | high
| F_06.0 | System will be executable from the command line | | high
| F_7.0 | System will allow for the input of a file path || high 
| F_7.1 | System will retrieve file from the file path specified by user || high 
| F_7.2 | System will allow the user to input .txt files consisting of the UTF-8 character set | | high
| F_8.0 | System will provide feedback on which sentences within the essay are exceeding the average number of words per sentence| This would be a nice addition but was not requested| low 






#####Non-Functional Requirements

| Req#  				| Requirement		| Comment						| Priority |
| --------------------- |:---------------------:|:-----------------------------:|:-----:| 
| NF_01.0 | System will accommodate up to 270 students  | 45 students per unit, up to 6 units per semester  | high		
| NF_02.0 | System will run from command line in java-based tool | | medium
| NF_03.0 | System will provide prompts and communication to user in English as standard language || high
| NF_4.0 | Software is documented thoroughly enough for the lowest skill users to operate  || medium
| NF_04.1 | Software documentation will provide further information in error messages to assist user running system properly|| medium
| NF_04.2 | Software documentation will provide operational steps to assist user running system properly|| medium
| NF_04.3 | Software documentation will provide installation steps to assist user installing system properly| |medium
| NF_04.4 | Software documentation is accessible via a user manual in Markdown format || medium
| NF_4.6 | Documentation indicates the defaults for minimum word length and sentence delimiters  || medium
| NF_5.0 | System will cap the size of allowed file type at 50KB | | medium
| NF_06.0 | Software requires minimal installation steps |Users range in technical skills, installation should be minimal in steps| medium
| NF_7.0 | System will run on operating systems Mac, Windows and Linux |Students may be working with different operating systems|high
| NF_08.0 | Software operates at a reasonable speed across all platforms || medium
| NF_08.1 | Software will process and output average sentence length in three (3) seconds || medium
| NF_08.2 | Software will load input file within three (3) seconds || medium
| NF_9.0 | System will be available to user 24 hours a day 7 days a week, with exception of maintenance hours | | medium
| NF_9.1 | System upgrade and maintenance will be completed within pre-approved time slots | Maintenance hours should not interfere with student's assignment timelines| medium




