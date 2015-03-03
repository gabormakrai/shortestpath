package sp.dp;

public class Dequeue {
	
	public int size = 0;

	// Q1
	int[] arrayQ1 = new int[4];
	public int sizeQ1 = 0;
	
	// Q2
	int[] arrayQ2 = new int[4];
	public int sizeQ2 = 0;
	int firstIndexQ2 = 0;
	int lastIndexQ2 = 0;
	
	public void queueQ2(int x) {
		arrayQ2[lastIndexQ2] = x;
		lastIndexQ2 = (lastIndexQ2 + 1) % arrayQ2.length;
		++sizeQ2;
		++size;
		
		if (sizeQ2 == arrayQ2.length) {
			growArrayQ2();
		}
	}
	
	private int dequeueQ2() {
		--sizeQ2;
		int index = firstIndexQ2;
		firstIndexQ2 = (firstIndexQ2 + 1) % arrayQ2.length;
		return arrayQ2[index];
	}
	
	private void growArrayQ2() {
		int[] newArray = new int[arrayQ2.length * 2];
		for (int i = 0, index = firstIndexQ2; i < sizeQ2; ++i) {
			newArray[i] = arrayQ2[index];
			index = (index + 1) % arrayQ2.length;
		}
		firstIndexQ2 = 0;
		lastIndexQ2 = sizeQ2;
		arrayQ2 = newArray;
	}
	
	public void queueQ1(int x) {
		arrayQ1[sizeQ1] = x;
		++sizeQ1;
		++size;
		if (sizeQ1 == arrayQ1.length) {
			growArrayQ1();
		}
	}
	
	private int dequeueQ1() {
		--sizeQ1;
		return arrayQ1[sizeQ1];
	}
	
	private void growArrayQ1() {
		int[] newArray = new int[arrayQ1.length * 2];
		for (int i = 0; i < arrayQ1.length; ++i) {
			newArray[i] = arrayQ1[i];
		}
		arrayQ1 = newArray;
	}
	
	public int dequeue() {
		--size;
		if (sizeQ1 == 0) {
			return dequeueQ2();
		} else {
			return dequeueQ1();
		}
	}
}
