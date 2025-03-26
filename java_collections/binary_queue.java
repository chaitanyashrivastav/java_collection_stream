
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class binary_queue {
  static ArrayList<String> generateBinary(int N ){
    ArrayList<String> ans = new ArrayList<>() ; 
    Queue<String> q = new LinkedList<>() ; 

    q.add("1") ; 

    while (N-- > 0) {
      String temp = q.remove() ; // like pop()
      ans.add(temp) ; //add curr string to the list 

      q.add(temp + "0") ; 
      q.add(temp + "1") ;
    }

    return ans ; 
  }
  public static void main(String[] args) {
    int N = 5 ; 
    System.out.println(generateBinary(N));
  }
}
