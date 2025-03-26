import java.util.HashMap;

public class map_highestVal {
  public static void main(String[] args) {
    HashMap<String, Integer> map = new HashMap<>();
    map.put("A", 10);
    map.put("B", 20);
    map.put("C", 15);

    int max = 0;
    String maxi = "";

    for (var entry : map.entrySet()) {
      if (max < entry.getValue()) {
        max = entry.getValue();
        maxi = entry.getKey() ; 
      }
    }
    
    System.out.println(maxi);
  }
}
