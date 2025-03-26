import java.util.Arrays;
import java.util.HashSet;

public class subset_set {
  public static void main(String[] args) {
    HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4)) ;
    HashSet<Integer> set2 = new HashSet<>(Arrays.asList(2,3)) ;

    
    System.out.println(set1.containsAll(set2));//.containsAll() can have arguments passed of collection type and .contains() of object type
  }
}
