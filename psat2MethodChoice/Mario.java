package psat2MethodChoice;


import java.io.*;
import java.util.*;

enum OutputType{FILE, CONSOLE}

public class Mario {
	
	public Mario() {
		// TODO Auto-generated constructor stub
	}

		private List<StringBuilder> pyramid;
		private OutputType pyramidOutputType;
		private PrintWriter printWriterToChosenOutput;

		public static void main(String...abc){
			Mario marioPyramid = new Mario();
			marioPyramid.pyramid=marioPyramid.buildPyramid();
			marioPyramid.pyramidOutputType = marioPyramid.getPyramidOutputType(); 
			marioPyramid.outputPyramid(marioPyramid);
		}
		
		private ArrayList<StringBuilder> buildPyramid(){
			ArrayList<StringBuilder> newPyramid = new ArrayList<>();
			int pyramidHeight = getPyramidHeight();
			if(pyramidHeight==0) return new ArrayList<StringBuilder>();
			StringBuilder currentPyramidRow= buildTopRow(pyramidHeight);
			do{
				newPyramid.add(new StringBuilder(currentPyramidRow));
				currentPyramidRow=replaceLastSpaceWithPound(currentPyramidRow);
			}while(--pyramidHeight > 0);
			return newPyramid;
		}
		
		private	int getPyramidHeight(){
			printHeightInstructions();
			int height=getIntegerFromUser();
			while(!validHeight(height)){
				printInvalidHeightMessage();
				printHeightInstructions();
				height=getIntegerFromUser();
			}
			return height;
		}
		
		private void printHeightInstructions() {
			System.out.println();
			System.out.println("Enter an integer from 0 to 23 inclusive for the pyramid height.");
			System.out.println();
		}
	
		private int getIntegerFromUser(){
			try{
				Scanner in = new Scanner(System.in);
				return in.nextInt();
			}catch(InputMismatchException e){
				return -1;
			}
		}

		private boolean validHeight(int height) {
			if(0<=height && height<=23)
				return true;
			else
				return false;
		}

		private void printInvalidHeightMessage() {
			System.out.println();
			System.out.println("You did not enter an integer from 0 to 23 inclusive.");
			System.out.println();
		}

		private	StringBuilder buildTopRow(int pyramidHeight){
			StringBuilder currentPyramidRow = new StringBuilder();
			for(int i=0;i<pyramidHeight-1;i++){
				currentPyramidRow.append(" ");
			} 
				currentPyramidRow.append("##");
			return currentPyramidRow;
		}

		private StringBuilder replaceLastSpaceWithPound(StringBuilder currentPyramidRow){
			int indexOfLastSpace = currentPyramidRow.lastIndexOf(" ");
			if(indexOfLastSpace==-1)
				return currentPyramidRow;
			else
				return currentPyramidRow.replace(indexOfLastSpace,indexOfLastSpace+1,"#");

		}			
		
		private	OutputType getPyramidOutputType(){
			printOutputTypeInstructions();
			int outputTypeChoice=getIntegerFromUser();
			while(!validOutputTypeChoice(outputTypeChoice)){
				printInvalidOutputTypeChoiceMessage();
				printOutputTypeInstructions();
				outputTypeChoice=getIntegerFromUser();
			}
			return convertIntegerToOutputType(outputTypeChoice);
		}

		private void printOutputTypeInstructions() {
			System.out.println();
			System.out.println("Choose where you want to output the pyramid. (1 for file, 2 for console)");
			System.out.println("1. File");
			System.out.println("2. Console");			
			System.out.println();

		}
		
		private boolean validOutputTypeChoice(int outputTypeChoice) {
			if(outputTypeChoice==1 || outputTypeChoice==2)
				return true;
			else
				return false;
		}

		private void printInvalidOutputTypeChoiceMessage() {
			System.out.println();
			System.out.println("You did not enter a 1 or a 2.");
			System.out.println();			
		}

		private OutputType convertIntegerToOutputType(int outputTypeChoice) {
			if(outputTypeChoice==1)
				return 	OutputType.FILE;
			else
				return OutputType.CONSOLE;
		}	
		
		private void outputPyramid(Mario marioPyramid) {
			
			marioPyramid.printWriterToChosenOutput= getPrintWriterToChosenOutput(marioPyramid);
			marioPyramid.outputPyramidToChosenOutput(marioPyramid);
		}

			private PrintWriter getPrintWriterToChosenOutput(Mario marioPyramid) {
			try{
				switch(marioPyramid.pyramidOutputType){
				case FILE: 
					String filename = getOutputFilenameFromUser();
					return new PrintWriter(new File(filename));
				case CONSOLE:
					return new PrintWriter(System.out);
				}
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

		private void outputPyramidToChosenOutput(Mario marioPyramid) {
			for(StringBuilder row:marioPyramid.pyramid)
				marioPyramid.printWriterToChosenOutput.println(row);
			marioPyramid.printWriterToChosenOutput.flush();
		}


	}

