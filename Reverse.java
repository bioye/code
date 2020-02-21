/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Reverse {
	public static void main (String[] args) {
		//code
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		scanner.nextLine();
		for(int i=0;i<count;i++){
		    System.out.println(new Reverse().getReversed(scanner.nextLine()));
    }
    scanner.close();
	}
	
	String getReversed (String input){
	    String output="";
	    for(int i=input.length()-1;i>=0;i--){
	        output+=input.charAt(i);
	    }
	    return output;
	}
}