import java.util.*;

public class reverseQueue {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));

    while (!queue.isEmpty()) {
      stack.add(queue.remove()); // first 10 is added and then subsequently ...
    }

    while (!stack.isEmpty()) {
      queue.add(stack.pop()) ; 
    }

    System.out.println(queue);
  }
}
