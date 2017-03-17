import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Graph {
	int v, e;
	Edge edges[];

	Graph(int v, int e) {
		this.v = v;
		this.e = e;
		edges = new Edge[e];
		for (int i = 0 ; i < e; i++) {
            edges[i] = new Edge();
		}
	}

	void SolveByBellmanFord(Graph graph, int src) {

		long start = System.nanoTime();

        int v = graph.v;
        int e = graph.e;
        int dist[] = new int[v];
 
        for (int i = 0; i < v; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;

        for (int i=1; i < v; i++) {
            for (int j = 0; j < e; j++) {
                int u = graph.edges[j].from;
                int w = graph.edges[j].to;
                int weight = graph.edges[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[w]){
                    dist[w]=dist[u]+weight;
                }
            }
        }

        long end = System.nanoTime();
        long microseconds = (end - start) / 1000;

        System.out.println("Time for " + v + " vertices and " + e + " edges is : " +  microseconds + " microseconds");
        System.out.println((v * e) + " --> " +  microseconds);

    	printToOutputFile(dist, v);
    }

    void printToOutputFile(int[] dist, int v){
    	try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt", true))) {
	    	for(int i = 0; i < v; i++){
	    		String content = i+"\t"+dist[i]+"\n";
	    		if(dist[i] == Integer.MAX_VALUE){
	    			content = i+"\tInfinte (vertex disjoint graph)\n";
	    		}
				bw.write(content);
	    	}
	    	bw.write("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}