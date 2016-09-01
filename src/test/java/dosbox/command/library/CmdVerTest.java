/*
 * DOSBox, Scrum.org, Professional Scrum Developer Training
 * Authors: Rainer Grau, Daniel Tobler, Zuehlke Technology Group
 * Copyright (c) 2013 All Right Reserved
 */ 

package dosbox.command.library;

import org.junit.Before;
import org.junit.Test;

import dosbox.command.library.CmdCd;
import dosbox.filesystem.Directory;
import dosbox.helpers.TestHelper;

public class CmdVerTest extends CmdTest {

    private String[] name = {"Joshua Partogi","Ian Agung", "Riyanto", "Eko Prayoga", "Jumas Ranope", "Rimon"};
    private String[] mail = {"jpartogi@live.com","ian.agung@len.co.id", "riyanto@len.co.id", "ekoprayoga@gmail.com", "jumas.ranope@gmail.com", "rimon.vn@gmail.com"};

    @Before
    public void setUp()
    {
        // Check this file structure in base class: crucial to understand the tests.
        this.createTestFileStructure();

        // Add all commands which are necessary to execute this unit test
        // Important: Other commands are not available unless added here.
        commandInvoker.addCommand(new CmdVer("ver", drive));
    }

    @Test
    public void cmdver_emptycommand()
    {
        executeCommand("ver");
        TestHelper.assertContains("Microsoft Windows XP [Version 5.1.2600]", testOutput);
    }
    
    @Test
    public void cmdver_slashw()
    {
        executeCommand("ver /w");
        TestHelper.assertContains("Microsoft Windows XP [Version 5.1.2600]", testOutput);
        for(int i=0 ; i<name.length ; i++)
    	{
        	TestHelper.assertContains(name[i],testOutput);
        	TestHelper.assertContains(mail[i],testOutput);
    	}
    }    
    
//
//    @Test
//    public void cmdCd_ChangeToSubDirectoryWithEndingBacklash_ChangesDirectory()
//    {
//        executeCommand("cd " + subDir1.getPath() + "\\");
//        TestHelper.assertOutputIsEmpty(testOutput);
//        TestHelper.assertCurrentDirectoryIs(drive, subDir1);
//    }
//
//    @Test
//    public void cmdCd_WithBacklash_ChangesToRoot()
//    {
//        drive.changeCurrentDirectory(subDir1);
//        executeCommand("cd \\");
//        TestHelper.assertOutputIsEmpty(testOutput);
//        TestHelper.assertCurrentDirectoryIs(drive, rootDir);
//    }
//
//    @Test
//    public void cmdCd_WithPointPoint_ChangesToParent()
//    {
//        drive.changeCurrentDirectory(subDir1);
//        executeCommand("cd ..");
//        TestHelper.assertOutputIsEmpty(testOutput);
//        TestHelper.assertCurrentDirectoryIs(drive, rootDir);
//    }
//
//    @Test
//    public void cmdCd_WithPointPointInRootDir_RemainsInRootDir()
//    {
//        drive.changeCurrentDirectory(rootDir);
//        executeCommand("cd ..");
//        TestHelper.assertOutputIsEmpty(testOutput);
//        TestHelper.assertCurrentDirectoryIs(drive, rootDir);
//    }
//
//    @Test
//    public void cmdCd_WithPoint_RemainsInCurrentDirectory()
//    {
//        drive.changeCurrentDirectory(subDir1);
//        executeCommand("cd .");
//        TestHelper.assertOutputIsEmpty(testOutput);
//        TestHelper.assertCurrentDirectoryIs(drive, subDir1);
//    }
//
//    @Test
//    public void cmdCd_WithPointInRootDir_RemainsInCurrentDirectory()
//    {
//        executeCommand("cd .");
//        TestHelper.assertOutputIsEmpty(testOutput);
//        TestHelper.assertCurrentDirectoryIs(drive, rootDir);
//    }
//
//    @Test
//    public void cmdCd_WithoutParameter_PrintsCurrentDirectory()
//    {
//        drive.changeCurrentDirectory(subDir1);
//        executeCommand("cd");
//        TestHelper.assertContains(subDir1.getPath(), testOutput.toString());
//        TestHelper.assertCurrentDirectoryIs(drive, subDir1);
//    }
//
//    @Test
//    public void cmdCd_WithInvalidAbsolutePath_RemainsInCurrentDirectory()
//    {
//        drive.changeCurrentDirectory(subDir2);
//        executeCommand("cd c:\\gaga\\gugus");
//        TestHelper.assertCurrentDirectoryIs(drive, subDir2);
//        TestHelper.assertContains("system cannot find the path specified", testOutput.toString());
//    }
//
//    @Test
//    public void cmdCd_WithFileAsPath_RemainsInCurrentDirectory()
//    {
//        drive.changeCurrentDirectory(subDir2);
//        executeCommand("cd " + file1InDir1.getPath());
//        TestHelper.assertCurrentDirectoryIs(drive, subDir2);
//        TestHelper.assertContains("directory name is invalid", testOutput.toString());
//    }
//
//    @Test
//    public void cmdCd_WithRelativePath_ChangesDirectory()
//    {
//        executeCommand("cd " + subDir1.getName());
//        TestHelper.assertOutputIsEmpty(testOutput);
//        TestHelper.assertCurrentDirectoryIs(drive, subDir1);
//    }
//
//    @Test
//    public void cmdCd_WithSingleLetterDirectory_ChangesDirectory()
//    {
//        // given
//        Directory directoryWithSingleLetter = new Directory("a");
//        rootDir.add(directoryWithSingleLetter);
//        drive.changeCurrentDirectory(rootDir);
//
//        // when
//        executeCommand("cd " + directoryWithSingleLetter.getName());
//
//        // then
//        TestHelper.assertOutputIsEmpty(testOutput);
//        TestHelper.assertCurrentDirectoryIs(drive, directoryWithSingleLetter);
//    }
//
//    @Test
//    public void cmdCd_ChangeToNotExistingDirectory_PrintsError()
//    {
//        this.drive.changeCurrentDirectory(this.rootDir);
//        executeCommand("cd NotExistingDirectory");
//        TestHelper.assertCurrentDirectoryIs(drive, this.rootDir);
//        TestHelper.assertContainsNoCase("cannot find the path specified", this.testOutput);
//    }
//
//    @Test
//    public void cmdCd_AllParametersAreReset()
//    {
//        executeCommand("cd " + subDir1.getPath());
//        TestHelper.assertOutputIsEmpty(testOutput);
//        TestHelper.assertCurrentDirectoryIs(drive, subDir1);
//        executeCommand("cd");
//        TestHelper.assertContains(subDir1.getPath(), testOutput.toString());
//    }
}
