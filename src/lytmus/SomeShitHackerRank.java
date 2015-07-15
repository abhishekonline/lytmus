package lytmus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SomeShitHackerRank {
	public static void main(String args[]){
		int[] arr = null;
		int len=0;
		int diff=0;
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input;
			int count=0;
			while((input=br.readLine())!=null){
				if(count==0){
					String in1= input;
					String[] arrs=in1.split(" ");
					len=Integer.valueOf(arrs[0]);
					diff=Integer.valueOf(arrs[1]);
					arr= new int[len];
					count++;
					System.out.println("INput on count=0 "+len+" and diff= "+diff);
				}
				else if(count==1){
					String in=input;
					
					String[] arry= in.split(" ");
					for(int i=0;i<len;i++){
						arr[i]=Integer.valueOf(arry[i]);
					}
					System.out.println("INput on count=1 "+Arrays.toString(arr));
					break;
				}
				
			}
			//System.out.println(Arrays.toString(arr));
	 
		}catch(IOException io){
			io.printStackTrace();
		}	
		
		System.out.println(find(arr,diff));
		
    
	}

	private static int find(int[] arr, int diff) {
		int count=0;
		int len= arr.length;
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				if(arr[i]-arr[j]==diff)
					count++;
			}
		}
		return count;
	}

}
