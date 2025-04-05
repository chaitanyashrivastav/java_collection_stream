import java.lang.reflect.Method;

public class Execution_Main {
  @LogExecutionTime
  long loggedTime_1() {
    long beginningtime = System.nanoTime();
    String str = "hello" ; 

    return System.nanoTime() - beginningtime;
  }

  @LogExecutionTime
  long loggedTime_2() {
    long beginningtime = System.nanoTime();
    int [] arr = new int[10] ; 
    for (int i = 0; i < 10; i++) {
      arr[i] = i ; 
    }
    return System.nanoTime() - beginningtime;
  }

  public static void main(String[] args) {
    Execution_Main obj = new Execution_Main();

    try {
      Method methods[] = Execution_Main.class.getDeclaredMethods();
      for (Method method : methods) {
        if (method.isAnnotationPresent(LogExecutionTime.class)) {
          System.out.println("Method: " + method.getName());
          System.out.println(method.invoke(obj));
          System.out.println("--------------");
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
