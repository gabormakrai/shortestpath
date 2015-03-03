package sp.spt;

public class FIFOQueue {
	int[] array = new int[4];
	public int size = 0;
	int firstIndex = 0;
	int lastIndex = 0;
	
	public void queue(int x) {
		array[lastIndex] = x;
		lastIndex = (lastIndex + 1) % array.length;
		++size;
		
		if (size == array.length) {
			growArray();
		}
	}
	
	public int dequeue() {
		--size;
		int index = firstIndex;
		firstIndex = (firstIndex + 1) % array.length;
		return array[index];
	}
	
	private void growArray() {
		int[] newArray = new int[array.length * 2];
		for (int i = 0, index = firstIndex; i < size; ++i) {
			newArray[i] = array[index];
			index = (index + 1) % array.length;
		}
		firstIndex = 0;
		lastIndex = size;
		array = newArray;
	}
}
