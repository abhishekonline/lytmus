package Experiment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Sankalp {
	
	public static void main(String args[]){
		int[][] input={{1,2,3,4}};
//		System.out.println(input.length+","+input[0].length);
		int[][] ans= moveColumn(input, 1, 3);
//		System.out.println(ans.length+","+ans[0].length);
		for(int i=0;i<ans.length;i++){
			for(int j=0;j<ans[0].length;j++){
				System.out.print(ans[i][j]+",");
			}
			System.out.println();
		}
	}
	
	private static int[][] moveColumn(int[][] input,int from, int to){
		//Variable to hold value while we swwap the data from one grid cell to another
		int temp;
		//Row number to store the number of rows, We will use it to run for loop
		int rowNumber= input.length;
		
		//For loop to go row wise and swap that data from each to and from columns
		for(int i=0;i<rowNumber;i++){
			temp=input[i][from];
			input[i][from]=input[i][to];
			input[i][to]=temp;
		}
		
		//Returning the newly column moved grid
		return input;
		
	}
	
	

}
