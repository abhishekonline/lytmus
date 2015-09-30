package Experiment;

public class matrix {
	public static void main(String args[]){
		
	String s= "aabaa";
	boolean n=check(s);
	System.out.println(n);
	}
	
	public static boolean check(String s){
		char[] c= s.toCharArray();
		int len= c.length;
		int start=0;
		int end=len-1;
		while(start<end){
			if(c[start]!=c[end])return false;
			start++;
			end--;
		}
		return true;
	}
}
