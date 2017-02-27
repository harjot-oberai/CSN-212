import java.util.Scanner;

public class D2{

	static int ceil_index(int[] arr,int a,int b,int value){
		int m;
		while((b-a)>1){
			m=a+(b-a)/2;
			if(arr[m]>=value){ 
				b=m;
			}
			else{
				a=m;
			}
		}
		return b;
	}

	static int LISlength(int[] arr, int offset, int size){
		int[] LIS;
		int len=0;
		LIS = new int[size];
		LIS[0]=arr[offset + 0];
		len=1;
		for(int i=offset+1;i<size+offset;i++){
			if(arr[i]>LIS[len-1]){
				LIS[len]=arr[i];
				len++;
			}
			else if(arr[i]<LIS[0]){
				LIS[0]=arr[i];
			}
			else{
				LIS[ceil_index(LIS,-1,len-1,arr[i])]=arr[i];
			}
		}
		return len;
	}

	public static void main(String[] args){

		int t, n, ans, max;
		int[] arr;

		Scanner sc = new Scanner(System.in);

		t = sc.nextInt();

		while(t-- > 0){
			max = 0;
			ans = 0;
			n = sc.nextInt();
			arr = new int[2*n];
			for(int i=0;i<n;i++){
				arr[i] = sc.nextInt();
				arr[i+n]=arr[i];
			}
			for(int i=0;i<n;i++){
				ans=LISlength(arr, i, n);
				if(ans>max){ 
					max=ans;
				}
			}
			System.out.println(max);
		}

	}
}