import java.io.*;
import java.util.*;

public class DriverProgram {
	public static void main(String[] args){
		int count = 0;
		Graph graph = null;
		int src = 0;
		File input = new File("input.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(input))) {
		String line;
			while ((line = br.readLine()) != null) {
				int[] vals = Arrays.stream(line.split(" "))
										.mapToInt(Integer::parseInt)
										.toArray();
				if (vals.length == 2) {
					graph = null;
					src = 0;
					count = 0;
					graph = new Graph(vals[0], vals[1]);
				} else if (vals.length == 1) {
					src = vals[0];
				} else if (vals.length == 3) {
					graph.edges[count].from = vals[0];
					graph.edges[count].to = vals[1];
					graph.edges[count].weight = vals[2];
					count++;
					if(count == graph.e){
						graph.SolveByBellmanFord(graph, src);
					}
				}
			}
		} catch (Exception e){
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			System.out.println(sw.toString());
		}
	}
}