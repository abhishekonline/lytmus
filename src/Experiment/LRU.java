package Experiment;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU extends LinkedHashMap<Integer, Integer>{
	private static final long serialVersionUID = 1L;
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
	   protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
	      return size() > this.capacity;
	   }
	
	public static void main(String args[]){
		LRU cache= new LRU(3,0.1f);
		cache.put(1, 11);
		cache.put(2, 22);
		cache.put(3, 33);
		cache.put(4, 44);
		cache.put(5, 55);
		System.out.println(cache);
	}
}
