import java.util.* ; 

public class set_sortedList {
  public static void main(String[] args) {
    HashSet<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1)) ; 
    
    //Converting set to a list
    List<Integer> setTolist = new ArrayList<>(set) ;
    for (int i = 0; i < setTolist.size(); i++) {
      for (int j = 0; j < setTolist.size()-i-1; j++) {
        if(setTolist.get(i)>setTolist.get(i)){
          int temp = setTolist.get(i) ; 
          setTolist.set(i, setTolist.get(i+1)) ;
          setTolist.set(i+1, temp) ;  
        }
      }
    }

    //converted back to the HashSet 
    set = new HashSet<>(setTolist) ; 
    System.out.println(set);
  }
}
