package lytmus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class pair{
	int key;
	int value;
	 pair(int key,int value){
		this.key=key;
		this.value=value;
	}
}

class pairComp implements Comparator<pair>{

	public int compare(pair o1, pair o2) {
		return o1.value-o2.value;
	}
	
}
public class NumberOfVariables {
	public static void main(String args[]){
		int[] k={2,3,4,7};
		int n=100;
		ArrayList<pair> al= new ArrayList<>();
		for(int i=0;i<k.length;i++){
			pair temp = new pair(k[i],k[i]);
			al.add(temp);
		}
		int[] ans=generate(al,n);
		System.out.println(Arrays.toString(ans));
	}

	private static int[] generate(ArrayList<pair> k, int n) {
		Collections.sort(k,new pairComp());
		for(int j=0;j<n;j++){
		}
		int[] ans=new int[n];
		int prev=-1;
		for(int i=0;i<n;i++){
			pair temp=k.get(0);
			if(prev!=temp.value)
				{
				ans[i]=temp.value;
				prev=ans[i];
				}
			else{
					i--;
				}
			temp.value+=temp.key;
			Collections.sort(k,new pairComp());
		}
		return ans;
	}

}
