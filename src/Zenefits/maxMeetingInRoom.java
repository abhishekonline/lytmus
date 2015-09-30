package Zenefits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class maxMeetingInRoom {
	public static int maxMeetings(ArrayList<meeting> day){
		int count=0;
		int busy=0;
		for(meeting i:day){
			//if at start time room is free, assign it to meeting, update meeting counter, update busy
			if(i.start>=busy)
			{
				busy=i.end;
				count++;
				System.out.println(i.start+","+i.end);
			}
		}
		return count;
	}
	
	public static void main(String args[]){
		meeting one=new meeting(0, 2);
		meeting two=new meeting(1, 4);
		meeting three=new meeting(3, 5);
		meeting four=new meeting(16, 18);
		meeting five=new meeting(8, 12);
		meeting six=new meeting(14, 15);
		meeting seven=new meeting(15, 18);
		meeting eight=new meeting(18, 19);
		
		ArrayList<meeting> day= new ArrayList<meeting>();
		day.add(one);
		day.add(two);
		day.add(three);
		day.add(four);
		day.add(five);
		day.add(six);
		day.add(seven);
		day.add(eight);
		Collections.sort(day);
		int ans= maxMeetings(day);
		System.out.println(ans);
//		int ans2= maxRooms(day);
//		System.out.println("ANSWER= "+ans2);
		
	}

	private static int maxRooms(ArrayList<meeting> day) {
		int roomCount = 0;
		
		while(day.size()>0){
			Collections.sort(day);
			int busy=0;
			System.out.println("in"+day.size());
			roomCount++;
			for(int i=0;i<day.size();i++){
				//if at start time room is free, assign it to meeting, update meeting counter, update busy
				if(day.get(i).start>=busy)
				{
					busy=day.get(i).end;
					System.out.println(day.get(i).start+","+day.get(i).end);
					day.remove(i);
					i--;
				}
			}
			day=new ArrayList<meeting>(day);
			
		}
		
		return roomCount;
	}
}

class meeting implements Comparable<meeting> {
	int start;
	int end;
	int name;
	public  meeting(int start, int end){
		this.start=start;
		this.end=end;
	}
	
	public  int compare(meeting o1, meeting o2) {
		return o1.end-o2.end;
	}

	@Override
	public int compareTo(meeting o) {
		// TODO Auto-generated method stub
		return this.end-o.end;
	}
}

class compareStart implements Comparator<meeting>{

	@Override
	public int compare(meeting o1, meeting o2) {
		
		return o1.start-o2.start;
	}
	
}