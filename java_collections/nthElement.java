
import java.util.Arrays;
import java.util.LinkedList;

public class nthElement {
  public static void main(String[] args) {
    LinkedList<Character> list = new LinkedList<>(Arrays.asList('A', 'B', 'C', 'D', 'E')) ;
    int pos = 2 ;
    char ch = '\0' ; 
    
    for (int i = list.size()-1; i >= 0; i--) {
      pos-- ; 
      if (pos == 0 ) {
        ch = list.get(i) ; 
      }
    }
    System.out.println(ch);
  }
}
