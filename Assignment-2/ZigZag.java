import java.util.Scanner;

public class ZigZag {
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n, diff;
		n = sc.nextInt();
		int[] arr = new int[n];
		int[] ans_pos = new int[n];
		int[] ans_neg = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}

		for(int i=0;i<n;i++){
			ans_neg[i]=0;
			ans_pos[i]=0;
			for(int j=i-1;j>=0;j--){
				diff=arr[i]-arr[j];
				if(diff>0){ 
					ans_pos[i]=max(1+ans_neg[j],ans_pos[i]);
				}
				else if(diff<0){
				 	ans_neg[i]=max(1+ans_pos[j],ans_neg[i]);
				}
			}
		}

		System.out.println(max(ans_neg[n-1],ans_pos[n-1])+1);

	}

	static int max(int a,int b){
		return (a>b)?a:b;
	}
}