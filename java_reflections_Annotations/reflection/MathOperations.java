import java.lang.reflect.Method;
import java.util.Scanner;

public class MathOperations {
  int add(int a, int b) {
    return a + b;
  }

  int subract(int a, int b) {
    return a - b;
  }

  int multiply(int a, int b) {
    return a * b;
  }

  public static void main(String[] args) {
    try {
      MathOperations mo = new MathOperations();
      Method[] methods = mo.getClass().getDeclaredMethods();

      Scanner sc = new Scanner(System.in);
      String str = sc.nextLine() ; 
      for (Method method : methods) {
        if (method.getName().equals(str)) {
          System.out.println(method.invoke(mo, 2,3));
        }
        else{
          throw new Exception("no such method") ; 
        }
      }
    } catch (Exception e){}
  }
}
