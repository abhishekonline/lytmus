package lytmus;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class AnagramSort {
	public static void main(String args[])
	{
		String[] test= {"what","twha","for","rof","bat","tab"};
		Collections.sort(Arrays.asList(test),new AnagramComparator());
		System.out.println(Arrays.toString(test));
	}
	public static class AnagramComparator implements Comparator<String> {
		public String sortChars(String s) {
			char[] content = s.toCharArray();
			Arrays.sort(content);
			return new String(content);
		}

		public int compare(String s1, String s2) {
			return sortChars(s1).compareTo(sortChars(s2));
		}
	}
	
}
