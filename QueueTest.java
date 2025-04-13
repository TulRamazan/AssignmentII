public class QueueTest {
    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();
        System.out.println("Enqueueing: Apple, Banana, Cherry...");
        queue.enqueue("Apple");
        queue.enqueue("Banana");
        queue.enqueue("Cherry");
        System.out.println("Queue contents: " + queue); // Expected: Front -> Apple Banana Cherry <- Rear
        System.out.println("Peek: " + queue.peek()); // Expected: Apple
        System.out.println("Queue after dequeue: " + queue); // Expected: Front -> Banana Cherry <- Rear
        System.out.println("Size: " + queue.size()); // Expected: 2
        System.out.println("Is empty? " + queue.isEmpty()); // Expected: false
        System.out.println("Clearing queue...");
        queue.clear();
        System.out.println("Is empty after clear? " + queue.isEmpty()); // Expected: true
        // Edge case: Dequeue on empty queue
        try {
            queue.dequeue();
        } catch (IllegalStateException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}