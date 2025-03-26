import java.util.* ; 

public class rotate_k {
  public static void rotate( ArrayList<Integer> list , int k ){
    List<Integer> rotatedList = new ArrayList<>() ; 

    // Ensure the positions are within the bounds of the list length
    int positions = k % list.size() ; 
    rotatedList.addAll(list.subList(positions, list.size())) ; //list.sublist() is like adding a sublist from a given index to ending index provided 
    rotatedList.addAll(list.subList(0, positions)) ;

    System.out.println(rotatedList);
  }
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50)) ;
    rotate(list , 2) ;
  }
}
