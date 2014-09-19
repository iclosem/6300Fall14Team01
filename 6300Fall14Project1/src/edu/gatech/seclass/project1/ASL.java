package edu.gatech.seclass.project1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;

////OPEN REQS
//| F_05.0 | System will compile with javac, java  1.6 or 1.7 | | high
//| F_06.0 | System will be executable from the command line | | high
//| F_7.0 | System will allow for the input of a file path || high 

//| F_8.0 | System will provide feedback on which sentences within the essay are exceeding the average number of words per sentence| This would be a nice addition but was not requested| low 


public class ASL {
	private String delimiters = "[.?!]"; //| F_04.1 | System default for sentence delimiters will be .?!; || high
    private String essay;
    private int minWordLength = 3; //|F_03.1 | System default for minimum character length defining a word will be set to three |  | high
    private int averageSentanceLength;
    
    
    ///////////
    //GETTERS//
    ///////////
    public String getEssay(){
	    return this.essay;
    }
    public String getDelimeters(){
    	return this.delimiters;
    }
    public int getMinWordLength(){
    	return this.minWordLength;
    }
    
    //setter method that sets the internal delimiters variable
	public int setSentenceDelimiters(String delimiters){
        if (delimiters != "" && delimiters != null){
            this.delimiters = "["+ delimiters +"]"; 
            return 0;
        } else { 
            System.out.println("Sentence delimiters were not input correctly. Please retry or reference the help view.");
            return 1;
        }
        //TODO
        //
        //| F_02.2 | System will output the constraints for sentence delimiters used to calculate average sentence length | | low
        
    }
    
	public int setMinWordLength(int minWordLength){        
        //| F_03.0 | System will have flexibility in defining a word by its minimum length of characters. |The professor is not interested in counting smaller words when averaging the length of a sentence. | high
        if (minWordLength != 0){
            this.minWordLength = minWordLength;
        } else {//| F_1.04 | System will produce a friendly feedback message to user if defining word length not input correctly. "Minimum number of characters used to define a word was not input correctly. Please retry using a positive integer or reference the help view.” | | medium
             System.out.println("Minimum number of characters used to define a word was not input correctly. Please retry using a positive integer or reference the help view.");
             return 1;
        }
        return 0;
        //TODO
        //
    }
	//////////////////
	//Public Methods//
	//////////////////
	
	//@precondition a file has been specified
	//@post averageSentenceLength is set
	public int computeAverageSentenceLength(){
        String[] essaySentences = essay.split(this.delimiters, 0);//split into sentences, 0 means for all instances
        int totalWords = 0; //keeping track of total words
       	int totalSentences = essaySentences.length; // -1 since split retains the first sentence
        //| F_02.0 | System will output the average (mean) number of words per sentence, rounded down to the nearest integer | | high
        for (String sentence : essaySentences) { // for all of the sentences in essay
			if(sentence.length()>0){ //eliminates zero element items resulting from ellipses etc and min ammount of chars
            	String[] words = sentence.split(" ",0);//Separates out words
       			int wordsThisSentence=words.length;	
       			for (String entry : words){
       				if (entry.length() < this.minWordLength){
       					wordsThisSentence -= 1;	
       				}
       			}
       			totalWords += wordsThisSentence;         			     			
       			//totalChars+=sentence.length(); //adding current sentence 
       			////System.out.println(strings + ", "+ strings.length()); //debugging print statement
       		} else { //if there is a zero element sentence, it skips it and decrements
		        totalSentences--;
		    }
        }
        //TODO
        //
        //| F_02.1 | System will output the constraints for word length used to calculate average sentence length | | low
		
		return (int)(totalWords/totalSentences);
    }
	
	//@precondition none
	//@post file will be set
    public int readFile(String filePath){
    	try{
    	
    		//| F_1.01 | System will produce a friendly feedback message to user if cap of file size is exceeded. "The file selected has exceeded the allowed file size of 50KB. Please confirm the correct file has been selected and/or modify the text file to fit within the sizing constraints."  | | low
    		File file = new File(filePath);
    		if (file.exists()){
    			double bytes = file.length();
    			double kilobytes = (bytes/1024);
    			if (kilobytes > 50){
    				System.out.println("The file selected has exceeded the allowed file size of 50KB. Please confirm the correct file has been selected and/or modify the text file to fit within the sizing constraints.");
    				return 1;
    			}
    		}
    		//| F_7.1 | System will retrieve file from the file path specified by user || high 
    		//| F_7.2 | System will allow the user to input .txt files consisting of the UTF-8 character set | | high
    		this.essay = new String(Files.readAllBytes(Paths.get(filePath))); // reads the bytes in from the file
    		return 0;
    	} catch(java.io.IOException e){//| F_1.02 | System will produce a friendly feedback message to user if file path input is not successful in loading file. "The file path that has been input was not successful, please re-enter file path.” | | medium
    		System.out.println("The file path that has been input was not successful, please re-enter file path.");//F_01.02, should throw exception or report error if file does not exist
    		return 1;
    	}
        //TODO
        
    }
    
    //@precondition none
  	//@post options will all be set
    public int parseCommandString(String[] args){
    	int i=0; 
    	
    	while (i < args.length){
    		
    		if (args[i] == "-d" || args[i] == "--delimiters"){
    			this.setSentenceDelimiters(args[i+1]);
    			i++;
    		} 
    		else if (args[i] == "-h" || args[i] == "--help"){
    			//echo the markdown file
    		} else if (args[i] == "-f" || args[i] == "--file"){
    			this.readFile(args[i+1]);
    			i++;
    		} else if (args[i] == "-l" || args[i] == "--length"){
    			this.setMinWordLength(Integer.parseInt(args[i+1]));
    		}
    		//else if (args[i] == "-v" || args[i] == "--verbose"){
    			//TODO extra
    		//} 
    		i++;
    	}
    	
    	return 0;
        //TODO
        //
        //| F_1.05 | System will produce a friendly feedback message to user when input is null or empty. "The .txt file being accessed is empty. Please confirm proper file path was used." | | medium
		//|F_03.2 | System allows minimum character length defining a word to set by the user to a positive integer using the flag -l | | high
		//| F_04.0 | System allows user to specify sentence delimiters with flag -d |e.g. Should allow user to select a comma ',' as a sentence delimiter | high

    }
    
    //constructor
    public ASL(String[] args) { 
        //| F_01.0 | System will produce a friendly feedback message(s) to user, to assist in case of user operational error. | Users may range in levels of technical background  | high
    	this.parseCommandString(args);
    	this.computeAverageSentenceLength();
    	
    }
    public ASL() { 
        //| F_01.0 | System will produce a friendly feedback message(s) to user, to assist in case of user operational error. | Users may range in levels of technical background  | high
	
    }
}
