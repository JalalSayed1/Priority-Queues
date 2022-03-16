package minPriorityQueue;

import java.util.Arrays;

/**
 * Part 1a - using array based binary heap
 */
public class MinPriorityQueueUsingArrays {

    private int[] Q;

    public MinPriorityQueueUsingArrays(int[] A) {
        Q = buildMinHeap(A);

    }

    /**
     * Build the min-heap using an array A.
     * Takes O(n log n) time.
     * 
     * @param A array used to build the heap
     * @return the heap
     */
    private int[] buildMinHeap(int[] A) {
        int n = A.length;
        for (int i = ((n / 2) - 1); i >= 0; i--) {
            minHeapify(A, i, n); // O(log n)
        }
        return A;
    }

    /**
     * To maintain the min-heap property on array A.
     * Properties:
     * Root is the smallest element and
     * children of a node are bigger than their parent.
     * Takes O(log n) time.
     * 
     * @param A heap rep as array
     * @param i start index
     * @param n Array "A" length
     */
    private void minHeapify(int[] A, int i, int n) {
        int l = left(i);
        int r = right(i);
        int largest;

        if (l < n && A[l] < A[i]) {
            largest = l;

        } else {
            largest = i;
        }

        if (r < n && A[r] < A[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(A, i, largest);
            minHeapify(A, largest, n);
        }
    }

    /**
     * Swap two elements in array A.
     * 
     * @param A array that contains the required elements to be swapped
     * @param i index of the first element in array A
     * @param j index of the second element in array A
     */
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    /**
     * To find index of the left-child of the parent node at index i.
     * 
     * @param i index of the parent node
     * @return index of the left-child
     */
    public static int left(int i) {
        return (2 * i) + 1;
    }

    /**
     * To find index of the right-child of the parent node at index i.
     * 
     * @param i index of the parent node
     * @return index of the right-child
     */
    public static int right(int i) {
        return (2 * i) + 2;
    }

    /**
     * Insert element x at the correct position in the queue.
     * 
     * @param x element to be added
     */
    public void insert(int x) {
        int[] A = new int[this.Q.length + 1];

        for (int i = 0; i < this.Q.length; i++) { // O(n)
            A[i] = Q[i];
        }
        A[A.length - 1] = x;

        // re build the heap:
        this.Q = buildMinHeap(A);
    }

    /**
     * To find the min element in the queue.
     * Takes O(1) time.
     * 
     * @return min element in the queue
     */
    public int min() {
        // Smallest elt must be at the root (guaranteed by minHeapify)
        int smallest = this.Q[0];
        return smallest;
    }

    /**
     * To find and delete the min element in the queue.
     * 
     * @return min element in the queue that has been deleted
     */
    public int extractMin() {
        int index = 0;// this.Q.length - 1;
        int smallest = this.Q[index];

        // remove the min and shift elts right:
        for (int i = index; i < Q.length - 1; i++) { // O(n)
            this.Q[i] = this.Q[i + 1];
        }
        // fix the heap:
        this.Q = buildMinHeap(Arrays.copyOfRange(Q, 0, Q.length - 1));
        return smallest;
    }

    public int size() {
        return this.Q.length;
    }

    public static void main(String[] args) {

        int[] A = { 15, 10, 8, 6, 4, 1, 4, 5, 2, 1, 3 };

        MinPriorityQueueUsingArrays q = new MinPriorityQueueUsingArrays(A);

        q.insert(17);
        q.insert(18);
        int min = q.min();
        min = q.extractMin();

    }
}
