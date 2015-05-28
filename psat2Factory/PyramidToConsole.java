package psat2Factory;

import java.util.List;

public class PyramidToConsole extends Pyramid {

	public PyramidToConsole() {
		// TODO Auto-generated constructor stub
	}
	
	@Override 
	public void Output(List<StringBuilder> builtPyramid) {
		for(StringBuilder row:builtPyramid) 
			System.out.println(row);
	}


}
