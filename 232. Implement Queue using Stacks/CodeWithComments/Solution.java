import java.util.Stack;

class MyQueue {
    // Two stacks to implement the queue operations
    private Stack<Integer> s1; // Stack used for push operations
    private Stack<Integer> s2; // Stack used for pop and peek operations

    // Constructor initializes two empty stacks
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // Push an element to the back of the queue
    public void push(int x) {
        s1.push(x); // Always push into s1
    }

    // Remove and return the front element of the queue
    public int pop() {
        if (s2.isEmpty()) { // If s2 is empty, transfer elements from s1 to s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop()); // Reverse the order by pushing s1 elements into s2
            }
        }
        return s2.pop(); // Pop the front element from s2
    }

    // Return the front element of the queue without removing it
    public int peek() {
        if (s2.isEmpty()) { // If s2 is empty, transfer elements from s1 to s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop()); // Reverse the order
            }
        }
        return s2.peek(); // Return the front element
    }

    // Check if the queue is empty
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty(); // Queue is empty if both stacks are empty
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);    // Push element x into the queue
 * int param_2 = obj.pop();    // Remove and return the front element
 * int param_3 = obj.peek();   // Return the front element without removing it
 * boolean param_4 = obj.empty(); // Check if the queue is empty
 */
