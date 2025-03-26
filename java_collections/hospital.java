import java.util.*;

class Patient {
  String name;
  int val;

  Patient(String name, int val) {
    this.name = name;
    this.val = val;
  }

  @Override
  public String toString() {
    return name + " : " + val;
  }

}

public class hospital {
  public static void main(String[] args) {
    PriorityQueue<Patient> pq = new PriorityQueue<>(
        (p1, p2) -> Integer.compare(p2.val, p1.val)
    ); // Max-heap pq

    pq.add(new Patient("John", 3));
    pq.add(new Patient("Alice", 5));
    pq.add(new Patient("Bob", 2));

    System.out.println("Order: ");

    while (!pq.isEmpty()) {
      System.out.println(pq.remove());
    }
  }
}
