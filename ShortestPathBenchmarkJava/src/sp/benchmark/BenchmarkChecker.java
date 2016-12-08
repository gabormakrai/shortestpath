package sp.benchmark;

public class BenchmarkChecker {
	
	public final double epsilon;
	
	public BenchmarkChecker() {
		epsilon = 0.00001;
	}
	
	BenchmarkChecker(double epsilon) {
		this.epsilon = epsilon;
	}
	
	public boolean check(double[]... distances) {
		int length = -1;
		for (double[] distance : distances) {
			if (length == -1) {
				length = distance.length;
			} else if (length != distance.length) {
				return false;
			}
		}
		
		for (int i = 0; i < length; ++i) {
			double value = Double.MAX_VALUE;
			for (double[] distance : distances) {
				if (value == Double.MAX_VALUE) {
					value = distance[i];
				} else if (Math.abs(value - distance[i]) > epsilon) {
					return false;
				}
			}
		}
		
		return true;
	}
}
