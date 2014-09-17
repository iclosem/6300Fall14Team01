package edu.gatech.seclass.project1;

import java.nio.file.Files;
import java.nio.file.Paths;

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
    

	private int computeAverageSentenceLength(){
        String[] essaySentances = essay.split(this.delimiters, 0);//split into sentances, 0 means for all instances
        int totalChars = 0; //keeping track of total characters
       	int totalSentances = essaySentances.length; // -1 since split retains the first sentance
        //| F_02.0 | System will output the average (mean) number of words per sentence, rounded down to the nearest integer | | high
        for (String strings : essaySentances) { // for all of the sentances in essay
            if(strings.length()>0){ //eliminates zero element items resulting from elipses etc and min ammount of chars
                ///NEED TO CHECK MINIMUM WORD VALUE TO COUND 
                //possible implementation strings.split(" ",0) > self.minLength
                
                totalChars+=strings.length(); //adding current sentance 
                //System.out.println(strings + ", "+ strings.length()); //debugging print statement
            } else { //if there is a zero element sentance, it skips it and decrements
                totalSentances--;
            }
        }
        //TODO
        //
        //| F_02.1 | System will output the constraints for word length used to calculate average sentence length | | low
		
		return (int)(totalChars/totalSentances);
    }
    //setter method that sets the internal delimiters variable
	private void setSentenceDelimiters(String delimiters){
        if (delimiters != "" && delimiters != null){
            this.delimiters = "["+ delimiters +"]"; 
        } else { 
            System.out.println("Sentence delimiters were not input correctly. Please retry or reference the help view.");
        }
        //TODO
        //
        //| F_02.2 | System will output the constraints for sentence delimiters used to calculate average sentence length | | low
        
    }
    
	private void setMinWordLength(int minWordLength){
        
        //| F_03.0 | System will have flexibility in defining a word by its minimum length of characters. |The professor is not interested in counting smaller words when averaging the length of a sentence. | high
        
        if (delimiters != "" && delimiters != null){
            this.minWordLength = minWordLength;
        } else {//| F_1.04 | System will produce a friendly feedback message to user if defining word length not input correctly. "Minimum number of characters used to define a word was not input correctly. Please retry using a positive integer or reference the help view.” | | medium
             System.out.println("Minimum number of characters used to define a word was not input correctly. Please retry using a positive integer or reference the help view.");
        }
        //TODO
        //
    }
	
    
    void readFile(String filePath){
        try{
        	String essay = new String(Files.readAllBytes(Paths.get(filePath))); // reads the bytes in from the file
        } catch(java.io.IOException e){//| F_1.02 | System will produce a friendly feedback message to user if file path input is not successful in loading file. "The file path that has been input was not successful, please re-enter file path.” | | medium
 			System.out.println("The file path that has been input was not successful, please re-enter file path.");//F_01.02, should throw exception or report error if file does not exist
		}
        
        //TODO
        //| F_1.01 | System will produce a friendly feedback message to user if cap of file size is exceeded. "The file selected has exceeded the allowed file size of 50KB. Please confirm the correct file has been selected and/or modify the text file to fit within the sizing constraints."  | | low
		//| F_7.1 | System will retrieve file from the file path specified by user || high 
		//| F_7.2 | System will allow the user to input .txt files consisting of the UTF-8 character set | | high

   
    }
    
    void parseCommandString(String[] args){
        //TODO
        //
        //| F_1.05 | System will produce a friendly feedback message to user when input is null or empty. "The .txt file being accessed is empty. Please confirm proper file path was used." | | medium
		//|F_03.2 | System allows minimum character length defining a word to set by the user to a positive integer using the flag -l | | high
		//| F_04.0 | System allows user to specify sentence delimiters with flag -d |e.g. Should allow user to select a comma ',' as a sentence delimiter | high

    }
    
    
    public static void main(String[] args) { 
        //| F_01.0 | System will produce a friendly feedback message(s) to user, to assist in case of user operational error. | Users may range in levels of technical background  | high

    }
}
