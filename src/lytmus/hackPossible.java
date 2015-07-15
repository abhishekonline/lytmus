package lytmus;

public class hackPossible {
	static String isitpossible(int a, int b, int c, int d) {
		
		boolean ans= do1(a,b,c,d);
		
		return ans?"Yes":"No";
		
    }
	private static boolean do1(int a, int b, int c, int d) {
		if(a>c || b>d) return false;
		else{
			int[] ans1=do11(a,b);
			int[] ans2=do12(a,b);
			if(ans1[0]==c && ans1[1]==d)
				return true;
			if(ans2[0]==c && ans2[1]==d)
				return true;
			else return(do1(ans1[0],ans1[1],c,d) || do1(ans2[0],ans2[1],c,d));
		}
	}
	private static int[] do12(int a, int b) {
		int[] ans=new int[2];
		ans[1]=a+b;
		ans[0]=a;
		return ans;
	}
	private static  int[] do11(int a, int b) {
		int[] ans=new int[2];
		ans[0]=a+b;
		ans[1]=b;
		return ans;
		
	}
	public static void main(String args[]){
		
		System.out.println(isitpossible(1, 4, 9, 4));
	}
}
