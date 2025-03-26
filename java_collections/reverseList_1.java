import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class reverseList_1 {
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5 };
    LinkedList<Integer> list = new LinkedList<>();
    ArrayList<Integer> arrlist = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {
      list.add(arr[i]) ;
      arrlist.add(arr[i]) ; 
    }

    // Create a ListIterator to traverse the LinkedList
    ListIterator<Integer> iterator = list.listIterator();
    ListIterator<Integer> iterator2 = arrlist.listIterator();

    while (iterator.hasNext()) {
      Integer element = iterator.next();
    }

    //above , we took iterator to the last and now we gonna do the back traversal 
    System.out.println("LinkedList reversal: ");
    while (iterator.hasPrevious()) {
        Integer previous = iterator.previous() ; 
        System.out.print(previous+" ");
    }

    System.out.println();
    System.out.println("ArrayList reversal: ");
    //sam process for the arraylist iterator
    while (iterator2.hasNext()) {
        Integer next = iterator2.next() ; 
    }

    while (iterator2.hasPrevious()) {
        Integer previous = iterator2.previous() ; 
        System.out.print(previous+" ");
    }
  }
}
