public class MyStack<T> {
    private MyList<T> list;
    public MyStack() {
        list = new MyArrayList<>();
    }
    public void push(T item) {
        list.addLast(item); // Push to the end
    }
    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        T top = list.getLast();
        list.removeLast();
        return top;
    }
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return list.getLast();
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
        StringBuilder sb = new StringBuilder("Top -> ");
        for (int i = items.length - 1; i >= 0; i--) {
            sb.append(items[i]).append(" ");
        }
        return sb.toString();
    }
}
