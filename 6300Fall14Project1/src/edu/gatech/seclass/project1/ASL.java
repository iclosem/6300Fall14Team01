package edu.gatech.seclass.project1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;


public class ASL{
	private String delimiters = ".?!;"; //F_04.1 
    private String essay;
    private int minWordLength = 3; //F_03.1 
    

    public ASL(){ }
    
    public ASL(String[] args){ 
    	this.parseCommandString(args);
    	this.computeAverageSentenceLength();
    }
    
    public String getEssay(){
	    return this.essay;
    }

    //Sets the internal delimiters variable
	public boolean setSentenceDelimiters(String delimiters){
        if (delimiters != "" && delimiters != null){
            this.delimiters = delimiters;
            return true;
        } else { //F_1.03
        	return printMsgRetFalse("Sentence delimiters were not input correctly. Please retry or reference the help view with -h.");
        }
        //F_02.2 System will output the constraints for sentence delimiters used to calculate average sentence length | | low
        
    }
    public String getDelimeters(){
    	return this.delimiters;
    }
    
	public boolean setMinWordLength(int minWordLength){//F_3.0
		String errorMsg = "Minimum number of characters used to define a word was not input correctly. Please retry using a positive integer (1-15) or reference the help view with -h.";
		try{
	        if (minWordLength != 0 && minWordLength >= 1 && minWordLength <= 15){//F_3.0
	            //may want to replace this with a try, catch since they could put a string as input
	            this.minWordLength = minWordLength;
	            return true;
	        }else{
	             System.out.println(errorMsg);
	             return false;
	        }
        } catch (Exception e) { //F_1.05 
        	return printMsgRetFalse(errorMsg);
        }
    } //|F_03.2 | System allows minimum character length defining a word to set by the user to a positive integer using the flag -l | | high
	
	
    public int getMinWordLength(){
    	return this.minWordLength;
    }

	
	//@precondition a file has been specified
	//@post averageSentenceLength is set
	public int computeAverageSentenceLength(){
		if(essay != null){
	        String[] essaySentences = essay.split("[" + this.delimiters + "]", 0);//split into sentences, 0 means for all instances
	        int totalWords = 0; //keeping track of total words
	       	int totalSentences = essaySentences.length; // -1 since split retains the first sentence
	        for (String sentence : essaySentences) { // for all of the sentences in essay
				if(sentence.length()>0){ //eliminates zero element items resulting from ellipses etc and min ammount of chars
	            	String[] words = sentence.split("\\s+",0);//Separates out words
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
		} else {
			return 0;
		}
    }
	
	//@precondition none
	//@post file will be set
	public boolean setFile(File studentFile){
		try{
			if (studentFile.exists()){
				double bytes = studentFile.length();
				double kilobytes = (bytes/1024);
				if (kilobytes > 50){
					return printMsgRetFalse("The file selected has exceeded the allowed file size of 50KB. Please confirm the correct file has been selected and/or modify the text file to fit within the sizing constraints.");
				}
                if (kilobytes == 0){
                	return printMsgRetFalse("The .txt file being accessed is empty. Please confirm proper file path was used.");
                }
			}
			//F_7.1, F_7.2 
			this.essay = new String(Files.readAllBytes(Paths.get(studentFile.getPath()))); // reads the bytes in from the file;
			this.essay = essay.trim();
			this.essay = essay.replaceAll("[\\n]", " ");
			return true;
		} catch(java.io.IOException e){//F_01.05
			return printMsgRetFalse("The file path " + studentFile.getPath() + " was not successful, please re-enter file path.");//F_01.02
		}
	}

    public void readFile(String filePath) throws Exception{
    		File file = new File(filePath);
    		if( setFile(file) == false){
	    		throw new Exception("The file path "+ filePath + " was not successful, please re-enter file path.");
	    	}
    }
    
    //@precondition none
  	//@post none
    public void printHelp() throws Exception{
    	try{
    		String filePath = "./manual.md";
      		String help = new String(Files.readAllBytes(Paths.get(filePath))); // reads the bytes in from the file
      		System.out.println(help);
      		
      	} catch(java.io.IOException e){
      		throw new Exception("The help file cannot be found.");//F_01.02, should throw exception or report error if file does not exist
      	}
          
      }
    
    //@precondition none
  	//@post options will all be set
    //| F_04.0 | System allows user to specify sentence delimiters with flag -d |e.g. Should allow user to select a comma ',' as a sentence delimiter | high
    public boolean parseCommandString(String[] args){
    	try{
	    	for (int i = 0; i < args.length; i++){
	    		if (args[i].equals("-d") || args[i].equals("--delimiters")){//F_04.0
	    			this.setSentenceDelimiters(args[i+1]);
	    			i++;
	    		} else if (args[i].equals("-h") || args[i].equals("--help")){
	    			this.printHelp();
	    			break;
	    		} else if (args[i].equals("-f") || args[i].equals("--file")){
	    			this.readFile(args[i+1]);
	    			i++;
	    		} else if (args[i].equals("-l") || args[i].equals("--length")){//F_03.03
	    			this.setMinWordLength(Integer.parseInt(args[i+1]));
	    			i++;
	    		}else{
	    			return printMsgRetFalse("Could not understand command. Please reference the help view with -h.");
	    		}
	    	}
	    	return true;
    	} catch(Exception e){
    		return printMsgRetFalse(e.getMessage());//F_01.02
    	}
    }
    
    private boolean printMsgRetFalse(String msg){
		System.out.println(msg);//F_01.02
		return false;
    }
}
