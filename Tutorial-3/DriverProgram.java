import java.util.Scanner;

public class DriverProgram{

	public static void main(String args[]){

		IntervalTree intervalTree = new IntervalTree();
		Scanner sc=new Scanner(System.in);

		int type = 1;

		System.out.println("Format to insert Interval 	: \"1 lowValue highValue\"");
		System.out.println("Format to delete Interval 	: \"2 lowValue highValue\"");
		System.out.println("Format to search for Interval overlap  	: \"3 lowValue highValue\"");
		System.out.println("Input to stop the execution : \"-1\"");
		while(type!=-1){
			IntervalNode temp = new IntervalNode();
			type = sc.nextInt();
			if(type==1 || type==2 || type==3){
				temp.setLow(sc.nextInt());
				temp.setHigh(sc.nextInt());
				while(temp.getHigh() < temp.getLow()){
					System.out.println("Please enter a valid interval to insert");
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
				if(x!=null){
					System.out.println("{" + x.getLow() + "," + x.getHigh() + "}");
				}
			}
			else if(type!=-1){
				System.out.println("Please give a valid input");
			}
		}

	}
}