package lytmus;

public class RemoveWhiteSpacesInString {
	public static void main(String args[]){
		String input= "abc	";
		
		char[]	c= input.toCharArray();
		char[]  ans=new char[c.length];
		int count=0,j=0;
		for(int i=0;i<c.length;i++){
			if(Character.isWhitespace(c[i]))
			{
				System.out.println(++count);
				
			}
			else
				ans[j++]=c[i];
		}
		System.out.println(ans.length);
		String out=String.valueOf(ans).substring(0, c.length-count);
		System.out.println(out.length());
		System.out.println(out);
		
		
		//System.out.println(input.replaceAll("\\s", ""));
		
	}

	

}
