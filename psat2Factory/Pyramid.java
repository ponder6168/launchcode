package psat2Factory;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Pyramid implements Buildable {

	public Pyramid() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<StringBuilder> build(){
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
	


	@Override
	public void Output(List<StringBuilder> builtObject) {
		// TODO Auto-generated method stub

	}

}
