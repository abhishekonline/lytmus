package Experiment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HtmlParsing {
	public static void main(String args[]){
		try {
			URL url= new URL("https://www.google.com/intl/en/ads/?fg=1");
			BufferedReader in = new BufferedReader( new InputStreamReader(url.openStream()));

			        String inputLine;
			        while ((inputLine = in.readLine()) != null)
			        {
			        	//inputLine.replaceAll("\\<[^>]*>","");
			            System.out.println(inputLine.replaceAll("\\<.*?\\>", ""));
			            
			        }
			        in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
