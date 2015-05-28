package psat2Strategy;

import java.util.ArrayList;


	public class PyramidToConsole implements PyramidOutput {

		
		public void pyramidOutput(ArrayList<StringBuilder> pyramid) {
			for(StringBuilder row:pyramid) 
				System.out.println(row);
		}


	}
