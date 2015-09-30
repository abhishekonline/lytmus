package Experiment;

import java.util.ArrayList;
import java.util.List;

public class Listplay {
	public static void main(String args[]){
		List<Integer> ans= new ArrayList<Integer>();
		ans.add(1);
		List<Integer> an= new ArrayList<Integer>();
		an.add(1);
		ans.addAll(an);
		System.out.println(ans);
	}

}
