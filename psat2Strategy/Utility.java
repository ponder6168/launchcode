package psat2Strategy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utility {

	public static int getIntegerFromUser(){
		try{
			Scanner in = new Scanner(System.in);
			return in.nextInt();
		}catch(InputMismatchException e){
			return -1;
		}
	}
}
