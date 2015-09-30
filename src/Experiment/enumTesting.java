package Experiment;

public class enumTesting {
	public enum month{JAN,FEB,MAR,APR,MAY,JUNE,JULY,AUG,SEP,OCT,NOV,DEC}
	
	public static void main(String args[]){
		long abhi=Runtime.getRuntime().freeMemory();
		System.out.println(abhi);
		month m= enumTesting.month.JAN;
		System.out.println(m);
		switch(m){
		case JAN:
			System.out.println("its january");
			break;
		default: System.out.println("its not january");	
		}
	}
	
}
