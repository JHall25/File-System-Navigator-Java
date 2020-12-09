package ftp.server.operations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileSystemOperationsTest {
	
	private FileSystemOperations fileSystemOperations;
	
	@Before
	public void setup() {
		fileSystemOperations = new FileSystemOperations();
	}
	
	@Test
	public void filesListedWhenCommandInIsLs() {
		List<String> expectedOutput = new ArrayList<>();
		expectedOutput.add("");
		expectedOutput.add("");
		
		List<String> actual = fileSystemOperations.performLsOperation();
		
		assertEquals(expectedOutput, actual);
	}
	
	@Test
	public void pathLocationIsChangedWhenFirstCommandIsCd() {
		String expectedOutput = "tmp/folder1";
		
		String actual = fileSystemOperations.performCdOperation("folder1");
		
		assertEquals(expectedOutput, actual);
	}
	
	@Test
	public void pathLocationIsChangedAfterMultipleCdCommands() {
		String expectedOutput = "tmp/folder2";
		
		fileSystemOperations.performCdOperation("cd folder1");
		String actual = fileSystemOperations.performCdOperation("cd ../folder2");
		
		assertEquals(expectedOutput, actual);
	}
}
