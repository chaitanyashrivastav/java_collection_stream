import java.util.Arrays;
import java.util.HashSet;

public class equalSets {
  public static void main(String[] args) {
    HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3)) ; 
    HashSet<Integer> set2 = new HashSet<>(Arrays.asList(3,2,1)) ;
    
    System.out.println(set1.equals(set2));
  }
}
