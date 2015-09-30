package Experiment;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU extends LinkedHashMap<String, Integer>{
	   private int capacity;
	    
	   public LRU(int capacity, float loadFactor){
	      super(capacity, loadFactor, true);
	      this.capacity = capacity;
	   }
	    
	   /**
	    * removeEldestEntry() should be overridden by the user, otherwise it will not 
	    * remove the oldest object from the Map.
	    */
	   @Override
	   protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest){
	      return size() > this.capacity;
	   }
	
	public static void main(String args[]){
		LRU cache= new LRU(3,0.1f);
		cache.put("home", 1);
		cache.put("work", 1);
		cache.put("home", 1);
		
		cache.put("home", 1);
		cache.put("home", 55);
		if(cache.containsKey("home")){
			cache.put("home", cache.get("home")+1);
		}
		System.out.println(cache);
	}
}
