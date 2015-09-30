package liveRamp;

public class SankalpNail {
	public static int solution(int[] a,int k){
		int n=a.length;
		int best=0;
		int count=0;
		
		for(int i=0;i<n-k-1;i++){
			System.out.println(a[i]==a[i+1]);
			if(a[i]==a[i+1])
				count++;
			else count=0;
			if(best<count)
				best=count;
		}
		
		int result=best+k+1;
		System.out.println("best= "+(best)+", result="+result);
		return n>k+1?result:n;
	}
	
	public static void main(String args[]){
		int[] x={1,1,3,4};
		int ans=solution(x, 2);
		System.out.println(ans);
	}
}
