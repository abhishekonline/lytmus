package lytmus;

import java.util.ArrayList;
import java.util.List;

public class MatrixSpiralPrint {
	public static void main(String args[]){
		
		int[][] a={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printSpiral(a,4,4);
		List<Integer> nl= new ArrayList<Integer>();
	}
	private static void printSpiral(int[][] a, int m, int n) {
		int top=0;
		int bottom=m-1;
		int left=0;
		int right=n-1;
		
		int dir=0;//symbolic of direction in which to print
		
		while(top<=bottom && left<=right){
			//case 1 left to right dir=0
			if(dir==0){
				
				for(int i=left;i<=right;i++)
				{
					System.out.print("["+a[top][i]+"]");
					
				}
				top++;
				dir=1;
				
			}else if(dir==1){//case 2 top to bottom dir=1
				
				for(int i=top;i<=bottom;i++){
					System.out.print("["+a[i][right]+"]");
				}
				right--;
				dir=2;
			}else if(dir==2){//case 3 right to left dir=2
				
				for(int i=right;i>=left;i--){
					System.out.print("["+a[bottom][i]+"]");
				}
				bottom--;
				dir=3;
				
			}else if(dir==3) {//case 4 bottom to up
				
				for(int i=bottom;i>=top;i--){
					System.out.print("["+a[i][left]+"]");
				}
				left++;
				dir=0;
			}
		}
		
	}
}
