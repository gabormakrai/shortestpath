package sp.dijpqbh;

public class BinaryHeap {
	
    public int size;
    private int[] lookUpTable;

    // initial size = 4
    private double[] valueArray = new double[4];
    private int[] nodeArray = new int[4];

    public BinaryHeap(int nodeCount) {
        lookUpTable = new int[nodeCount];
    }
    
    public void init(int sourceNode) {
        for (int i = 0; i < lookUpTable.length; ++i) {
            lookUpTable[i] = -1;
        }

        for (int i = 0; i < valueArray.length; ++i) {
            valueArray[i] = Double.POSITIVE_INFINITY;
            nodeArray[i] = -1;
        }

        valueArray[0] = 0.0;
        nodeArray[0] = sourceNode;
        lookUpTable[sourceNode] = 0;
        size = 1;
    }

    public int extractMin() {
        if (size > 0) {
            int minNode = nodeArray[0];

            if (size > 1) {
                exchange(0, size - 1);
                --size;
                heapify(0);
            } else {
                --size;
                nodeArray[0] = -1;
                valueArray[0] = Double.POSITIVE_INFINITY;
            }

            lookUpTable[minNode] = -1;
            return minNode;
        } else {
            return -1;
        }
    }

    public void decreaseKey(int node, double value) {

        if (lookUpTable[node] == -1) { // insert
            insert(node, Double.POSITIVE_INFINITY);
        }
        
        int i = lookUpTable[node];
        valueArray[i] = value;
        int parent = (i - 1) / 2;
        while (i > 0 && valueArray[parent] > valueArray[i]) {
            exchange(i, parent);
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    private void insert(int node, double value) {
        if (size == nodeArray.length) {
            growArrays();
        }
        nodeArray[size] = node;
        valueArray[size] = value;
        lookUpTable[node] = size;
        heapify(size);
        ++size;
    }

    private void growArrays() {
        int newArraySize = nodeArray.length * 2;
        int[] newNodeArray = new int[newArraySize];
        double[] newValueArray = new double[newArraySize];

        // copy the existing data
        for (int i = 0; i < size; ++i) {
            newNodeArray[i] = nodeArray[i];
            newValueArray[i] = valueArray[i];
        }

        for (int i = size; i < newArraySize; ++i) {
            newNodeArray[i] = -1;
            newValueArray[i] = Double.POSITIVE_INFINITY;
        }

        nodeArray = newNodeArray;
        valueArray = newValueArray;
    }

    private void heapify(int i) {
        int l = 2 * i + 1;
        int r = l + 1;

        int largest = 0;
        if (l < size && valueArray[l] < valueArray[i]) {
            largest = l;
        } else {
            largest = i;
        }

        if (r < size && valueArray[r] < valueArray[largest]) {
            largest = r;
        }
        
        if (largest != i) {
            exchange(i, largest);
            heapify(largest);
        }
    }

    private void exchange(int i, int j) {
        int tempLookUp = lookUpTable[nodeArray[i]];
        lookUpTable[nodeArray[i]] = lookUpTable[nodeArray[j]];
        lookUpTable[nodeArray[j]] = tempLookUp;

        int tempNode = nodeArray[i];
        nodeArray[i] = nodeArray[j];
        nodeArray[j] = tempNode;

        double tempValue = valueArray[i];
        valueArray[i] = valueArray[j];
        valueArray[j] = tempValue;
    }
}

