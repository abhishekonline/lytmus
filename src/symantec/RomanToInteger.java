package symantec;
//Write a function to convert roman numerals to integers 
import java.util.HashMap;

public class RomanToInteger {
	static final HashMap< Character, Integer> hm= new HashMap<Character, Integer>();
	
	public static int romanToInt(String s) {
		hm.put('I', 1);
	  	hm.put('V', 5);
	  	hm.put('X', 10);
	  	hm.put('L', 50);
	  	hm.put('C', 100);
	  	hm.put('D', 500);
	  	hm.put('M', 1000);
		int ans=0;
		char[] arr= s.toCharArray();
		for(int i=0;i<arr.length;i++){
			ans+=value(arr[i]);
			if(i>0)
				{
				int j=i-1;
				while(j>=0 && arr[j]<arr[i]){
					ans-=2*value(arr[j]);
					j--;
				}
				}
		}
		
		return ans;
	}
private static int value(char c) {
		
		return hm.get(c);
	}
public static void main(String args[]){
	String input="MMMCM";
	System.out.println("Ans= "+romanToInt(input));
	
}
}
