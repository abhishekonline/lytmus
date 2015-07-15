package lytmus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HackerRankMissingAP {
	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
		int[] arr = null;
		int len=0;
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input;
			int count=0;
			while((input=br.readLine())!=null){
				if(count==0){
					len=Integer.valueOf(input);
					arr= new int[Integer.valueOf(input)];
					count++;
					System.out.println("INput on count=0 "+len);
				}
				else if(count==1){
					String in=input;
					
					String[] arry= in.split(" ");
					for(int i=0;i<len;i++){
						arr[i]=Integer.valueOf(arry[i]);
					}
					System.out.println("INput on count=1 "+input);
					break;
				}
				
			}
			//System.out.println(Arrays.toString(arr));
	 
		}catch(IOException io){
			io.printStackTrace();
		}	
		
		System.out.println(find(arr));
		
    }

	private static Object find(int[] arr) {
		int len=arr.length;
		int[] diff=new int[len-1];
		for(int i=0;i<diff.length;i++){
			diff[i]=arr[i+1]-arr[i];
		}
		for(int j=1;j<arr.length;j++){
			if(diff[j]!=diff[j-1]){
				System.out.println("Missing term is "+(arr[j]+diff[j-1]));
				return (arr[j]+diff[j-1]);
			}
		}
		return null;
	}

}
