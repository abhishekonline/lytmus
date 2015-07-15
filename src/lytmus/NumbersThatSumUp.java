package lytmus;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given an array of numbers, find all the numbers which add up to given sum
 * amazon
 */
public class NumbersThatSumUp {
	static ArrayList<String> ans= new ArrayList<String>();
	public static void main(String args[])
	{	
		int[] arr= {2,3,4,1};
		boolean[] mark= new boolean[arr.length];
		int sum=5;
		find(arr, sum, new ArrayList<Integer>(),mark);
	}
	private static void find(int[] arr, int sum,ArrayList<Integer> al, boolean[] mark) {
		if(sum==0) {
			Integer[] temp= al.toArray(new Integer[al.size()]);
			Arrays.sort(temp);
			String idea= Arrays.toString(temp);//temp.toString();
			if(!ans.contains(idea)){
				//System.out.println(idea);
				System.out.println(Arrays.toString(temp));
				ans.add(idea);
			}
			
		}
		else{
			for(int i=0;i<arr.length;i++){
				if(mark[i]) continue;
				al.add(arr[i]);
				mark[i]=true;
				find(arr,sum-arr[i],al,mark);
				mark[i]=false;
				al.remove(al.size()-1);
			}
		}
		
	}

	

	
}
