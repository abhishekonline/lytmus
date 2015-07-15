package lytmus;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class StringT9 {
	public static void main(String args[]){
		
		//String input="22233#23";
		String input="2#22#44#444#7777#44#33#55#8";
		char[] in=input.toCharArray();
		
		char prev,curr = 0;
		prev=in[0];
		int count=0;
		//to find change in sequence
		for(char i:in){
			curr=i;
			if(curr==prev)
				{
				count++;
				prev=curr;
				}
			else
			{	
				printChar(prev,count);//if prev is not same as curr,
									//	call helper function with current count
				count=1;
				prev=curr;
			}
		}
		if(prev==curr)//corner case
			{
			printChar(prev,count);
			}
		
		
		patterngenration n= new patterngenration();
		LinkedList<String>list= n.generate("11?0?");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		PrintWriter pw;
		try {
			pw = new PrintWriter("abhishek.txt");
			pw.println("abhishek Shukla try two");
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("hello world");
			e.printStackTrace();
		}
		
	}

	private static  void printChar(char prev, int count) {
		//to handle space
		if(prev=='#')
			{
			System.out.print(" ");
			return;
			}
		if((prev=='8'))//special case of 4 char in 7 and 9
		{
			int b=Character.getNumericValue(prev);
			char a= (char) ((66+((b-2)*3))+count-1);
			System.out.print(a);
			return;
			
		}
		//normal key presse
		int b=Character.getNumericValue(prev);
		char a= (char) ((65+((b-2)*3))+count-1);
		System.out.print(a);
		
	}
}
