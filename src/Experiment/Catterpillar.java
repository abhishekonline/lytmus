package Experiment;

public class Catterpillar {
	static int countUneatenLeaves(int N, int[] A) {
		char[] mark= new char[N];
		for(int i=0;i<N;i++){
			mark[i]='o';
		}
		int eat=0;
		for(int i=0;i<A.length;i++){
			//System.out.println(A[i]);
			int temp=A[i];
			int counter=1;
			while(temp<=N){
				//System.out.print(" EAT: "+temp);
				if(mark[temp-1]=='o')
					eat++;
				mark[temp-1]='e';
				temp=A[i]*(++counter);
			}
		}
		return N-eat;
    }
	
	public static void main(String args[]){
		int[] in={2,4,5};
		int ans=countUneatenLeaves(10, in);
		System.out.println(" ANSWER= "+ans);
	}

}
