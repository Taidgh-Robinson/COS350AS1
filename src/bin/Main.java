package bin;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	//Global variables are so wrong, yet make things so easy. 
	public static int c = 0;
	
	
	public static void JJ(int n, ArrayList<Integer> D, int currentValue, String currentSums){
		
		
		//If we reach it, print out all the numbers that went into it. 
		if(currentValue == n){
			System.out.println(currentSums);
			c++; 
		}
		
		
		for(int v : D){
			//Recusive call, to check all sums. Only make recursive calls if we know it's not over our n. 
			if(currentValue + v <= n){
				JJ(n, D, currentValue + v, currentSums + Integer.toString(v) + " ");
			}
		
		}
		
	}
	//Tester Method: Takes an int for the length of D and checks the time to run for the first 100 values. 
	public static void tester(int len){
		//Were only going to try arrays with inputs of all 1s to show the worst case. 
		ArrayList<Integer> tArray = new ArrayList<Integer>(); 
		for(int i = 0; i< len; i++){
			
			tArray.add(1);
		}
		
		for(int i = 1; i < 101; i++){
			//Time the function for different n's 
			long st = System.nanoTime();
			JJ(i, tArray, 0, "");
			long et = System.nanoTime();

			System.out.println(i + ":" + (et-st));
			
		}
		
		
		
	}
	
	public static void main(String[] args){
		
		Scanner ui = new Scanner(System.in);
		
		System.out.println("Please enter the info in the form of: n D1 D2 D3 ...");
		String input = ui.nextLine();
		
		
		//Handling the user input: 
		String[] values = input.split(" "); 
		
		int n = Integer.valueOf(values[0]);
				
		
		ArrayList<Integer> D = new ArrayList<Integer> (); 

		for(int i = 1; i< values.length; i++){
			
			D.add(Integer.valueOf(values[i]));
			
		}
		
		System.out.println("n = " + values[0]);		
		JJ(n, D, 0, "");
		System.out.println("Number of combonations = " + Integer.toString(c));
		
		
	}
	


}
