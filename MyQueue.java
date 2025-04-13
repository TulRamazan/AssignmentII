public class MyQueue<T> {
    private MyList<T> list;
    public MyQueue() {
        list = new MyLinkedList<>();
    }
    public void enqueue(T item) {
        list.addLast(item); // Add to the end of the queue
    }
    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        T front = list.getFirst();
        list.removeFirst(); // Remove from the front
        return front;
    }
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return list.getFirst();
    }
    public boolean isEmpty() {
        return list.size() == 0;
    }
    public int size() {
        return list.size();
    }
    public void clear() {
        list.clear();
    }
    @Override
    public String toString() {
        Object[] items = list.toArray();
        StringBuilder sb = new StringBuilder("Front -> ");
        for (Object item : items) {
            sb.append(item).append(" ");
        }
        sb.append("<- Rear");
        return sb.toString();
    }
}