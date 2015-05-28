package psat2Strategy;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Pyramid {

	PyramidOutput pyramidOutput;  
	ArrayList<StringBuilder> newPyramid;
	int pyramidHeight;
	StringBuilder currentPyramidRow;
	int minimumPyramidHeight = 0;
	int maximumPyramidHeight = 23;
	
	public List<StringBuilder> build(){
		newPyramid = new ArrayList<>();
		pyramidHeight = getPyramidHeight();
		if(pyramidHeight==0) return newPyramid;
		currentPyramidRow= buildTopRow(pyramidHeight);
		newPyramid = buildRestOfPyramid();
		return newPyramid;
	}
	
	private ArrayList<StringBuilder> buildRestOfPyramid() {
		do{
			newPyramid.add(new StringBuilder(currentPyramidRow));
			currentPyramidRow=replaceLastSpaceWithPound(currentPyramidRow);
		}while(pyramidIsNotFinished());
		return newPyramid;
	}

	private boolean pyramidIsNotFinished() {
		return  --pyramidHeight > 0;
	}

	private	int getPyramidHeight(){
		printHeightInstructions();
		int height=Utility.getIntegerFromUser();
		while(!validHeight(height)){
			printInvalidHeightMessage();
			printHeightInstructions();
			height=Utility.getIntegerFromUser();
		}
		return height;
	}
	
	private void printHeightInstructions() {
		System.out.println();
		System.out.println("Enter an integer from "+ minimumPyramidHeight + " to " + maximumPyramidHeight + " inclusive for the pyramid height.");
		System.out.println();
	}

	
	private boolean validHeight(int height) {
		if(minimumPyramidHeight <= height && height <= maximumPyramidHeight)
			return true;
		else
			return false;
	}

	private void printInvalidHeightMessage() {
		System.out.println();
		System.out.println("You did not enter an integer from "+ minimumPyramidHeight + " to " + maximumPyramidHeight + " inclusive.");
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

	public void outputPyramid() {
		OutputType pyramidOutputType = BuildOutputClass.getPyramidOutputType(); 
		pyramidOutput = BuildOutputClass.getOutputClass(pyramidOutputType);
		pyramidOutput.pyramidOutput(newPyramid);
	}

}
