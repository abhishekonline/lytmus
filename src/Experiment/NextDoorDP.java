package Experiment;

public class NextDoorDP {
	public static void main(String args[]){
		int score=10;
		int[] runs={2,3,7};
		int ans=ways(score,runs);
		System.out.println("ANSWER= "+ ans);
	}

	private static int ways(int score, int[] runs) {
		if(score==0) return 0;
		if(score<2)return Integer.MAX_VALUE;
		int ans=0;
		for(int i=0;i<runs.length;i++){
			if(score-runs[i]>=0){
				ans=Math.min(ans, ways(score-runs[i], runs))+1;
			}
		}
		return ans;
	}

}
