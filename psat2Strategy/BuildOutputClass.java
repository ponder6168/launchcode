package psat2Strategy;

public class BuildOutputClass {

	public static PyramidOutput getOutputClass(OutputType outputType){
		switch(outputType){
		case FILE: 
			return  new  PyramidToFile();
		case CONSOLE:
			return  new PyramidToConsole() ;
		default: 
			throw new IllegalStateException("Unrecognised case "+outputType);
		}
	}
	
	public static	OutputType getPyramidOutputType(){
		printOutputTypeInstructions();
		int outputTypeChoice=Utility.getIntegerFromUser();
		while(!validOutputTypeChoice(outputTypeChoice)){
			printInvalidOutputTypeChoiceMessage();
			printOutputTypeInstructions();
			outputTypeChoice=Utility.getIntegerFromUser();
		}
		return convertIntegerToOutputType(outputTypeChoice);
	}

	private static void printOutputTypeInstructions() {
		System.out.println();
		System.out.println("Choose where you want to output the pyramid. (1 for file, 2 for console)");
		System.out.println("1. File");
		System.out.println("2. Console");			
		System.out.println();

	}
	private static boolean validOutputTypeChoice(int outputTypeChoice) {
		if(outputTypeChoice==1 || outputTypeChoice==2)
			return true;
		else
			return false;
	}

	private static void printInvalidOutputTypeChoiceMessage() {
		System.out.println();
		System.out.println("You did not enter a 1 or a 2.");
		System.out.println();			
	}

	private static OutputType convertIntegerToOutputType(int outputTypeChoice) {
		if(outputTypeChoice==1)
			return 	OutputType.FILE;
		else
			return OutputType.CONSOLE;
	}	
}
