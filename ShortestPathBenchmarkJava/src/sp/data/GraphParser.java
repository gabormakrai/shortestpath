package sp.data;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import sp.Graph;

public class GraphParser {
	
	public Graph parseGraph(String filename) {
		try {
			Scanner scanner = new Scanner(new File(filename));
			int arcs = scanner.nextInt();
			int nodes = scanner.nextInt();
			int[][] neighbours = new int[nodes][];
			double[][] weights = new double[nodes][];
			for (int i = 0; i < nodes; ++i) {
				int neighbour = scanner.nextInt();
				neighbours[i] = new int[neighbour];
				weights[i] = new double[neighbour];
				for (int j = 0; j < neighbour; ++j) {
					neighbours[i][j] = scanner.nextInt();
					weights[i][j] = scanner.nextDouble();
				}
			}
			scanner.close();
			return new Graph(nodes, arcs, neighbours, weights);
		} catch (IOException e) {
			System.err.println("Problem with the file " + filename);
			e.printStackTrace();
			return null;
		}
	}
	
}
