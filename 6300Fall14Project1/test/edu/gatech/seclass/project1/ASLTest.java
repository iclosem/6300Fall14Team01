package edu.gatech.seclass.project1;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ASLTest {

    private ASL asl;
    private String fileDir;

    @Before
    public void setUp() throws Exception {
        asl = new ASL();
        fileDir = new String("test" + File.separator + "inputfiles"
                + File.separator);
    }
    @After
    public void tearDown() throws Exception {
        asl = null;
        fileDir = null;
    }
    @Test
    public void testComputeAverageSentenceLength1() {
        String comment = "Testing sentences that span multiple lines";
        asl.setFile(new File(fileDir + "input.txt"));
        assertEquals(comment, 7, asl.computeAverageSentenceLength(), 0);	
    }
    @Test
    public void testComputeAverageSentenceLength2() {
        String comment = "Testing customized delimiters";
        asl.setFile(new File(fileDir + "input.txt"));
        asl.setSentenceDelimiters("%.");
        assertEquals(comment, 3, asl.computeAverageSentenceLength(), 0);
    }
    @Test
    public void testComputeAverageSentenceLength3() {
        String comment = "Testing customized minimal word length";
        asl.setFile(new File(fileDir + "input.txt"));
        asl.setMinWordLength(5);
        assertEquals(comment, 3, asl.computeAverageSentenceLength(), 0);
    }
    
    @Test
    public void testSetMinWordLength(){
    	asl.setMinWordLength(5);
    	assertEquals("Min word length is set successfully", 5, asl.getMinWordLength());
    }
    
    @Test
    public void testMaxMinWordLength(){
    	assertEquals("Min word length cannot be set to greater than 15", false, asl.setMinWordLength(20));
    }
    
    @Test
    public void testMinMinWordLength(){
    	assertEquals("Min word length cannot be set to less than 1", false, asl.setMinWordLength(-3));
    }
    
    @Test
    public void testSetSentenceDelimiters(){
    	String testDelimiters = "12@#";
    	asl.setSentenceDelimiters(testDelimiters);
    	assertEquals("Sentence delimeters can be set to a valid string", "[" + testDelimiters + "]", asl.getDelimeters());
    }
    
    @Test
    public void testEmptySentenceDelimiters(){
    	assertEquals("Sentence delimeters cannot be set to empty String", false, asl.setSentenceDelimiters(""));
    }
    
    @Test
    public void testCommandParseFile() {
        String comment = "Parsing of -f command is successful with proper file input";
        String[] args = new String[]{"-f","./test/inputfiles/input2file.txt"};
        assertEquals(comment, true, asl.parseCommandString(args));
    }
    
    @Test
    public void testCommandParseFile2() {
        String comment = "Parsing of --file command is successful with proper file input";
        String[] args = new String[]{"--file","./test/inputfiles/input2file.txt"};
        assertEquals(comment, true, asl.parseCommandString(args));
    }
    
    @Test
    public void testCommandParseHelp() {
        String comment = "Parsing of -h command is successful";
        String[] args = new String[]{"-h"};
        assertEquals(comment, true, asl.parseCommandString(args));
    }
    
    @Test
    public void testCommandParseBadFile() {
        String comment = "Parsing of --file command is unsuccessful with bad file input";
        String[] args = new String[]{"--file","./test/inputfiles/input2sdhyehdfgfile.txt"};
        assertEquals(comment, false, asl.parseCommandString(args));
    }
    
    @Test
    public void testOpenFile() throws Exception {
        String comment = "ReadFile works as setFile does";
        asl.readFile("./test/inputfiles/input.txt");
        String readFileOutput = asl.getEssay();
        
        asl.setFile(new File(fileDir + "input.txt"));
        String setFileOutput = asl.getEssay();
        assertEquals(comment, setFileOutput, readFileOutput );
    }

    
    @Test
    public void testOpenTooLargeFile() {
        String comment = "Opening a large file does not work";
        assertEquals(comment, false, asl.setFile(new File(fileDir + "largeTxt.txt")));
    }
}
