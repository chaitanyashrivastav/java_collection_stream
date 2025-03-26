import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class map_count {
  public static void main(String[] args) {
    String filePath = "hello.txt";
    HashMap<String, Integer> readMap = new HashMap<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;

      while ((line = reader.readLine()) != null) {
        String[] words = line.toLowerCase().split("\\W+"); // splitting the sentence on the basis of punctuation marks

        for (String word : words) {
          readMap.put(word, readMap.getOrDefault(word, 0) + 1);

        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("Word count: ");

    for (var entry : readMap.entrySet()) {//var -> compiler auto deteremines the type of variable at the compile time based on the assigned value...
      
      System.out.println(entry.getKey() + " : " + entry.getValue());
    }
  }
}
