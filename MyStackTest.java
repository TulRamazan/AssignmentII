public class MyStackTest {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        System.out.println("Pushing 12, 24, 36 onto the stack...");
        stack.push(12);
        stack.push(24);
        stack.push(36);
        System.out.println("Stack contents: " + stack); // Expected: Top -> 36 24 12
        System.out.println("Peek: " + stack.peek()); // Expected: 30
        System.out.println("Popping: " + stack.pop()); // Expected: 30
        System.out.println("Stack after pop: " + stack); // Expected: Top -> 24 12
        System.out.println("Size: " + stack.size()); // Expected: 2
        System.out.println("Is empty? " + stack.isEmpty()); // Expected: false
        stack.clear();
        System.out.println("Cleared the stack.");
        System.out.println("Is empty? " + stack.isEmpty()); // Expected: true
        // Edge case
        try {
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Exception on pop (as expected): " + e.getMessage());
        }
    }
}
