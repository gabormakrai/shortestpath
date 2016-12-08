package sp.benchmark;

import java.util.Random;

import sp.Graph;
import sp.ShortestPathAlgorithm;
import sp.bf.BellmanFord;
import sp.data.GraphParser;
import sp.data.StaticData;
import sp.dij.NaiveDijkstra;
import sp.dijpqbh.BinaryHeapPriorityQueueDijkstra;
import sp.dijpqfh.FibonacciHeapPriorityQueueDijkstra;
import sp.dp.DEsopoPapeDeque;
import sp.dp.DEsopoPapeTwoQueue;
import sp.slf.SmallLabelFront;
import sp.spt.ShortestPathTreeFIFO;
import sp.spt.ShortestPathTreeLIFO;

public class BenchmarkMain {
	
	public static final ShortestPathAlgorithm[] algorithms = new ShortestPathAlgorithm[] { 
		new BellmanFord(), 
		new NaiveDijkstra(), 
		new BinaryHeapPriorityQueueDijkstra(), 
		new ShortestPathTreeLIFO(), 
		new ShortestPathTreeFIFO(), 
		new DEsopoPapeDeque(), 
		new DEsopoPapeTwoQueue(), 
		new SmallLabelFront(),
		new FibonacciHeapPriorityQueueDijkstra()
	};
	
	public static final String[] locations = new String[] { StaticData.yorkGraph }; 
	
	public static void main(String[] args) {
		for (String location : locations) {
			runBenchmark(location);
		}
	}
	
	private static void runBenchmark(String fileName) {
		Graph graph = new GraphParser().parseGraph(fileName);
		int[] originDestinations = generateRandomOriginDestinations(graph);
		
		for (ShortestPathAlgorithm algo : algorithms) {
			System.out.println(algo.getClass().getSimpleName() + ": " + new BenchmarkScenario(graph, originDestinations, algo).run().getAverageRuntime());
		}		
	}
	
	private static int[] generateRandomOriginDestinations(Graph graph) {
		
		int numberOD = graph.nodes / 20;
		
		boolean[] nodeInOD = new boolean[graph.nodes];
		Random random = new Random(42);
		int[] originDestinations = new int[numberOD];
		for (int i = 0; i < originDestinations.length; ++i) {
			while (true) {
				int candidate = random.nextInt(graph.nodes);
				if (nodeInOD[candidate]) {
					continue;
				}
				nodeInOD[candidate] = true;
				originDestinations[i] = candidate;
				break;
			}
			
		}
		return originDestinations;
	}
	
}
