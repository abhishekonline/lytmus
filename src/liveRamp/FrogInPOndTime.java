package liveRamp;

import java.util.Arrays;

public class FrogInPOndTime {
	public static int solution(int A[], int X, int D) {
		//at current time frog can jump till here
				//When ever thid distance is enough to reach end of pond we return time
				//initializing with jump distance of Frog
				int stable_max=D;
				
				//we will run a loop on time, and at every second find where frog can reach, 
				//Updating stable_max
				for(int i=0;i<A.length;i++){
				   //condition to check that place where leaf is falling , can be reached by 
				   //frog . If he can reach then update the Stable_max
					if(A[i]<=stable_max)
				    	stable_max=Math.max(stable_max,A[i]+D);
					//checking if end of pond can be reached with current stable_max distance
					if(stable_max>X-1)return i;
					
				}

				//if frog can not reach after all the leaves have fallen
				//that means there is no way possible to reach shore
		        return -1;
	    
	}
	
	public static void main(String args[]){
		int[] time={1, 3, 1, 4, 2, 5};//, 7, 3
		int ans=solution(time, 7, 3);
		System.out.println("Ans= "+ans);
	}
}
