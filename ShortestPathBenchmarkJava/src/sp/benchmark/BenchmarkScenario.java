package sp.benchmark;

import java.util.Arrays;

import sp.Graph;
import sp.ShortestPathAlgorithm;

public class BenchmarkScenario {
	
	final int runs = 20;
	
	long[] startTimes = new long[runs];
	
	long[] endTimes = new long[runs];
	
	int skipLowerRuns = 3;
	
	int skipHigherRuns = 3;
	
	ShortestPathAlgorithm spAlgorithm;
	
	Graph graph;
	
	int[] originDestinations;
	
	double[] distances;
	
	public BenchmarkScenario(Graph graph, int[] originDestinations, ShortestPathAlgorithm spAlgorithm) {
		this.graph = graph;
		this.originDestinations = originDestinations;
		this.spAlgorithm = spAlgorithm;
		
		spAlgorithm.init(graph);
		distances = new double[graph.nodes];
	}
		
	public double getAverageRuntime() {
		long[] runtimes = new long[runs];
		for (int i = 0; i < runs; ++i) {
			runtimes[i] = endTimes[i] - startTimes[i];
		}
		
		Arrays.sort(runtimes);
		
		double averageTime = 0.0;
		for (int i = skipLowerRuns; i < runs - skipHigherRuns; ++i) {
			averageTime += runtimes[i];
		}
		averageTime /= (double)(runs - skipHigherRuns - skipLowerRuns) * 1000000.0;
		
		return averageTime;
	}
	
	public BenchmarkScenario run() {
		for (int r = 0; r < runs; ++r) {
			startTimes[r] = System.nanoTime();
			for (int i = 0; i < originDestinations.length; ++i) {
				spAlgorithm.calculate(originDestinations[i], originDestinations, distances);
			}
			endTimes[r] = System.nanoTime();
		}
		return this;
	}
}
