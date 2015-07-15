package lytmus;

import java.util.Arrays;
import java.util.HashMap;

public class countduplicates {
	public static void main(String args[]){
		int[] input={1,1,3,4,5,6,7,7};
		System.out.println(func(input));
	}

	private static int func(int[] input) {
		HashMap<Integer, Integer> hm= new HashMap<Integer, Integer>();
		for(int i=1;i<input.length;i++){
			if(hm.containsKey(input[i])) continue;
			hm.put(input[i], i);
		}
		return input.length-hm.size();
	}

}
