package lytmus;

import java.util.ArrayList;
import java.util.Stack;

public class zenefits {
	public static void main(String args[]){
		ArrayList<ArrayList<String>> input=new ArrayList<ArrayList<String>>();
		ArrayList<String> temp=new ArrayList<String>();
		temp.add("+");
		ArrayList<String> temp1=new ArrayList<String>();
		temp1.add("100");
		ArrayList<String> temp2=new ArrayList<String>();
		temp2.add("200");
		input.add(temp);
		input.add(temp1);
		input.add(temp2);
		int ans= eval(input);
		System.out.println(ans);
	}

	private static int eval(ArrayList<ArrayList<String>> input) {
		Stack<Integer> stack= new Stack<Integer>();
		int len=input.size();
		
		for(int i=len-1;i>0;i--){
			
			if(input.get(i).size()!=1)
				stack.push(evalSingle(input.get(i)));
			else if(input.get(i).get(0).equals("+"))
				 return calculate("PLUS",stack);
			else if(input.get(i).get(0).equals("*"))
				return calculate("MUL",stack);
			else if(input.get(i).get(0).equals("/"))
				return calculate("DIV", stack);
			else if(input.get(i).get(0).equals("-"))
				return calculate("MIN", stack);
			else
				stack.push(Integer.valueOf(input.get(i).get(0)));
				}
		return stack.peek();
			}

	private static int calculate(String op, Stack<Integer> stack) {
		if (op.equals("PLUS")) {
			int sum = 0;
			while (stack.size() > 0) {
				sum += stack.pop();
			}
			return sum;
		}
		else if(op.equals("MUL")){
		    int prod =stack.pop();
			while (stack.size() > 0) {
				prod *= stack.pop();
			}
			return prod;
		}
		else if(op.equals("DIV")){
			int one=stack.pop();
			int two=stack.pop();
			return two/one;
		}
		else if(op.equals("MIN")){
			int one=stack.pop();
			int two=stack.pop();
			return two-one;
		}
		return 0;
	}

	private static Integer evalSingle(ArrayList<String> arrayList) {
		
		return null;
	}

}
