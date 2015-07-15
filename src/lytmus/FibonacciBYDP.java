package lytmus;

public class FibonacciBYDP {
	public static void main(String args[]){
		int num=20;
		
		double one=0;
		double two=1;
		if(num<2)
			System.out.println(num);
		else
		{double ans=0;
			for(int i=2;i<num;i++){
				ans=one+two;
				one=two;
				two=ans;
			}
			System.out.println(ans);
		}
	}
}
