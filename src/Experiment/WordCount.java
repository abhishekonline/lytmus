package Experiment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

import javax.annotation.processing.FilerException;

public class WordCount {
	private static word temp;
	public static class word{
		int freq;
		String word;
		public word(String word,int freq){
			this.freq=freq;
			this.word=word;
		}
	}
	
	public static class wordcompare implements Comparator<word>{

		@Override
		public int compare(word o1, word o2) {
			int ans1=o1.freq-o2.freq;
			if(ans1==0)
				return o1.word.compareTo(o2.word);
			else return ans1;
		}
		
	}
	public static void main(String args[])
	{	ArrayList<word> words= new ArrayList<word>();
		HashMap<String, Integer> hm= new HashMap<String, Integer>();
		try {
			BufferedReader br= new BufferedReader(new FileReader("C:/Users/abhishek/08-722/lytmus/src/Experiment/test"));
			String line;
			while((line=br.readLine())!=null){
				
				String[] w= line.split(" ");
				for(String i:w){
					if(hm.containsKey(i)){
						hm.put(i, hm.get(i)+1);
					}else hm.put(i, 1);
				}
			}
			for(String s:hm.keySet()){
				word wo= new word(s,hm.get(s));
				words.add(wo);
			}
			Collections.sort(words, new wordcompare());
			for(word w:words){
				System.out.println(w.word+"->"+w.freq);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
