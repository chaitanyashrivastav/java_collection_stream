import java.util.ArrayList;

public class supressing_Warnings {
  public static void main(String[] args) {

    @SuppressWarnings("unchecked")
    ArrayList list = new ArrayList();
    list.add("Sample");
    list.add(123);

  }

}
