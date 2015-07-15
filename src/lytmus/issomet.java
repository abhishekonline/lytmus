package lytmus;

public class issomet {
	public static void main(String args[])
	{
		String number="127.12.25.16.9";
		number = number.replaceAll("\\D+","");
		System.out.println(number.length());
		
		char[] ph=new char[12];
		char[]	num=number.toCharArray();
		ph[3]='-';
		ph[7]='-';
		
		
		
		
		
		System.out.println(number);
		
	}

}
