package Experiment;

import java.util.HashMap;

public class LRULinklist<t> {
	private int capasity;
	private nodeDouble<t> front=null;
	private nodeDouble<t> end=null;
	private HashMap<Integer, nodeDouble<t>> hm= new HashMap<Integer, nodeDouble<t>>();
	
	//constructor
	public LRULinklist(int capasity) {
		
		this.capasity=capasity;
		System.out.println("Initialized with capasity= "+capasity);
	}
	public void set(int key,t value){
		//cache is size limit, delete from end insert in front
		if(hm.size()>=capasity){
			System.out.println("clearing cache "+end.value);
			remove(end);
			add(key,value);
		}else{
			add(key,value);
		}
	}
	
	private void add(int key, t value) {
		nodeDouble<t> inNode= new nodeDouble<>(key, value);
		//add to hash map
		hm.put(key, inNode);
		
		//add to doubly link list
		
		if(front==null){
			front=inNode;
			end=inNode;
		}else{
			front.prev = inNode;
			inNode.next = front;
			front = inNode;
		}
	}
	
	private void remove(nodeDouble<t> node) {
		nodeDouble prev= node.prev;
		
		if(node==end){
			if(prev==null){
				end=null;
			}else
			prev.next=null;
			end=prev;
		}else{
			prev.next=node.next;
			node.next.prev=prev;
		
		}
		hm.remove(node.key);
	}
	public nodeDouble<t> get(int key){
		nodeDouble<t> ans=null;
		//look into hashmap, if founf return value and put it in front on list
		if(hm.containsKey(key)){
			System.out.println("cache hit");
			 ans=hm.get(key);
			 remove(ans);
			 add(key, ans.value);
		}
		
		return ans==null? new nodeDouble<t>(key, null):ans;
	}
	public static void main(String args[]){
		LRULinklist<String> obj= new LRULinklist<>(3);
		obj.set(1, "test1");
		obj.get(2);
		obj.set(2, "test2");
		obj.set(3, "test3");
		obj.set(4, "test4");
		nodeDouble<String> ans= obj.get(1);
		System.out.println(ans.value);
		
	}
}
