package lytmus;

import java.awt.font.NumericShaper;
import java.util.Arrays;

public class Seperatingnegnpos {
	public static void main(String args[]){
		int[] number={-2,9,10,-11,8,-27,99,-101,0};
		int len=number.length;
		int i=0;
		int j=len-1;
		
		while(i<j){
			while(number[i]<0 && i<j)
			{
				i++;
			}
			while(number[j]>0 && j>i)
			{
				j--;
			}
			swap(i,j,number);
			
		}
				System.out.println(Arrays.toString(number));
		
	}

	private static void swap(int i, int j,int[] num) {
		System.out.println("swap called "+","+num[i]+","+num[j]);
		int temp=num[i];
		num[i]=num[j];
		num[j]=temp;
		
	}

}
