package symantec;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

//Find duplicates in a sorted array and print the unique elements? e.g. A = {1,2,2,3,3,3,4,5}, the output should be {1,2,3,4,5}  
public class PrintUniqueArray {
	public static int[] unique(int[] arr){
	int p1=0;
	for(int i=1;i<arr.length;i++){
		if(arr[p1]==arr[i]){
			continue;
		}else{
			arr[++p1]=arr[i];
		}
		
	}
	System.out.println(Arrays.toString(arr)+","+p1);
	return arr;
	}
	
	public static void main(String args[]){
		int[] input={1,2,2,3,3,3,4,5};
		int[] ans=unique(input) ;
		HashMap<Integer, Integer> hm= new HashMap<>();
		hm.put(1, 1);
		hm.put(2, 2);
		hm.put(3, 3);
		hm.put(4, 5);
		Iterator<Entry<Integer, Integer>> i = hm.entrySet().iterator();
		while(i.hasNext()){
			Integer g = i.next().getKey();
			System.out.println(g);
			if(hm.get(g)!=g)
				i.remove();
		}
		
		
	}
}
