# **Requirements Document -- Team 01**
##Project 1: Average Sentence Length
###1 User Requirements

1.1 Software Interfaces

List all the external systems with which the software product interacts. These are external systems/libraries 
that you have to interact with.

- Command Line, Windows, Linux, Mac
- File System : retrieves student essay
- Java Libraries: _need input from more experienced coders here_
 
 
  1.2 User Interfaces

Specify the logical characteristics of each interface between the software product and its users. This is a description of how the system will interact with its users.

- Command line input
- Output view

  1.3 User Characteristics

Describe those general characteristics of the intended users of the product, including educational level, experience, and technical expertise.

- College students with at least some experience with computer file systems.
- Mixed computer proficiency from beginner to advanced.
- Experience varies across multiple platforms


###2 System Requirements

These subsections contain all the software requirements at a level of detail sufficient to enable designers/developers to design/develop a system that satisfies those requirements, and testers to test that the system satisfies those requirements. This part of the document should provide a numbered (possibly hierarchical) list of simple, complete, and consistent functional and non-functional requirements.
 
  2.1 Functional Requirements

- Vanilla java 1.7.
- Compiles with javac, no options.
- Executable from the command line.
- User specifies file path.
- User specifies sentence delimiters with switch -d.
- User specifies word length limit (minimum?) with switch -l.
- Output average sentence length. 

  
  2.2 Non-Functional Requirements

- Software is documented well enough for the lowest skill users to operate.
- Software operates at a reasonable speed across all platforms.
- Software requires minimal installation steps. 