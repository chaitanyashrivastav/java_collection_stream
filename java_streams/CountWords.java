import java.io.*;
import java.util.*;

public class CountWords {
    public static void main(String[] args) {
        BufferedReader reader = null;
        Map<String, Integer> wordCount = new HashMap<>();

        try {
            reader = new BufferedReader(new FileReader("input.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }

            wordCount.entrySet().stream()
                    .sorted((entry1, entry2) -> entry2.getValue() - entry1.getValue())
                    .limit(5)
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                System.out.println("Error closing reader: " + e.getMessage());
            }
        }
    }
}
