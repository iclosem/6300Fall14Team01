/* 
Notes: 
 
Possible Questions:
1) Is there default behavior needed
2) Persistant data a required feature...IE retain past scans for comparison
3) Identify any of the largest sentances or just show length?
 
Testing/Erros to be handled
-input files doesnt not exist
-command line argument checking 
-empty input file
-paragraph indentation strangeness
-quotation marks
-no delimteres default behavior ? returns or paragraphs
-non text file? 
-public interface?
-performance metrics?
-Do zero char sentances count !!
-elipses?
-should we strip leading whitespace
-command line issues
 
Should each role be responsible for their own documents: 
1. Project Management -> Agendas, notes, task assignments, and ProjectPlanTemplate.md.
2. Documentation lead -> Design Documents (RequirementsDocumentTemplate.md), and help documents.
3. Developement Lead -> Code
4. QA Lead -> Tests.
This roughly means that 1 and 2 will be adding changes for stage 1, and 3 and 4 will be adding changes for stage 2. This does seem to follow the waterfall method. 
Or should each team member be committing is each document and therefore at each stage? I have a hard time dividing up each document and probably <300 lines of code four times. Ie:
All four people commit to -> ProjectPlanTemplate.md
All four people commit to -> RequirementsDocumentTemplate.md
All four people commit to -> Code
All four people commit to -> Tests
So which way is required or can we do it either way?
https://piazza.com/class/hyrr3m4thot1rc?cid=326
*/
 
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Arrays;
 
public class averageSentanceLength{ 
    
    
    public static void main(String[] args) { 
        System.out.println("averageSentanceLength..." +  args[0] + args[1]);
        try{
        	String essay = new String(Files.readAllBytes(Paths.get(args[2])));
        	//full essay
            //System.out.println(essay);
            //split into sentances
            String[] essaySentances = essay.split("["+".,!"+"]", 0);
            int totalSentances = essaySentances.length; // -1 since split retains the first sentance
            int totalChars = 0;
            for (String strings : essaySentances) {
    			if(strings.length()>0){ //eliminates zero element items resulting from elipses etc
                 	totalChars+=strings.length();
                	System.out.println(strings + ", "+ strings.length());
                   	
                } else { //if there is a zero element sentance, it skips it and decrements
                    totalSentances--;
                }
			}
            System.out.println("Number of Sentances:"+ totalSentances);
            System.out.println("Average Sentances Length:"+ (double)(totalChars/totalSentances));
            //System.out.println(Arrays.toString(essaySentances));
            //System.out.println(essaySentances);
        } catch(java.io.IOException e){
 			System.out.println("input file does not exist...");
		}
        
    }
    
}
