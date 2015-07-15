package lytmus;

import java.util.LinkedList;

public class patterngenration {
	static LinkedList<String> generate(String pattern) {
		LinkedList<String> strings = new LinkedList<String>();
		int pos = pattern.indexOf("?");
		if(pos < 0) {
			strings.add(pattern);
		} else {
			String zeroPattern = pattern.substring(0, pos) + "0" + pattern.substring(pos+1);
			String onePattern = pattern.substring(0, pos) + "1" + pattern.substring(pos+1);
			strings.addAll(generate(zeroPattern));
			strings.addAll(generate(onePattern));
		}
		return strings;
	}
public static void main(String args[]){
	
	LinkedList<String >ans=generate("11??");
	int i=0;
	while(i!=ans.size()){
		System.out.println(ans.get(i));
		i++;
	}
}
}
