import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    
    public StackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        if (q1.isEmpty()) {
            return -1; // Stack is empty
        }
        
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        
        int poppedElement = q1.poll();
        
        Queue<Integer> temp = q1;                                            
        q1 = q2;
        q2 = temp;
        
        return poppedElement;
    }
    
    public int top() {
        if (q1.isEmpty()) {
            return -1; // Stack is empty
        }
        
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        
        int topElement = q1.poll();
        q2.add(topElement);
        
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        
        return topElement;
    }
    
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); // Output: 3
    }
}
