import java.util.ArrayList;
import java.util.Scanner;

public class GiftWrappingAlgo {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("No. of points= ");
		n = sc.nextInt();
		ArrayList<Point> point = new ArrayList<Point>();
		System.out.println("Enter the coordinates of each points: <x> <y>");
		for(int i=0; i<n ;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			Point p = new Point(x, y);
			point.add(p);
		}

		ArrayList<Point> convex_hull_set = new ArrayList<Point>();
		int h=0;
		
		// find the left-most point
		int l=0;
		for(int i=1;i<n;i++){
			if(point.get(i).x < point.get(l).x){
				l=i;
			}
		}
		//start from the leftmost point, keep moving clockwise
		//until we reach the start point again.
		int p=l, q;
		do{
			convex_hull_set.add(h++, point.get(p));
			q=(p+1)%n;
			for(int i=0;i<n;i++){
				if(orientation(point.get(p), point.get(i), point.get(q)) == -1) {
					q=i;
				}
			}
			p=q;
		} while(p!=l);
		System.out.println("The points in the Convex hull using Quick Hull are: ");
		for(int i=0; i<h; i++){
			PrintPoint(convex_hull_set.get(i));
		}
	}

	static void PrintPoint(Point p) {
		System.out.println(p.x + " " + p.y);
	}

	// clockwise: return -1
	// anti-clockwise: return 1
	// collinear: return 0
	static int orientation(Point a, Point b, Point c){
		int temp = a.x*(b.y-c.y) + b.x*(c.y-a.y) + c.x*(a.y-b.y);
		if(temp > 0) return 1;
		if(temp < 0) return -1;
		return 0;
	}

}