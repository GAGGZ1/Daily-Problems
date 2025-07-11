import java.util.*;

public class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    public void insert(int value) {
        heap.add(value);
        int index = heap.size() - 1;

        while (index > 0 && heap.get(parent(index)) > heap.get(index)) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public int extractMin() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        int min = heap.get(0);

        if (heap.size() == 1) {
            heap.remove(0);
        } else {
            heap.set(0, heap.remove(heap.size() - 1));
            heapify(0);
        }

        return min;
    }

    private void heapify(int i) {
        int smallest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }

        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    public void printHeap() {
        System.out.println(heap);
    }

    // Demo
    public static void main(String[] args) {
        MinHeap h = new MinHeap();
        h.insert(5);
        h.insert(3);
        h.insert(17);
        h.insert(10);
        h.insert(84);
        h.insert(19);
        h.insert(6);
        h.insert(22);
        h.insert(9);

        h.printHeap();

        System.out.println("Extracted Min: " + h.extractMin());
        h.printHeap();
    }
}
