import java.util.ArrayList;
import java.util.Arrays;

public class duplicates {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 2, 2, 3, 4));
    ArrayList<Integer> newList = new ArrayList<>();

    for (int i = 0; i < list.size(); i++) {
      if (!newList.contains(list.get(i))) {
        newList.add(list.get(i));
      }
    }

    for (int i = 0; i < newList.size(); i++) {
      System.out.print(newList.get(i)+" ");
    }
  }
}