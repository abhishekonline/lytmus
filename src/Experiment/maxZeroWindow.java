package Experiment;

import java.util.Arrays;

public class maxZeroWindow {
public static void main(String args[]){
	int[] arr={1,0,0,0,0,1,0};
	int[]ans= maxWindow(arr);
	System.out.println(Arrays.toString(ans));
}

private static int[] maxWindow(int[] arr) {
	int[] ans= new int[2];
	int start=0;
	int stop=0;
	int maxsum=0;
	int sum=0;
	for(int i=0;i<arr.length;i++){
		if(arr[i]==1)sum--;
		else {
			sum++;
		}
		if(maxsum<sum){
			maxsum=sum;
			
			stop=i;
		}
		if(sum<0){
			sum=0;
			start=i+1;
		}
	}
	ans[0]=start;
	ans[1]=stop;
	return ans;
}
}
