package Experiment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinkCrawler {
//	static HashMap<String, Integer> register = new HashMap<String, Integer>();
	static ArrayList<String> register= new ArrayList<String>();
	static Document doc = null;
	
	public static void main(String args[]){
		if(args.length == 0)
	    {
	        System.out.println("Please pass \"URL\" as argument");
	        System.exit(0);
	    }
		crawlLinks(args[0]);
		for(String s:register)
		
				System.out.println(s);
		
	}
		private static void crawlLinks(String attr) {
			try {
				doc = Jsoup.connect(attr).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Elements links = doc.select("a[href]");
			for (Element link : links) {
				//ignoring login , register, forget password(they end up in being loop)
				if (link.attr("href").contains("login")
						|| link.attr("href").contains("register")
						|| link.attr("href").contains("forgotpassword"))
					continue;
				if (register.contains(link.attr("abs:href"))) {
					// System.out.println("visited");
					continue;
				} else {
					register.add(link.attr("abs:href"));
				}

			}
		}// end to crawlLinks
	}

