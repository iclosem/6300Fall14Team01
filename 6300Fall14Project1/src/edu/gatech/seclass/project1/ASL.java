package edu.gatech.seclass.project1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;


public class ASL {
	private String delimiters = "[.?!;]"; //F_04.1 
    private String essay;
    private int minWordLength = 3; //F_03.1 
    
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
	public void setSentenceDelimiters(String delimiters){
        if (delimiters != "" && delimiters != null){
            this.delimiters = "["+ delimiters +"]"; 
        } else { //F_1.03
            System.out.println("Sentence delimiters were not input correctly. Please retry or reference the help view.");
        }
        //F_02.2 System will output the constraints for sentence delimiters used to calculate average sentence length | | low
        
    }
    
	public int setMinWordLength(int minWordLength){//F_3.0
        if (minWordLength != 0 && minWordLength >= 1 && minWordLength <= 15){//F_3.0
            //may want to replace this with a try, catch since they could put a string as input
            this.minWordLength = minWordLength;
        } else { //F_1.05 
             System.out.println("Minimum number of characters used to define a word was not input correctly. Please retry using a positive integer or reference the help view.");
             return 1;
        }
        return 0;
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
        for (String sentence : essaySentences) { // for all of the sentences in essay
			if(sentence.length()>0){ //eliminates zero element items resulting from ellipses etc and min ammount of chars
            	String[] words = sentence.split(" ",0);//Separates out words
       			int wordsThisSentence = words.length;	
       			for (String entry : words){
       				//entry = entry.replaceAll("[^a-zA-Z0-9\\s]",""); //regex to remove any punctuation so it does not count for word length
       				if (entry.length() < this.minWordLength){
       					wordsThisSentence -= 1;	
       				}
       			}
       			totalWords += wordsThisSentence;         			     			
       		} else { //if there is a zero element sentence, it skips it and decrements
		        totalSentences--;
		    }
        }//F_02.0
        int averageWords = (int)(totalWords/totalSentences);
        System.out.println("The sentence delimiters were: " + this.delimiters);//F_02.2
		System.out.println("The minimum word length was: " + this.minWordLength);//F_02.1
		System.out.println("The average number of words per sentence is: " + averageWords);
		return averageWords;
    }
	
	//@precondition none
	//@post file will be set
	public void setFile(File studentFile){
		try{
			if (studentFile.exists()){
				double bytes = studentFile.length();
				double kilobytes = (bytes/1024);
				if (kilobytes > 50){
					System.out.println("The file selected has exceeded the allowed file size of 50KB. Please confirm the correct file has been selected and/or modify the text file to fit within the sizing constraints.");
				}
                if (kilobytes == 0){
                    System.out.println("The .txt file being accessed is empty. Please confirm proper file path was used.");
                }
			}
			//F_7.1, F_7.2 
			this.essay = new String(Files.readAllBytes(Paths.get(studentFile.getPath()))); // reads the bytes in from the file;
			this.essay = essay.trim();
			this.essay = essay.replaceAll("[\\n]", " ");
			
		} catch(java.io.IOException e){//F_01.05
			System.out.println("The file path that has been input was not successful, please re-enter file path.");//F_01.02
		}
	}

    public void readFile(String filePath){//F_
    		File file = new File(filePath);
    		setFile(file);
    }
    
    //@precondition none
  	//@post none
    public void printHelp(){
    	try{
    		String filePath = "./manual.md";
      		String help = new String(Files.readAllBytes(Paths.get(filePath))); // reads the bytes in from the file
      		System.out.println(help);//F_01.02, should throw exception or report error if file does not exist
      		
      	} catch(java.io.IOException e){
      		System.out.println("The help file cannot be found.");//F_01.02, should throw exception or report error if file does not exist
      	}
          //TODO
          
      }
    
    //@precondition none
  	//@post options will all be set
    public boolean parseCommandString(String[] args){
    	int i=0; 
    	int fileSet = 0;
    	while (i < args.length){
    		
    		if (args[i] == "-d" || args[i] == "--delimiters"){//F_04.0
    			this.setSentenceDelimiters(args[i+1]);
    			i++;
    		} 
    		else if (args[i] == "-h" || args[i] == "--help"){
    			this.printHelp();
    			break;
    		} else if (args[i] == "-f" || args[i] == "--file"){
    			this.readFile(args[i+1]);
    			i++;
    			fileSet = 1;
    		} else if (args[i] == "-l" || args[i] == "--length"){//F_03.03
    			this.setMinWordLength(Integer.parseInt(args[i+1]));
    		}
    		i++;
    	}
    	if (fileSet == 0){
    		System.out.println("The file path that has been input was not successful, please re-enter file path.");
    		return false;
    	}
    	return true;

       //|F_03.2 | System allows minimum character length defining a word to set by the user to a positive integer using the flag -l | | high
		//| F_04.0 | System allows user to specify sentence delimiters with flag -d |e.g. Should allow user to select a comma ',' as a sentence delimiter | high

    }
    
    //constructor
    public ASL(String[] args) { 
    	this.parseCommandString(args);
    	this.computeAverageSentenceLength();
    	
    }
    public ASL() { 
       
    }
}
