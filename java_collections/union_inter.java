import java.util.Arrays;
import java.util.HashSet;

public class union_inter {
  public static void main(String[] args) {
    HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
    HashSet<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

    HashSet<Integer> union = new HashSet<>();
    HashSet<Integer> intersection = new HashSet<>() ; 

    for(Integer num : set1){
      if (union.contains(num)) {
        intersection.add(num) ; 
      }
      union.add(num) ; 
    }
    for(Integer num : set2){
      if (union.contains(num)) {
        intersection.add(num) ; 
      }
      union.add(num) ; 
    }

    System.out.println("Intersection Set: "+intersection);
    System.out.println("Union Set: "+union);

  }
}
