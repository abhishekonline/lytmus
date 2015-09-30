package Experiment;

import java.util.Stack;
/*
 * Write a function to reverse all the words in a string separated by spaces. 
 * There will be k spaces, and k + 1 words. 
 */
public class Reverse_words_in_string {
	public static void main(String args[]){
		String input="my name is abhishek";
//		String ans= convert(input);
		String ans= convert1(input);
		
		System.out.println(ans);
	}
	
	private static String convert1(String input) {
		String[] temp=input.split(" ");
		StringBuffer ans= new StringBuffer();
		
		for(int i=temp.length-1;i>=0;i--){
			ans.append(temp[i]);
			if(i!=0)
				ans.append(" ");
		}
		
		return ans.toString();
	}

	public static String convert(String input){
		Stack<Character> s= new Stack<Character>();
		char[] in= input.toCharArray();
		char[] out= new char[in.length];
		int start;
		int i=0;
		while (i < in.length) {
			start = i;
			while (i<in.length && !Character.isWhitespace(in[i])) {
				s.push(in[i]);
				i++;
			}
			i++;
			while (s.size()!= 0) {
				out[start++] = s.pop();
			}
		}
		return new String(out);
		
	}
}
