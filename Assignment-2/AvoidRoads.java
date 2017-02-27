import java.util.Scanner;

public class AvoidRoads{

	static long[][] ans = new long[101][101];

	public static void main(String[] args){

		for(int i=0;i<101;i++){
			for(int j=0;j<101;j++){
				ans[i][j] = 0;
			}
		}

		int width, height;
		Scanner sc = new Scanner(System.in);
		width = sc.nextInt();
		height = sc.nextInt();

		int m,a,b,c,d;

		m = sc.nextInt();

		for(int i=0;i<m;i++){
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			d = sc.nextInt();

			if(a==c){
				if(b>d) ans[a][b]=-1;
				else ans[c][d]=-1;
			}
			else{
				if(a>c) ans[a][b]=-2;
				else ans[c][d]=-2;
			}
		}

		for(int i=0;i<=width;i++){
			for(int j=0;j<=height;j++){
				if(i==0 && j==0) {
				 	ans[i][j]=1;
				}
				else {
					if(ans[i][j]==0){
						if(j!=0){ 
							ans[i][j]+=ans[i][j-1];
						}
						if(i!=0){ 
							ans[i][j]+=ans[i-1][j];
						}
					}
					else if(ans[i][j]==-1){
						if(i==0){
						 	ans[i][j]=0;
						}
						else {
							 ans[i][j]=ans[i-1][j];
						}
					}
					else if(ans[i][j]==-2){
						if(j==0){ 
							ans[i][j]=0;
						}
						else{ 
							ans[i][j]=ans[i][j-1];
						}
					}
				}
			}
		}

		System.out.println(ans[width][height]);

	}
}