##**ASL Manual -- Team 01**
###Project 1: Average Sentence Length

####NAME       

Main - computes average sentence length for a text document

####SYNOPSIS        

**Main** -f|--file _FILE_ [-d|--delimiters _DELIMITERS_] [-l|--length _MINWORDLENGTH_] [-h|--help]


####DESCRIPTION    

The Average Sentence Length application *Main* is a command line tool provided for students to assess the average number of words per sentence or clause in a [_FILE_], which is defined as the full path to a document in *.txt format.  The default [_DELIMITERS_], or puctuation characters defining the end of a sentence are {.!?;}.  Custom [_DELIMITERS_] can be set using the -d switch.  By default, the minimum size for a word to be counted or [_MINWORDLENGTH_] is 3 charactes.  The [_MINWORDLENGTH_] can be adjusted using the -l switch. The -h switch displays this man page and exits the program.  The maximimum [_FILE_] size permitted for the application is 50 kB.   


####OPTIONS
Mandatory arguments to long options are mandatory for short options too.
```
  -d, --delimiters = DELIMITERS   sets the delimeters, allowable delimiters include 
                                  {~!@#$%^&*()_+`-=[]\{}|;':",./<>?}  defaults to {.!?;}
                                
  -h, --help                      displays this help and exit
  
  -f, --file = FILE               specifies the input file
  
  -l, --length = MINWORDLENGTH    defines a minimum word size.  allowable lengths 
                                  include integer values from 1 to 15.
  
```

####EXAMPLES
```
Main -l 5 -f ./test/inputfiles/input.txt           sets the minimnum word size to 5  
                                                    characters and the input file to 
                                                    ./test/inputfiles/input.txt 
        
Main --delimiters %.! --file C:\Essays\essay.txt   sets the sentence delimiters to %.! 
                                                    and the input file to 
                                                    C:\Essays\essay.txt

Main -h                                            displays this help page.

```
####AUTHORS      

| Name  				| GATECH Username		| E-mail						| Alias |
| --------------------- |:---------------------:|:-----------------------------:|:-----:| 
| [Alex Bowers Schoen](http://github.com/bowersaa )  	| abowers9				| alexandra.bowers@gmail.com 	| [ABS](http://github.com/bowersaa )   |
| [Alex Hortin](http://github.com/hortinstein) 	 		| ahortin3				| hortinstein@gmail.com  		| [AH](http://github.com/hortinstein )    |
| [Charles Cone](http://github.com/ccone8)  	 		| ccone8		        | charlesprestoncone@gmail.com  | [CC](http://github.com/ccone8 )    |
| [Danelle Morales](http://github.com/DannieMorales) 		| dmorales30			| damoraled@gmail.com | [DM](http://github.com/DannieMorales)   |
