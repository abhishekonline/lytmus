package Experiment;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class gugunQue {
	public static void main(String args[]){
		int A[] = {2,5,7,4,2,6};
		int k = 3;
		int ans[]= heightWindow(A,k);
		System.out.println(Arrays.toString(ans));
//		HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
//		System.out.println("ans"+map.put(5,8));
		int[][] n= new int[3][5];
		System.out.println(n.length);
		System.out.println(n[0].length);
	}

	private static int[] heightWindow(int[] a, int k) {
		Deque<Integer> dq= new LinkedList<>();
		int[] ans= new int[a.length-k];
		int high=Integer.MIN_VALUE;
		int high2=Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++){
			
			if(dq.size()<3){
				
				dq.addLast(a[i]);
				if(high<=a[i]){
					high2=high;
					high=a[i];
				}
				
			}else{
				if(dq.peekFirst()==high){
					high=high2;
				}
				if(dq.peekFirst()==high2){
					high2=0;
				}
				ans[i-k]=high;
				dq.removeFirst();
				dq.addLast(a[i]);
				if(high<=a[i]){
					high2=high;
					high=a[i];
				}
				if(high2<a[i] && a[i]<high){
					high2=a[i];
				}
			}
			//System.out.println(high+","+high2);
		}
		return ans;
	}

}
