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

List all the external systems with which the software product interacts. These are external systems/libraries 
that you have to interact with.

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

Specify the logical characteristics of each interface between the software product and its users. This is a description of how the system will interact with its users.

- Command line input, requires input of sentance delimiters and a text input file
- Documentation view or help interface.
- Output view 

######User Characteristics

Describe those general characteristics of the intended users of the product, including educational level, experience, and technical expertise.

- College students with at least some experience with computer file systems.
- Mixed computer proficiency from beginner to advanced.
- Experience varies across multiple platforms.

####System Requirements

These subsections contain all the software requirements at a level of detail sufficient to enable designers/developers to design/develop a system that satisfies those requirements, and testers to test that the system satisfies those requirements. This part of the document should provide a numbered (possibly hierarchical) list of simple, complete, and consistent functional and non-functional requirements.
 
#####Functional Requirements

- Vanilla java 1.7.
- Compiles with javac, no options.
- Executable from the command line.
- User specifies file path.
- User specifies sentence delimiters with switch -d.
- User specifies word length limit (minimum?) with switch -l.
- Output average sentence length. 

  
#####Non-Functional Requirements

- Software is documented thoroughly enough for the lowest skill users to operate and easily accessible.
- Software operates at a reasonable speed across all platforms.
- Software requires minimal installation steps. 



