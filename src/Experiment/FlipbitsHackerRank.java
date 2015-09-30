package Experiment;

public class FlipbitsHackerRank {
	static int bitFlip(int[] arr) {
		int num=0;
		int sum=0;
		int maxsum=0;
		int prev = 0;
		int start =0;
		int stop = 0;
		int onecount=0;
		for(int i=0;i<arr.length;i++){
			
			if(arr[i] == 1){
				num = -1;
				onecount++;
			}else if(arr[i] == 0){
				num = 1;
			}
			sum = sum + num;
			if(maxsum<sum){
				maxsum = sum;
				prev = start;
				stop = i;
			}else if(sum<0){
				sum = 0;
				start = i+1;
			}
		}
		
		//calculation after fliping the bits in the window
		for(int j=prev;j<=stop;j++){
			if(arr[j]==0)onecount++;
			else onecount--;
		}
		//System.out.println("onecount= "+ onecount);
		return onecount;
    }
	public static void main(String args[]){
		int[] in= {1,0,0,1,0};
		int ans=bitFlip(in);
		System.out.println(ans);
	}
}
