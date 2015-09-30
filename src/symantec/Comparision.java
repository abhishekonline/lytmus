package symantec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import symantec.Comparision.person;

public class Comparision {
	
	static class person{
		String name;
		int age;
		public person(String name, int age){
			this.name= name;
			this.age=age;
		}
	}
	
	public static class compare implements Comparator<person>{

		@Override
		public int compare(person a, person b) {
			int ans= a.name.compareTo(b.name);
			if(ans==0){
				return a.age-b.age;
			}else return ans;
		}
	}
	
	public static void main(String args[]){
		ArrayList<person> p= new ArrayList<Comparision.person>();
		p.add(new person("gugun", 19));
		p.add(new person("kbhi", 24));
		p.add(new person("gugun", 19));
		Collections.sort(p, new compare());
		Iterator<person> i= p.iterator();
		while(i.hasNext()){
			System.out.println(i.next().name);
		}
	}

}
