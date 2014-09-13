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

- Command line input, requires input of sentance delimiters and a text input file
- Documentation view or help interface.
- Output view 

######User Characteristics

- College students with at least some experience with computer file systems.
- Mixed computer proficiency from beginner to advanced.
- Experience varies across multiple platforms.

####System Requirements

These subsections contain all the software requirements at a level of detail sufficient to enable designers/developers to design/develop a system that satisfies those requirements, and testers to test that the system satisfies those requirements. This part of the document should provide a numbered (possibly hierarchical) list of simple, complete, and consistent functional and non-functional requirements.
 
#####Functional Requirements

- Output average sentence length. 

| Req#  				| Requirement		| Comment						| Priority |
| --------------------- |:---------------------:|:-----------------------------:|:-----:| 
| F_01 | System should produce a friendly feedback message(s) to user, to assist in case of user operational error. | Users ranging in levels of technical	background  | high				
| F_02 | System should have flexibility in defining a word by it's length of characters | | high
|F_03 | System default ffor character length defining a word should be set to three |  | medium
| F_04 | System should allow user to specifiy sentence delimiters with switch -d. (eg ,;.?!) | | High
|F_05 | System default for punctuation defining a sentance should exclude comma | | medium
| F_06 | System should provide user the average length of their sentences as an end result  || high
| F_07 | System should compile with javac, java  1.6 or 1.7 | | high
| F_08 | System should be executable from the command line | | high
| F_09 | SYstem should allow for the input of a file path || high 
| F_10 | System should output the average sentance length | | high

#####Non-Functional Requirements

| Req#  				| Requirement		| Comment						| Priority |
| --------------------- |:---------------------:|:-----------------------------:|:-----:| 
| NF_01 | System should accomodate up to 270 students  | 45 students per unit, up to 6 units per semester  | high		
| NF_02 | System should run from command line in java based tool | | medium
| NF_03 | System default for character length to define a word set to three. || medium
| NF_04 | Software is documented well enough for the lowest skill users to operate || medium 
| NF_05 | Software operates at a resonable speed across all platforms || medium
| NF_06 | Software requires minimal installation steps. || medium
| NF_07 | Software documetation is easily accessible. || medium
| NF_08 | Software operates at a reasonable speed across all platforms. || medium
| NF_09 | Software requires minimal installation steps. || medium
| NF_10 | Software is documented thoroughly enough for the lowest skill users to operate.  || medium

