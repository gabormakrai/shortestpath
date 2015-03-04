package sp.slf;

public class TwoQueue {
	
	public int size = 0;
	
	int[] arrayQ1 = new int[4];
	private int sizeQ1 = 0;
	int firstIndexQ1 = 0;
	int lastIndexQ1 = 0;
	
	int[] arrayQ2 = new int[4];
	private int sizeQ2 = 0;
	int firstIndexQ2 = 0;
	int lastIndexQ2 = 0;
	
	public void queueQ1(int x) {
		arrayQ1[lastIndexQ1] = x;
		lastIndexQ1 = (lastIndexQ1 + 1) % arrayQ1.length;
		++sizeQ1;
		++size;
		
		if (sizeQ1 == arrayQ1.length) {
			growArrayQ1();
		}
	}
	
	private int dequeueQ1() {
		--sizeQ1;
		int index = firstIndexQ1;
		firstIndexQ1 = (firstIndexQ1 + 1) % arrayQ1.length;
		return arrayQ1[index];
	}
	
	private void growArrayQ1() {
		int[] newArray = new int[arrayQ1.length * 2];
		for (int i = 0, index = firstIndexQ1; i < sizeQ1; ++i) {
			newArray[i] = arrayQ1[index];
			index = (index + 1) % arrayQ1.length;
		}
		firstIndexQ1 = 0;
		lastIndexQ1 = sizeQ1;
		arrayQ1 = newArray;
	}
	
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
	
	public int dequeue() {
		--size;
		if (sizeQ1 == 0) {
			return dequeueQ2();
		} else {
			return dequeueQ1();
		}
	}
		
	public int first() {
		if (sizeQ1 == 0) {
			return arrayQ2[firstIndexQ2];
		} else {
			return arrayQ1[firstIndexQ1];
		}
	}

}
