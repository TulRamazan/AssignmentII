import java.util.Comparator;
public class MyMinHeap<T extends Comparable<T>> {
    private MyList<T> heap;
    public MyMinHeap() {
        heap = new MyArrayList<>();
    }
    public void insert(T item) {
        heap.addLast(item);
        heapifyUp(heap.size() - 1);
    }
    public T extractMin() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        T min = heap.get(0);
        T last = heap.get(heap.size() - 1);
        heap.set(0, last);
        heap.removeLast();
        heapifyDown(0);
        return min;
    }
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }
    public boolean isEmpty() {
        return heap.size() == 0;
    }
    public int size() {
        return heap.size();
    }
    public void clear() {
        heap.clear();
    }
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIdx = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIdx)) < 0) {
                swap(index, parentIdx);
                index = parentIdx;
            } else {
                break;
            }
        }
    }
    private void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }
            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    @Override
    public String toString() {
        Object[] items = heap.toArray();
        StringBuilder sb = new StringBuilder("Heap: ");
        for (Object item : items) {
            sb.append(item).append(" ");
        }
        return sb.toString();
    }
}