package lytmus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FinbonacciSeries {
	
	public static void main(String args[])
	{	
		int input=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Limit of Finbonacci series: ");
        try {
			String s = br.readLine();
			input= Integer.parseInt(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
        int[] output= new int[input];
        output[0]=0;
        for(int i=1;i<input;i++){
        	if(i==1)
        	{
        		output[i]=i+output[i-1];
        	}
        	else
        		output[i]=output[i-2]+output[i-1];
        }
        
        System.out.println(Arrays.toString(output));
        
        int[] fib= new int[input];
        int x=fibonacci(input);
        System.out.println(x);
        System.out.println(Arrays.toString(fib));
        
	}

	 public static int fibonacci(int number){
	        if(number == 1 || number == 2){
	            return 1;
	        }
	      
	        return fibonacci(number-1) + fibonacci(number -2); //tail recursion
	    }
	
}
