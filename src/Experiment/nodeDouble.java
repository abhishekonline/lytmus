package Experiment;

public class nodeDouble<t> {
	
	public t value;
	int key;
	nodeDouble next;
	nodeDouble prev;
	public nodeDouble(int key,t value) {
		this.value=value;
		this.key=key;
		next=prev=null;
	}

}
