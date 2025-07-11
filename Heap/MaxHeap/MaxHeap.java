import java.util.*;

public class MaxHeap {
    private ArrayList<Integer> heap;

    public MaxHeap() {
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

        while (index > 0 && heap.get(parent(index)) < heap.get(index)) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public int extractMax() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        int max = heap.get(0);

        if (heap.size() == 1) {
            heap.remove(0);
        } else {
            heap.set(0, heap.remove(heap.size() - 1));
            heapify(0);
        }

        return max;
    }

    private void heapify(int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            largest = left;
        }

        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    public void printHeap() {
        System.out.println(heap);
    }

    // Demo
    public static void main(String[] args) {
        MaxHeap h = new MaxHeap();
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

        System.out.println("Extracted Max: " + h.extractMax());
        h.printHeap();
    }
}
