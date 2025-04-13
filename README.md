1) MyList<T> – The Interface
MyList<T> is a custom interface that defines a blueprint for list-like data structures that extends Iterable<T>, allowing iteration through elements using for-each loops or an Iterator.
🔧 It defines the following operations:
   
       Add/remove/get elements by index or position (start/end)
       Check if an element exists
       Sort the list
       Convert to an array
       Clear the list
       Track size and positions

This interface ensures consistency between different list implementations (like arrays or linked lists).

2) MyArrayList<T> – Array-based List Implementation
MyArrayList<T> is an implementation of MyList<T> using a resizable array (like Java's ArrayList but built from scratch).
Internals:

       Uses an Object[] array to hold items
       A size counter tracks the number of actual elements
       Automatically resizes the array when full (usually by doubling capacity)
   

 Key Operations:

    Fast random access with get(index)
    Efficient addLast() and get(index)
    Slower insert/remove at the beginning or middle (because shifting is required)

Thus, this list is the most suitable for:
        
        Index-based access
        Situations where items are mostly added to the end


3)  MyLinkedList<T> – Doubly Linked List Implementation

MyLinkedList<T> is another MyList<T> implementation, but it uses nodes instead of arrays.
  Internals:

    Each node has a value, a reference to the next node, and one to the previous node
    Maintains head and tail pointers for fast add/remove from both ends
    Keeps a size counter

  Key Operations:

    Efficient addFirst(), addLast(), removeFirst(), removeLast()
    Slower get(index) (requires traversal)
    Does not need to resize like an array

  ✅ The most suitable list for:

    Frequent insertions/removals at either end
    Queue and stack backing structure
    Avoiding resizing cost

4) MyStack<T> – LIFO (Last-In, First-Out) Structure

MyStack<T> is a custom stack implementation based on a MyArrayList<T> or MyLinkedList<T> (depending on your choice). It follows the Last-In and First-Out principle — the most recently added item is the first one to be removed.
  Core operations:

    push(T item) → adds item to the top
    pop() → removes and returns the top item
    peek() → returns the top item without removing it
    isEmpty() and size() → utility methods
    
Internal behavior:

    Implemented using addLast() and removeLast() from the backing list
    Can be built on either MyArrayList or MyLinkedList
    Efficient when using MyLinkedList, since no shifting is required

Real-life analogy:
    
    Like a stack of plates — you take the top one first.

5) MyQueue<T> – FIFO (First-In, First-Out) Structure

MyQueue<T> is a custom queue implementation using MyLinkedList<T> as the underlying data structure. It works on a First-In, First-Out basis — the first item added is the first one out.
Core operations:

    enqueue(T item) → adds item to the end
    dequeue() → removes and returns the front item
    peek() → returns the front item with deleting it
    isEmpty() and size() → utility methods

 Internal behavior:

    Efficient with MyLinkedList, using addLast() for enqueue and removeFirst() for dequeue
    Keeps insertion and removal at O(1) time complexity
 
 Real-life analogy:

    Like a line at a checkout — first person in is served first.

6) MyMinHeap<T> – Binary Min-Heap
 What it is:
MyMinHeap<T> is a priority queue-style data structure that always keeps the smallest element at the root (top). It’s implemented using a binary heap stored in a dynamic array (MyArrayList<T>).
Core operations:

        insert(T item) → adds a new item and rebalances the heap using heapify up
        extractMin() → removes and returns the smallest item, then rebalances using heapify down
        peek() → gets the smallest item without removing it
        isEmpty(), size(), clear() → utility methods

Internal behavior:

    Maintains heap property: every parent is smaller than its children
    Stored in an array, where:
    Parent index = (i - 1) / 2
    Left child = 2*i + 1, Right child = 2*i + 2
    Insertions and deletions are O(log n)

Real-life analogy:

    Like a to-do list sorted by urgency — the most important (lowest value) task is always on top.
