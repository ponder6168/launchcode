package psat2Strategy;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PyramidToFile implements PyramidOutput {

	@Override
	public void pyramidOutput(ArrayList<StringBuilder> pyramid) {
		// TODO Auto-generated method stub
		PrintWriter printWriterForOutputFile;
		printWriterForOutputFile=getPrintWriterForOutputFile();
		outputPyramidToOutputFile(pyramid, printWriterForOutputFile);
	}
	
		private PrintWriter getPrintWriterForOutputFile() {
		try{
			String filename = getOutputFilenameFromUser();
			return new PrintWriter(new File(filename));
		}catch(IOException e){
			System.out.println("You entered an invalid filename.");
			e.printStackTrace(System.out);
		}
		return null;
	}

	private String getOutputFilenameFromUser() {
		System.out.println();
		System.out.println("Enter the filename of the file you want the pyramid to go to.");
		System.out.println();			
		Scanner in = new Scanner(System.in);
		return in.nextLine().trim();
	}

	private void outputPyramidToOutputFile(List<StringBuilder> builtObject,PrintWriter printWriterForOutputFile) {
		for(StringBuilder row:builtObject)
			printWriterForOutputFile.println(row);
		printWriterForOutputFile.flush();
	}


}

