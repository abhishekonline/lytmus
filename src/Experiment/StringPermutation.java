package Experiment;

import java.util.ArrayList;

public class StringPermutation {
	public static void main(String args[]){
		
		String input="LsS";
		ArrayList<String> ans= permute(input);
		System.out.println(ans);
	}

	private static ArrayList<String> permute(String input) {
		ArrayList<String> ans= new ArrayList<String>();
		String curr="";
		char[] c=input.toCharArray();
		boolean[] mark=new boolean[c.length];
		helper(c,mark,ans,curr);
		return ans;
	}

	private static void helper(char[] c, boolean[] mark, ArrayList<String> ans,
			String curr) {
		
		if(curr.length()==mark.length){
			ans.add(curr);
			return;
		}
		for(int i=0;i<c.length;i++){
			if(mark[i])continue;
			mark[i]=true;
			helper(c, mark, ans, curr+c[i]);
			mark[i]=false;
		}
		
	}
}
