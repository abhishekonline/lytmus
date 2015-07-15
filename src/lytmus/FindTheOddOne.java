package lytmus;

import java.util.Arrays;

public class FindTheOddOne {
	public static void main(String args[]){
//	I have an array of size N integers from 0 to n-1. 
//	Exactly one of them occurs odd number of times(instead of some other integers). 
//	Find that number in O(N) running time and O(1) space complexity. 
		
		int[] arr={1,2,3,4,1,2,2,3,4,1,2,3,4,1,1,2,3,4,2};
		FindTheOddOne n= new FindTheOddOne();
		int ans=n.findOdd(arr);
		System.out.println("ans="+ans);
		System.out.println(2^3^4^2);
	}

	public int findOdd(int[] arr) {
		
		int ans=arr[0];
		for(int i=1; i<arr.length;i++){
			System.out.println(ans);
			ans=ans^arr[i];
			
		}
		
		return ans;
	}

}
