import static java.util.Collections.swap;

public class Heapsort {
    private static <T extends Comparable<? super T>> boolean greaterThan(T a, T b){
        return a.compareTo(b) > 0;
    }

    private static int left(int k){
        return 2 * k + 1;
    }

    private static int right(int k){
        return 2 * k + 2;
    }

    private static <T extends Comparable<? super T>> void maxHeapify(T[] a, int root, int heapSize) {
        int left = left(root);
        int right = right(root);
        int largest = root;
        
        if (left < heapSize && greaterThan(a[left], a[largest])) {
            largest = left;
        }

        if (right < heapSize && greaterThan(a[right], a[largest])) {
            largest = right;
        }

        if (largest != root) {
            swap(a, root, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public static <T extends Comparable<? super T>> void heapsort(T[] a) {
        int n = a.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(a, i, n);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i);
            maxHeapify(a, 0, i);
        }
    }

    private static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
