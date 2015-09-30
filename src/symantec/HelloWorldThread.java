package symantec;

public class HelloWorldThread extends Thread {
	final String print;
	
	//we will manipulate this value to decide which thread will wait
	static boolean keeper=true;
	
	final  boolean flag;
	final  Object lock;
	//constructor
	public HelloWorldThread(String print,Object lock,boolean flag){
		
		this.print=print;
		this.lock=lock;
		this.flag=flag;
		
	}
	
	
	
	public void run(){
		
		//this loop will print 3 hello and 3 world
		for(int i=0;i<6 && !Thread.currentThread().isInterrupted();i++){
		synchronized (lock) {
			if(flag==keeper){
				System.out.print(this.print+" ");
				keeper=!keeper;
				//notify message other threads that i am done, u can go ahead
				lock.notify();
			}else{
				try {
					//this ask thread to wait
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}
			}
			
			}
		}
	}
	
	public static void main(String args[]){
		//Sync will happen over this object named lock
		final Object lock = new Object();
		new Thread(new HelloWorldThread("hello",lock,true)).start();
		new Thread(new HelloWorldThread("world",lock,false)).start();
	}

}
