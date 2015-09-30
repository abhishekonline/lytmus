package Experiment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Assignment {
	static ArrayList<String> reject = new ArrayList<String>();
	static HashMap<String, Integer> register = new HashMap<String, Integer>();
	static HashMap<String, Integer> TwoGram = new HashMap<String, Integer>();
	static HashMap<String, Integer> ThreeGram = new HashMap<String, Integer>();
	static ArrayList<wordCount> wc = new ArrayList<>();
	static ArrayList<String> keywords = new ArrayList<String>();
	static String host;
	static Document doc = null;
	public static class wordCount {
		String word;
		int count;

		public wordCount() {
			word = null;
			count = 0;
		}

		public wordCount(String w, int c) {
			word = w;
			count = c;
		}
	}//end to wordCount class
	
	public static class wordCountComparator implements Comparator<wordCount> {

		public int compare(wordCount o1, wordCount o2) {
			return o1.count - o2.count;
		}

	} //end to wordCountComparator class
	
	public static void main(String args[]){
		if(args.length == 0)
	    {
	        System.out.println("Proper Usage is: java -jar Assignment.jar \"URL\"");
	        System.exit(0);
	    }
		//making list of common words in english, that we will reject from our result
		createRejectList("http://splasho.com/upgoer5/phpspellcheck/dictionaries/1000.dicin");
	     
		// taking out Keywords from meta tag of html page
	    createKeywordsList(args[0]); 
		
		// processing base page , and limit crawling to links of this page only
		processURL(args[0]);
		
		//Process links on base page
		crawlLinks();

		// FInally writing it in wc arraylist
		loadArrayList();

		// sorting Arraylist collevtion
		Collections.sort(wc,Collections.reverseOrder(new wordCountComparator()));
		
		//printing out the top ten
		int count = 0;
		int k = 0;
		while (count < 10) {
			String w = wc.get(k).word;
			int c = wc.get(k).count;
			if (!w.startsWith("-") && c > 3) {
				System.out.println(w);
				count++;
			}
			k++;

		}

	}// end to main class
	
	private static void crawlLinks() {
		Elements questions = doc.select("a[href]");
		for (Element link : questions) {
			if (link.attr("href").contains("login")
					|| link.attr("href").contains("register")
					|| link.attr("href").contains("forgotpassword"))
				continue;
			if (register.containsKey(link.attr("abs:href"))) {
				// System.out.println("visited");
				continue;
			} else {
				register.put(link.attr("abs:href"), 1);
				if (link.attr("abs:href") != null
						&& !link.attr("abs:href").equals(""))
					// System.out.println("going to visit : "+
					// link.attr("abs:href") + ">>" + register.size());
					processURL(link.attr("abs:href"));

			}

		}
	}// end to crawlLinks

	private static void loadArrayList() {
		for (String iti : TwoGram.keySet()) {
			String w = iti;
			int c = TwoGram.get(w);
			wordCount wcObj = new wordCount(w, c);
			wc.add(wcObj);
		}
		for (String iti : ThreeGram.keySet()) {
			String w = iti;
			int c = ThreeGram.get(w);
			wordCount wcObj = new wordCount(w, c);
			wc.add(wcObj);
		}
		
	}//end to loadArrayList

	private static void createKeywordsList(String string) {
		try {
			URL url = new URL(string);
			host = url.getHost();
			String[] hostWords = host.split("\\.");
			for (String s : hostWords)
				reject.add(s);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		try {
			doc = Jsoup.connect(string).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements meta = doc.select("meta[name]");
		for (Element iti : meta) {
			String[] temp = iti.attr("content").toLowerCase()
					.replaceAll("[^A-Za-z0-9- ]", " ").split(" ");
			if (temp.length != 0)
				for (String s : temp) {
					if (!s.trim().equals("") && !reject.contains(s.trim()))
						keywords.add(s);
				}
		}
		
	}//end to createKeywordsList

	private static void createRejectList(String string) {
		try {
	    	 URL url =new URL(string);
			BufferedReader urlreader= new BufferedReader( new InputStreamReader(url.openStream()));
			 String inputLine;
			while ((inputLine = urlreader.readLine()) != null){
				reject.add(inputLine.toLowerCase());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}//end to createRejectList

	private static void processURL(String attr) {
		{
			Document doc = null;
			try {
				doc = Jsoup.connect(attr).get();
			String text = doc.body().text().toLowerCase().replaceAll("[^A-Za-z0-9- ]","");
			String[] corpus=text.split(" ");
			for(int i=0;i<corpus.length-2;i++){
				if(corpus[i]==null || corpus[i].trim().equals("")|| !keywords.contains(corpus[i])|| reject.contains(corpus[i]))
					continue;
					
					//two gram
					if (reject.contains(corpus[i])
							|| reject.contains(corpus[i + 1])
							|| corpus[i + 1].trim().equals("")) {
						continue;
					} else {
						String doub = corpus[i] + " " + corpus[i + 1];
						doub = doub.toLowerCase().trim();
						if (doub.length() != 0) {
							if (TwoGram.containsKey(doub)) {
								int count2 = TwoGram.get(doub);
								TwoGram.put(doub, count2 + 1);
							} else
								TwoGram.put(doub, 1);
						}
					}
					
		        	//three gram
		        	
					if (reject.contains(corpus[i])
							|| reject.contains(corpus[i + 1])
							|| reject.contains(corpus[i + 2])
							|| corpus[i + 1].trim().equals("")
							|| corpus[i + 2].trim().equals("")) {
						continue;
					} else {
						String trip = corpus[i] + " " + corpus[i + 1] + " "
								+ corpus[i + 2];
						trip = trip.toLowerCase().trim();
						if (trip.length() != 0) {
							if (ThreeGram.containsKey(trip)) {
								int coun3t = ThreeGram.get(trip);
								ThreeGram.put(trip, coun3t + 1);
							} else
								ThreeGram.put(trip, 1);
						}
					}
				}
			
			
			}catch(IllegalArgumentException e){
				System.out.println("caught");
			}
			catch (IOException e) {
				
			}
		}
		
	}//end to processURL 
	
}//end to Assignment class
