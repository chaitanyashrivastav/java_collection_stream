import java.util.HashMap;

public class merge_maps {
  public static void main(String[] args) {
    HashMap<String , Integer> map1 = new HashMap<>() ; 
    HashMap<String , Integer> map2 = new HashMap<>() ; 

    map1.put("A", 1) ; 
    map1.put("B", 2) ;
    
    map2.put("B", 3) ; 
    map2.put("C", 4) ; 

    HashMap<String , Integer> ans = new HashMap<>() ; 
    
    for (var entry : map1.entrySet()) {
      if (!ans.containsKey(entry.getKey())) {
        ans.put(entry.getKey(), entry.getValue()); 
      }
    }

    for(var entry : map2.entrySet()){
      if(!ans.containsKey(entry.getKey())){
        ans.put(entry.getKey(), entry.getValue()); 
      }
      else{
        ans.put(entry.getKey(), ans.get(entry.getKey()) + entry.getValue()) ; 
      }
    }

    System.out.println(ans);
  }
}
