public class MyLinkedList<T> implements MyList<T> {
    private class Node {
        T value;
        Node next;
        Node prev;
        Node(T value) {
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public void add(T item) {
        addLast(item);
    }
    public void set(int index, T item) {
        Node node = getNode(index);
        node.value = item;
    }
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            Node current = getNode(index);
            Node newNode = new Node(item);
            Node prevNode = current.prev;
            newNode.next = current;
            newNode.prev = prevNode;
            prevNode.next = newNode;
            current.prev = newNode;
            size++;
        }
    }
    public void addFirst(T item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    public void addLast(T item) {
        Node newNode = new Node(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    public T get(int index) {
        return getNode(index).value;
    }
    public T getFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        return head.value;
    }
    public T getLast() {
        if (tail == null) throw new IllegalStateException("List is empty");
        return tail.value;
    }
    public void remove(int index) {
        Node node = getNode(index);
        unlink(node);
    }
    public void removeFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        unlink(head);
    }
    public void removeLast() {
        if (tail == null) throw new IllegalStateException("List is empty");
        unlink(tail);
    }

    private void unlink(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        if (prev == null) head = next;
        else prev.next = next;

        if (next == null) tail = prev;
        else next.prev = prev;

        size--;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }
    public void sort() {
        throw new UnsupportedOperationException("Sort not implemented.");
    }
    public int indexOf(Object object) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.value.equals(object)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        Node current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.value.equals(object)) return index;
            current = current.prev;
            index--;
        }
        return -1;
    }
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.value;
            current = current.next;
        }
        return array;
    }
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private Node current = head;
            public boolean hasNext() {
                return current != null;
            }
            public T next() {
                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }
}
