import java.util.ArrayDeque;

class circular_buffer<Integer> { // type integer
  private ArrayDeque<Integer> queue;
  private int fixedSize;

  circular_buffer(int fixedSize) {
    this.queue = new ArrayDeque<>();
    this.fixedSize = fixedSize;
  }

  public void offer(Integer item) {
    if (queue.size() >= fixedSize) {
      queue.poll(); // remove the first element
    }

    queue.offer(item);
  }

  @Override
  public String toString() {
    return queue.toString() ; 
  }
}

public class FixedSizeQueue {
  public static void main(String[] args) {  
    circular_buffer<Integer> dq = new circular_buffer<>(3) ;
    dq.offer(1);
    dq.offer(2);
    dq.offer(3);

    System.out.print(dq + " ");

    System.out.println();

    dq.offer(4);
    System.out.println(dq);
  }
}
