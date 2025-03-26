import java.util.*;

public class map_invert {
  public static void main(String[] args) {
    HashMap<String , Integer> map = new HashMap<>() ; 
    HashMap<Integer , List<String>> invertedMap = new HashMap<>() ; //using list as the parameter for handling duplicates 

    map.put("A" , 1) ; 
    map.put("B" , 2) ;
    map.put("C" , 1) ;


    for(var entry : map.entrySet()){
      int val = entry.getValue() ; // like 1 is present 2 times
      if (!invertedMap.containsKey(val)) {
        invertedMap.put(val, new ArrayList<>()) ; //new arraylist is added every time for the non-duplicate iteration 
      }
      invertedMap.get(val).add(entry.getKey()) ; 
    }

    System.out.println("Original Map : "+map);
    System.out.println("Inverted Map : " + invertedMap);
  }
}
