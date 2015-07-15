package lytmus;


//towers.java
//solves the towers of Hanoi puzzle
//to run this program: C>java TowersApp
////////////////////////////////////////////////////////////////
public class Hanoi {
	static int nDisks = 2;
	static int MoveCount=0;
	public static void main(String[] args) {
		doTowers(nDisks, 'A', 'B', 'C');
		System.out.println("Moves= "+MoveCount);
	}

	// -----------------------------------------------------------
	public static void doTowers(int topN, char from, char inter, char to) {
		MoveCount++;
		if (topN == 1)
			System.out.println("Disk 1 from " + from + " to " + to);
		else {
			doTowers(topN - 1, from, to, inter); // from-->inter
			System.out.println("Disk " + topN + " from " + from + " to " + to);
			doTowers(topN - 1, inter, from, to); // inter-->to
		}
	}
	// ----------------------------------------------------------
	
} // end class TowersApp
// //////////////////////////////////////////////////////////////
