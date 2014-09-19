package edu.gatech.seclass.project1;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ASLTest {

    private ASL asl = new ASL();
  
    @Before
    public void setUp() throws Exception {
    	
    }
    @After
    public void tearDown() throws Exception {
        asl = null;
    }
    @Test
    public void testCommandParseFile() {
        String comment = "Testing the parsing of -f command";
        String[] args = new String[]{"-f","./test/inputfiles/input2file.txt"};
        assertEquals(comment, 0, asl.parseCommandString(args), 0);
    }
    @Test
    public void testCommandParseFile2() {
        String comment = "Testing the parsing of --file command";
        String[] args = new String[]{"--file","./test/inputfiles/input2file.txt"};
        assertEquals(comment, 0, asl.parseCommandString(args), 0);
    }
    @Test
    public void testCommandParseHelp() {
        String comment = "Testing the parsing of -h command";
        String[] args = new String[]{"-h"};
        assertEquals(comment, 0, asl.parseCommandString(args), 0);
    }
    @Test
    public void testOpenFile() {
        String comment = "Testing the opening of a file";
        asl.readFile("./test/inputfiles/input.txt");
        assertEquals(comment, 0, asl.readFile("./test/inputfiles/input.txt"), 0);
    }
    @Test
    public void testComputeAverageSentenceLength1() {
        String comment = "Testing sentences that span multiple lines";
        asl.readFile("./test/inputfiles/input.txt");
        assertEquals(comment, 7, asl.computeAverageSentenceLength(), 0);
    }
    @Test
    public void testComputeAverageSentenceLength2() {
        String comment = "Testing customized delimiters";
        asl.readFile("./test/inputfiles/input.txt");
        asl.setSentenceDelimiters("%.");
        assertEquals(comment, 3, asl.computeAverageSentenceLength(), 0);
    }
    @Test
    public void testComputeAverageSentenceLength3() {
        String comment = "Testing customized minimal word length";
        asl.readFile("./test/inputfiles/input.txt");
        asl.setMinWordLength(5);
        assertEquals(comment, 3, asl.computeAverageSentenceLength(), 0);
    }
    @Test
    public void testMainConstructor() {
    	String comment = "Testing constructor as it will be called from main";
    	String[] args = new String[]{"-f","./test/inputfiles/input.txt"};
    	ASL asl = new ASL(args);
    }
}
