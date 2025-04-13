public class MyMinHeapTest {
    public static void main(String[] args) {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        System.out.println("Inserting: 5, 3, 8, 1, 2");
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        System.out.println("Heap after inserts: " + heap); // Should show smallest values at the top of the tree structure
        System.out.println("Peek (min): " + heap.peek()); // Expected: 1
        System.out.println("Extracting min...");
        System.out.println("Extracted: " + heap.extractMin()); // Expected: 1
        System.out.println("Heap now: " + heap); // Next smallest (2) should be on top
        System.out.println("Extracted: " + heap.extractMin()); // Expected: 2
        System.out.println("Extracted: " + heap.extractMin()); // Expected: 3
        System.out.println("Heap now: " + heap);
        System.out.println("Size: " + heap.size()); // Should be 2
        System.out.println("Clearing heap...");heap.clear();
        System.out.println("Is empty? " + heap.isEmpty()); // Expected: true
        // Edge case: extract from empty
        try {
            heap.extractMin();
        } catch (IllegalStateException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}