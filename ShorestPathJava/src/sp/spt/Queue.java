package sp.spt;

public class Queue {
	int[] array = new int[4];
	public int size = 0;
	
	public void queue(int x) {
		array[size] = x;
		++size;
		if (size == array.length) {
			growArray();
		}
	}
	
	public int dequeue() {
		--size;
		return array[size];
	}
	
	private void growArray() {
		int[] newArray = new int[array.length * 2];
		for (int i = 0; i < array.length; ++i) {
			newArray[i] = array[i];
		}
		array = newArray;
	}
}
