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
    public void testCommandParseFile() {
        String comment = "Testing the parsing of -f command";
        String[] args = new String[]{"-f","./test/inputfiles/input2file.txt"};
        assertEquals(comment, true, asl.parseCommandString(args));
    }
    @Test
    public void testCommandParseFile2() {
        String comment = "Testing the parsing of --file command";
        String[] args = new String[]{"--file","./test/inputfiles/input2file.txt"};
        assertEquals(comment, true, asl.parseCommandString(args));
    }
    @Test
    public void testCommandParseHelp() {
        String comment = "Testing the parsing of -h command";
        String[] args = new String[]{"-h"};
        assertEquals(comment, true, asl.parseCommandString(args));
    }
    @Test
    public void testCommandParseBadFile() {
        String comment = "Testing the parsing of --file command";
        String[] args = new String[]{"--file","./test/inputfiles/input2sdhyehdfgfile.txt"};
        assertEquals(comment, false, asl.parseCommandString(args));
    }
    @Test
    public void testOpenFile() {
        String comment = "Testing the opening of a file";
        asl.readFile("./test/inputfiles/input.txt");
        Fail("Need to test that the file is set");
        //assertEquals(comment, false, asl.readFile("./test/inputfiles/input.txt"));
    }
}
