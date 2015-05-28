package psat2Factory;

import java.io.File;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

enum OutputType{FILE, CONSOLE}

class BuildableFactory{
	public Buildable getBuildableObject(OutputType outputType){
		switch(outputType){
		case FILE: 
			return new  PyramidToFile();
		case CONSOLE:
			return new PyramidToConsole() ;
		default: 
			throw new IllegalStateException("Unrecognised case "+outputType);
		}
	}
}

public class Mario {

	public static void main(String[] args) {
		Mario mario = new Mario();
		BuildableFactory buildableFactory = new BuildableFactory();
		OutputType pyramidOutputType = mario.getPyramidOutputType(); 
		Buildable pyramidBuilder = buildableFactory.getBuildableObject(pyramidOutputType);
		List <StringBuilder> pyramid = pyramidBuilder.build();
		pyramidBuilder.Output(pyramid);
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
	
	private int getIntegerFromUser(){
		try{
			Scanner in = new Scanner(System.in);
			return in.nextInt();
		}catch(InputMismatchException e){
			return -1;
		}
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
	
}
