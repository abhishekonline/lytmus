package Experiment;

public class inheritence {
	 public static class a{
		public  a(){
			System.out.println("a.cons");
		}
		public void func(){
			System.out.println("a ka func");
		}
	}
	public static class b extends a{
		public  b(){
			super();
			System.out.println("b.cons");
		}
		
		public void func(){
			
			System.out.println("b ka func");
		}
	}
	
	public static void main(String args[]){
	
		a obj1= new b();
		obj1.func();
		
	}

}
