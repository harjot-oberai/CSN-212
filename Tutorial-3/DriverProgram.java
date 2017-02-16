import java.util.Scanner;

public class DriverProgram{

	public static void main(String args[]){

		IntervalTree intervalTree = new IntervalTree();
		Scanner sc=new Scanner(System.in);

		int type = 1;

		System.out.println("Follow the the following instructions for input:\n");
		System.out.println("To insert an interval: \"1 low_value high_Value\"\n");
		System.out.println("To delete an interval: \"2 low_value high_Value\"\n");
		System.out.println("To search an interval-overlap: \"3 low_value high_Value\"\n");
		System.out.println("To stop the execution: \"-1\"\n");
		while(type!=-1){
			IntervalNode temp = new IntervalNode();
			type = sc.nextInt();
			if(type==1 || type==2 || type==3){
				temp.setLow(sc.nextInt());
				temp.setHigh(sc.nextInt());
				while(temp.getHigh() < temp.getLow()){
					System.out.println("Not the valid interval. Enter the interval values again:\n");
					temp.setLow(sc.nextInt());
					temp.setHigh(sc.nextInt());
				}
			}
			if(type==1){
				intervalTree.insert(temp);
			}
			else if(type==2){
				intervalTree.deleteInterval(temp);
			}
			else if(type==3){
				IntervalNode x=new IntervalNode();
				x=intervalTree.search(temp);
				System.out.println(x.getLow());
			}
			else if(type!=-1){
				System.out.println("Invalid input, please give input again.\n");
			}
			//show(root); System.out.println(endl;
		}

	}
}