package Experiment;

import java.util.ArrayList;
import java.util.Arrays;

//# Given a score for one team in American football, return each way the team
//# could have arrived at that score. For simplicity, assume the only ways
//# to score are 2-point safeties, 3-point field goals, and 7-point TDs

public class NextDoor {
	static int count=0;
	static ArrayList<String>ans= new ArrayList<String>();
public static void main(String args[]){
	int score= 10;
	
	numberOfWays(score,new int[3]);
	System.out.println("answer="+count);
	System.out.println(ans.size());
	
}

private static void numberOfWays(int score, int[] is) {
	count++;
	if(score==0){
		
		
		if(!ans.contains(Arrays.toString(is)))
			{
			System.out.println(Arrays.toString(is));
			ans.add(Arrays.toString(is));
			}
		
		return;
	}
	else{
		if(score>=2){
			score=score-2;
			is[0]++;
			numberOfWays(score, is);
			is[0]--;
			score=score+2;
		}
		if(score>=3){
			score=score-3;
			is[1]++;
			numberOfWays(score, is);
			is[1]--;
			score=score+3;
		}
		if(score>=7){
			score=score-7;
			is[2]++;
			numberOfWays(score, is);
			is[2]--;
			score=score+7;
		}
		if(score==1){
			return;
		}
	}
}
}
